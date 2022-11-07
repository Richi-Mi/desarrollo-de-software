
package lines;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author Mendoza Castañeda José Ricardo
 */

public class LinePanel extends JPanel implements KeyListener {
    private int x, y, pw, ph;
    private ArrayList<Line2D> lineas;
    
    public LinePanel() {
        x = 300;
        y = 200;
        pw = 600;
        ph = 400;
        
        lineas = new ArrayList<Line2D>(10);
        
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
        for( int i = 0; i < lineas.size(); i++ ){
            g2.draw( lineas.get( i ) );
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Line2D linea;
        switch( e.getKeyCode() ) {
            case KeyEvent.VK_RIGHT:
                linea = new Line2D.Double( x, y, (x + 10), y );
                x = x + 10;
                break;
            case KeyEvent.VK_LEFT:
                linea = new Line2D.Double( x, y, (x - 10), y );
                x = x - 10;
                break;
            case KeyEvent.VK_DOWN:
                linea = new Line2D.Double( x, y, x, ( y + 10 ) );
                y = y + 10;
                break;
            case KeyEvent.VK_UP:
                linea = new Line2D.Double( x, y, x, ( y - 10 ) );
                y = y - 10;
                break;
            default:
                linea = null;
        }
        if( linea != null ) {
            lineas.add( linea );
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
}