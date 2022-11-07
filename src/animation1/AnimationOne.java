
package animation1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 * @author Mendoza Castañeda José Ricardo
 */

public class AnimationOne extends JPanel implements KeyListener {
    private int pw, ph, x, y;
    private double scale, trasl_x, trasl_y;
    private AffineTransform at_scale, at_trasl;
    private Shape ell;
    
    public AnimationOne() {
        pw = 500;
        ph = 500;
        x = (pw / 2) - ( 10 / 2); 
        y = (ph / 2) - ( 10 / 2); 
        
        scale = 1;
        trasl_x = 0;
        trasl_y = 0;
        ell      = new Rectangle2D.Double( 245, 245, 10, 10 );
        at_scale = new AffineTransform();
        at_trasl = new AffineTransform();
        
        this.setPreferredSize( new Dimension( pw, ph ) );
        this.setBackground( Color.BLACK );
        this.setFocusable( true );
        this.addKeyListener( this );
    }

    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor( Color.WHITE );
        g2.draw( ell );
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        switch( e.getKeyCode() ) {
            case KeyEvent.VK_UP:
                scale = 2;
                trasl_x = obtenerCTRASL( x );
                trasl_y = obtenerCTRASL( y );
                break;
            case KeyEvent.VK_DOWN:
                scale = 0.5;
                
                break;
        }
        at_scale.setToScale( scale, scale );
        ell = (Shape) at_scale.createTransformedShape( ell );
        at_trasl.setToTranslation( trasl_x, trasl_y );
        ell = at_trasl.createTransformedShape( ell );
        
        System.out.println("------------------------------");
        System.out.println("Xd: " + ell.getBounds().getX() );
        System.out.println("------------------------------");
        
        repaint();
    }
    public double obtenerCTRASL( int pos ) {
        double c = pos + ( 10 / 2 );
        System.out.println( c );
        return -c;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
