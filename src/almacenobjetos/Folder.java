/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenobjetos;

import java.util.ArrayList;
import nu.xom.*;

/**
 *
 * @author reyga
 */
public class Folder implements InterfaceMetodos  {
    private final String TagFolder="TagFolder";
    private final String TagData= "TagData";
    
    
    private String folder;
    private ArrayList<Folder>  folders;
    private ArrayList<Data> datas;
    
    public  Folder(Element e){
        
        this.folder = e.getValue();
        datas = new ArrayList<>();
        Element eltoFolder =e.getFirstChildElement(TagFolder);
        
        if (eltoFolder != null) {
            
            Elements eltoFolderss = eltoFolder.getChildElements();
            for (int i = 0; i < eltoFolderss.size(); i++) {
                
                folders.add(new Folder(eltoFolderss.get(i)));
                
            }
        }
        Element eltoData = e.getFirstChildElement(TagData);
        if (eltoData != null) {
            Elements eltoDatass = eltoData.getChildElements();
            for (int i = 0; i < 10; i++) {
                datas.add(new Data(eltoDatass.get(i)));
            }
        }else System.err.println("Folder " + folder + "is empty");
        
    }
    
    public Folder(String name){
        this.folder= name;
        folders= new ArrayList<>();
        datas= new ArrayList<>();
    }
    
    public String getFolderName(){
        return folder;
    }
    
    
    public void addData(){
        System.out.print(getFolderName()+" -> ");
        foldersToSttring();
        String newFolder = AlmacenObjetos.escanerCad().trim();
        if (newFolder.equals("fin")) {
            System.out.println("Introduce el nombre del Objeto/Dato:");
            String newData = AlmacenObjetos.escanerCad().trim();
            datas.add(new Data(newData));
            datas.get(datas.size()-1).addTags();
        }
        try{
            int num=Integer.parseInt(newFolder);
            folders.get(num-1).addData();
        }catch(NumberFormatException exc){
            int exist=existFolder(newFolder);
            if (exist != -1) {
                folders.get(exist).addData();
            }else{
                System.out.println("Creando nuevo fichero:");
                folders.add(new Folder(newFolder));
            }
            
        }
        
    }
    
    public int existFolder(String fol){
        int i=0;
        while (i<folders.size()) {
            if (folders.get(i).getFolderName().equals(fol)) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    
    //acabado.
    @Override
    public String busca(String searching){//acabaia siendo algo como dir1 -> dir2 -> busqueda.|f1f2f3f1d4
        StringBuilder found = new StringBuilder();
        if (folder.equals(searching)) {
            found.append(" -> ").append(folder).append(" (carpeta).|");
            
        }else{
            
            if (datas.size()>0) {
                int i = 0;
                while (i<folders.size() && (found.toString().length()<=0 ) ) {//confirmar esto
                    found.append( datas.get(i).busca(searching));  
                }
                if (found.toString().length()<=0 ) {
                    found.append("d").append(i);
                }
            }
            
            if (folders.size()>0 && (found.toString().length()<=0) ) {
                int i=0;
                while (i<folders.size() && (found.toString().length()<=0) ) {//confirmar si funciona
                    found.append(folders.get(i).busca(searching));
                }
                if (found.toString().length()<=0 ) {
                    found.append("f").append(i);
                }
            }
            if (found.toString().length()<=0 ) {
                    found.insert(0,folder);
                    found.insert(0, " -> ");
                }
        }
        
        return found.toString();
    }
    
    public void encontrado(){
        
    }
    /*
    @Override
    public String toString(){
        StringBuilder toret = new StringBuilder();
        toret.append(" -> ").append(folder).ap
    }
    */
    public String toStringFile(){
        StringBuilder toret = new StringBuilder();
        toret.append(" -> ").append(folder).append(".");
        return toret.toString();
    }

    private void foldersToSttring() {
        for (int i = 0; i < folders.size(); i++) {
            System.out.println((i+1)+".- "+folders.get(i).getFolderName());
        }
    }
    
}
