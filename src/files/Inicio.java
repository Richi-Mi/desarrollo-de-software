
package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Mendoza Castañeda José Ricardp
 * @author Granados Estrada Iker
 * @author Gonzales al cuadrado Alan
 */

public class Inicio {
    public static void main(String[] args) {   
        FileOutputStream fo = null;
        Scanner leer = new Scanner( System.in );
        
        try {
            File file = new File("calificaciones");
            
            if( !file.exists() ) // Si existe el archivo
                System.out.println("No existe");
            System.out.println( "Ruta: " + file.getAbsolutePath() ); // Regresa la ruta absoluta del archivo
            
            fo = new FileOutputStream( file, true );
            // FileInputStream fi = new FileInputStream( file );
            PrintWriter pw     = new PrintWriter( fo, true );
        
            System.out.println("Escribe tus calificaciones de los 3 parciales: ");
            
            pw.write(" 1 \t | 2 \t | 3  \t | \n");
        
            for( int i = 0; i < 3; i++ ) {
                String text = leer.nextLine();
                pw.write( " " + text + "\t | ");
                
            }
            
            
            // No olvidar Cerrar
            pw.close(); // Fin delprocesamientoS
            
        } catch (FileNotFoundException ex) {
            
        } 
    }
}
