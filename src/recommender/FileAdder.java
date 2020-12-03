/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommender;
import java.util.*;
import java.io.InputStream;

/**
 *
 * @author Tonio
 */
public abstract class FileAdder {
        
    protected InputStream getFileStream(String name){
        return getClass().getResourceAsStream("/txtFiles/" + name + ".txt");
        
    }
    
}
