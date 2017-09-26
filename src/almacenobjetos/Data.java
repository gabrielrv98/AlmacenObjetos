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
public class Data {
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

    private boolean busca(String searching) {
        if (objeto.equals(searching)) {
            System.out.println("");//voy aqui
        }
    }
    
}
