/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenobjetos;


import java.io.*;
//import java.util.ArrayList;
import nu.xom.*;

/**
 *
 * @author reyga
 */
public class Almacen {
    public final String TagFolder= "tagFolder";
    Folder folders;
    
    public  Almacen()  {
        try{
            Builder parser = new Builder();
            Document doc =  parser.build( new File("Almacen.xml"));
            Element bucket = doc.getRootElement();
            folders= new Folder(bucket);
            
        }catch(IOException exc){
            System.err.println("Error en Almacen() iosException");
        }catch(ParsingException exc){
            System.err.println("Error en Almacen() ParsingException");
        }
    }
    public void inserta(Folder f){
        
    }
    
    public void buscar(){
        System.out.println("Introduce tu busqueda:");
        String palabra= AlmacenObjetos.escanerCad();
        busqueda(palabra);
        
        if (editar()) {
            
        }
    }
    private  static boolean editar(){
        int op=-1;
        do{
            if (op>2 && op<1) {
                System.out.println("Quieres editar su ubicacion? ");
                System.out.println("1.- Si");
                System.out.println("2.- No");
                op=AlmacenObjetos.escanerNum();
            }
        }while (op>2 || op<1);
        
        return op == 1;
        
    }
    
    private void busqueda (String string){
        boolean found= false;
        while (!found) {
            
        }
    } 

    private void toXML() {
        
    }
}
