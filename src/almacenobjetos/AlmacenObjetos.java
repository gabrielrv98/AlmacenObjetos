/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenobjetos;

import java.util.Scanner;
//import nu.xom.*;

/**
 *
 * @author reyga
 */
public class AlmacenObjetos {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }
    
    public static void menu() {
        StringBuilder aux = new StringBuilder();
        aux.append("HOLA");
        aux.insert(0, "prueba");
        System.out.println(aux.toString());
        
        ////////////////////////////////////
        Almacen Almacen = new Almacen();
        int op= opcion();
        switch (op) {
            case 1:
                Almacen.buscar();
                    break;
            case 2: 
                Almacen.add();
                    break;
            case 3:
                Almacen.delete();
                    break;
        }
    }
    
    
    
    public static int opcion(){
        final int NUM_OPTIONS=2;
        
        int op=-1;
        while (op>=NUM_OPTIONS || op<1) {
        System.out.println("Opciones: ");
        System.out.println("1.- Buscar"
                + "\n2.- Añadir"
                + "\n3.- Eliminar");
        
        op= escanerNum();
            if (op>=NUM_OPTIONS || op<0) {
                System.out.println("Opcion no valida.");
                op= opcion();
            }
        }
        return op;
    }
    
    public static int escanerNum (){
        Scanner s = new Scanner(System.in);
        try{
            int n=Integer.parseInt(s.nextLine());
            return n;
        }catch(java.lang.NumberFormatException exc){
            return -1;
        }
    }

    public static String escanerCad() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    
}
