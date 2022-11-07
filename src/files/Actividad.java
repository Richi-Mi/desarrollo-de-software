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
public class Actividad {

    public static void main(String[] args) {
        FileOutputStream foA, foR;
        Scanner leer = new Scanner(System.in);

        int[] aprobados = new int[1000];
        int[] reprobados = new int[1000];
        int calificacion = 5, iA, iR;

        try
        {
            iA = 0;
            iR = 0;
            File fileA = new File("aprobados");
            File fileR = new File("reprobados");

            foA = new FileOutputStream(fileA, true);
            foR = new FileOutputStream(fileR, true);
            
            PrintWriter pwA = new PrintWriter(foA, true);
            PrintWriter pwR = new PrintWriter(foR, true);
            
            System.out.println("Escribe las calificaciones de tus alumnos (PD: 11 cierra el programa)");
            
            do {
                System.out.println("Escribe su calificacion: ");
                String c = leer.nextLine();
                
                calificacion = Integer.parseInt( c );

                if( calificacion >= 6 && calificacion <= 10) {
                    
                    aprobados[iA] = calificacion;
                    iA++;
                    
                }
                if( calificacion < 6 && calificacion >= 0 ) {
                    reprobados[iR] = calificacion;
                    iR++;
                }
                
            } while (calificacion != 11);
            
            pwA.print("Calificacoiones Aprobados: \n");
            for( int i = 0; i < iA; i++ ) {
                pwA.print(" Calificacion " + i + ": " + aprobados[i] + "\n");
            }
            pwA.close();
            pwR.print("Calificacoiones Reprobados: \n");
            for( int i = 0; i < iR; i++ ) {
                pwR.print(" Calificacion " + i + ": " + reprobados[i] + "\n");
            }
            pwR.close();

        } catch (FileNotFoundException ex)
        {

        }
    }

}
