
package traslation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelTraslation extends JPanel {
    private int pw, ph, dx, dy;
    private double x, y;
    private Shape ellipse;
    private AffineTransform at_traslation;
    private Timer tim;
    
    public PanelTraslation() {
        pw = 1000;
        ph = 500;
        dx = 5;
        dy = 5;
        
        ellipse = new Ellipse2D.Double( 250, 10, 10, 10 );
        
        at_traslation = new AffineTransform();
        
        this.setLayout( null );
        this.setPreferredSize( new Dimension( pw, ph ) );
        this.setBackground( Color.WHITE );
        
        tim = new Timer( 10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveEllipse();
                repaint();
            }
        });
        tim.start();
    }
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor( Color.RED );
        g2.fill( ellipse );
    }
    public void moveEllipse() {
        x = ellipse.getBounds().getX();
        y = ellipse.getBounds().getY();
        
        if( x == 0 ) {
            dx = 5;
        }
        if( ( x + 10 ) > pw ) {
            dx = -5;
        }
        if( y <= 0 ) {
            dy = 5;
        }
        if ( ( y + 10 ) > ph ) {
            dy = -5;
        }
        at_traslation.setToTranslation(dx, dy);
        ellipse = at_traslation.createTransformedShape( ellipse );
    }
}
