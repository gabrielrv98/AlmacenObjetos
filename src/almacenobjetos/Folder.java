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
public class Folder implements InterfaceMetodos {
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
    
    public Folder(){
        folder="Mundo";
        folders= new ArrayList<>();
        datas= new ArrayList<>();
    }
    
    @Override
    public void addData(){
        
    }
    
    @Override
    public String busca(String searching){
        StringBuilder found1 = new StringBuilder();
        String found = "";
        if (folder.equals(searching)) {
            found=folder;
            found1.append(folder);
        }else{
            if (datas.size()>0) {
                int i = 0;
                while (i<folders.size() && !found.substring(0, searching.length()).equals(searching) ) {//confirmar esto
                    found = datas.get(i).busca(searching);
                    
                } 
            }

            if (folders.size()>0) {
                int i=0;
                while (i<folders.size() && !found.equals(searching) ) {//confirmar si funciona
                    found=folders.get(i).busca(searching);
                }
            }
            
        }
        
        
        
        return found;
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
    
}
