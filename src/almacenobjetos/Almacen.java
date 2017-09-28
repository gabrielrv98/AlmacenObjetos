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
        }catch(FileNotFoundException exc){
            System.err.println("Error en Almacen() no se encuentra el archivo");
            folders = new Folder();
        }catch(IOException exc){
            System.err.println("Error en Almacen() iosException");
        }catch(ParsingException exc){
            System.err.println("Error en Almacen() ParsingException");
        }
    }
    
    public void add(){
        int op=0;
        while (op>2 || op<=0) {
            System.out.println("Que deseas añadir: ");
            System.out.println("1.- Añadir dato/Objeto"
                    + "\n2.- Añadir Tag");
            op=AlmacenObjetos.escanerNum();
        }
        switch (op) {
            case 1:
                addData();
                break;
            case 2:
                addTag();
        }
    }
    
    private void addData(){
        System.out.println("Introduce de fuera para dentro los lugares donde esta guardado."
                + "\nApareceran algunos lugares sugeridos, escribe el numero a su izq para seleccionar."
                + "\nCuando hayas acabado escribe <fin> (sin singos), y luego el nombre del Objeto");
        folders.addData();
    }
    public void delete(){
        
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
