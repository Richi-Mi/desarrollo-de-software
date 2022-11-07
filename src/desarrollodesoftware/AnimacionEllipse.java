
package desarrollodesoftware;

import javax.swing.JFrame;
import animation1.AnimationOne;
import exam_panel.Examen_M;
import lines.LinePanel;

/**
 * @author Mendoza Castañeda José Ricardo
 */

public class AnimacionEllipse {

    public static void main(String[] args) {
        JFrame frm = new JFrame("Animaciones");
        
        // PanelAnimacion p = new PanelAnimacion();
        // Panel para animacion del circulo.
        
        // PanelTraslation p = new PanelTraslation();
        // Panel para la bolita.
        
        //LinePanel panel = new LinePanel();
        // 
        // AnimationOne panel = new AnimationOne();
        Examen_M panel = new Examen_M();
        frm.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frm.add( panel );
        frm.pack();
                
        frm.setVisible( true );
    }
    
}
