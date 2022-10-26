
package desarrollodesoftware;

import javax.swing.JFrame;
import traslation.PanelTraslation;

/**
 * @author Mendoza Castañeda José Ricardo
 */

public class AnimacionEllipse {

    public static void main(String[] args) {
        JFrame frm = new JFrame("Animaciones");
        // PanelAnimacion p = new PanelAnimacion();
        // Panel para animacion del circulo.
        PanelTraslation p = new PanelTraslation();
        frm.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frm.add( p );
        frm.pack();
                
        frm.setVisible( true );
    }
    
}
