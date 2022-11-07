
package exam_panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Mendoza Castañeda José Ricardo
 */

public class Examen_M extends JPanel implements KeyListener {
    private int pw, ph, xe, ye, i;
    private Shape rectangle, ellipse;
    private boolean limitUp, limitDown, muestra, teclea;
    private AffineTransform at_rot, at_tras;
    private Timer t;
    
    public Examen_M() {
        i = 0;
        pw = 500;
        ph = 500;
        xe = 10;
        ye = 0;
        
        muestra = false;
        teclea  = true;
        
        rectangle   = new Rectangle2D.Double( 0, 240, 100, 20 );
        ellipse     = new Ellipse2D.Double( 110, 245, 20, 20 );
        at_rot      = new AffineTransform();
        at_tras     = new AffineTransform();
        
        t = new Timer( 50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                at_tras.setToTranslation( xe, ye );
                ellipse = at_tras.createTransformedShape(ellipse);
                teclea = false;
                
                repaint(); 
                
                if( ellipse.getBounds().getY() < 0 || ellipse.getBounds().getY() > ph || ellipse.getBounds().getX() > pw ) {
                    t.stop();
                    
                    teclea = true;
                    
                    ellipse = new Ellipse2D.Double( 110, 245, 20, 20 );
                    at_rot.setToRotation( Math.toRadians( 45 * i ), 0, 250 );
                    ellipse = at_rot.createTransformedShape( ellipse );
                    
                    muestra = false;
                }
            }
        });
        
        this.setLayout( null );
        this.setPreferredSize( new Dimension( pw, ph ) );
        this.setBackground( Color.BLACK );
        this.setFocusable( true );
        this.addKeyListener( this );
    }
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor( Color.WHITE );
        g2.fill( rectangle );
        
        if( muestra  ) 
            g2.fill( ellipse );
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if( teclea ) {
            switch( e.getKeyCode() ) {
            case KeyEvent.VK_DOWN:
                
                if( !limitDown ) {
                    limitUp = false;
                    i++;
                    at_rot.setToRotation( Math.toRadians( 45 ), 0, 250 );
                    rectangle = at_rot.createTransformedShape( rectangle );
                    ellipse = at_rot.createTransformedShape( ellipse );
                    ye = ye + 10;
                    xe = 10;
                    
                    
                    if( rectangle.getBounds().getX() == ( -10 ) ) {
                        xe = 0;
                        limitDown = true;
                    } 
                }
                
                break;
            case KeyEvent.VK_UP:
                if( !limitUp ) {
                    i--;
                    limitDown = false;
                    at_rot.setToRotation( Math.toRadians( -45 ), 0, 250 );
                    rectangle = at_rot.createTransformedShape( rectangle );
                    ellipse = at_rot.createTransformedShape( ellipse );
                    ye = ye - 10 ;
                    xe = 10;
                    
                    if( rectangle.getBounds().getX() == ( -10 ) ) {
                        xe = 0;
                        limitUp = true;
                    }
                }
                break;
                
            case KeyEvent.VK_S:
                
                muestra = true;
                t.start();
                
                break;
        }
        
        repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
}
