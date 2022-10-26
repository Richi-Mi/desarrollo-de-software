
package desarrollodesoftware;

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

// Programa para hacer crecer la elipse.

public class PanelAnimacion extends JPanel {
    private int pd;
    private Timer tim;
    private boolean scale;
    private Shape ellipse, ellipse2;
    private AffineTransform at_scale, at_traslation;
    
    public PanelAnimacion() {
        pd = 500;
        
        ellipse = new Ellipse2D.Double( 245, 245, 10, 10 );
        ellipse2 = new Ellipse2D.Double( 240, 240, 20, 20 );
        
        scale = true;
        at_scale = new AffineTransform();
        at_traslation = new AffineTransform();
        
        this.setLayout( null );
        this.setPreferredSize( new Dimension( pd, pd ) );
        
        tim = new Timer( 50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if( scale )
                    scaleBig();
                if( !scale )
                    scaleLow();
                repaint();
            }
        });
        tim.start();
    }
    private void scaleBig() {
        double scala = 2;
        double trans = -( pd / 2 );
        
        double trans_2 = -( pd / 2 );
        
        ellipse = scaleEll( trans, scala, ellipse );
        ellipse2 = scaleEll( trans_2, scala, ellipse2 );
        
        if( ellipse.getBounds().getWidth() >= pd ) 
            scale = false;
        
    }
    private void scaleLow() {
        ellipse = new Ellipse2D.Double( 245, 245, 10, 10 );
        ellipse2 = new Ellipse2D.Double( 240, 240, 20, 20 );
        scale = true;
        /**
         * Codigo para que haga pequeña.
            double trans = 125;
            double scala = 0.5;
        
            scaleEll( trans, scala );
        
            if( ellipse.getBounds().getWidth() == 10 ) 
                scale = true;
        */
    }
    public Shape scaleEll( double trans, double scale, Shape figura ) {
        at_scale.setToScale( scale, scale );
        figura = at_scale.createTransformedShape( figura );
        
        at_traslation.setToTranslation( trans, trans );
        figura = at_traslation.createTransformedShape( figura );
        
        return figura;
    }
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor( Color.RED );
        g2.draw( ellipse );
        g2.setColor( Color.BLUE );
        g2.draw( ellipse2 );
    }
}
