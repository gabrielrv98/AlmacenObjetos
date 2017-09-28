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
public class Data implements InterfaceMetodos{
    private final String TagData= "TagData";
    private final String TagTags= "TagTags";
    
    private String objeto;
    private ArrayList<String> tags;
    
    public Data(Element e){
        objeto=e.getValue();
        
        Element eltoTags = e.getFirstChildElement(TagTags);
        
        if (eltoTags!=null) {
            Elements Tags = eltoTags.getChildElements();
            for (int i = 0; i < Tags.size(); i++) {
                tags.add(Tags.get(i).getValue());
            }
        }
    }
    public Data(){
        tags= new ArrayList<>();
        objeto="";
    }
    
    public void addTags(){
        String st="";
        System.out.println("Introduce los tags y cuando acabes introduce 0");
        while (!st.equals("0")) {
            st=AlmacenObjetos.escanerCad();
            tags.add(st);
        }
        System.out.println("Tags añadidos");
    }

    public String busca(String searching) {
        if (objeto.equals(searching)) {
            System.out.println("->  "+objeto);//voy aqui
        }
        return objeto;
    }

    @Override
    public void addData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
