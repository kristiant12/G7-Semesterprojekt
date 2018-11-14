/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author rober
 */
public class Picture implements Serializable {
    
    
    public Picture(Object object){
        
    }
    
    /**
     * Tries to save game. If succesful, prints : picture saved, if not, could not save picture. 
            
     */
    void savePicture(Object picture){
        try{
            FileOutputStream fileOut  = new FileOutputStream("picture.dk");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.close();
            fileOut.close();
            System.out.println("picture saved");
                    
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    Object getPicture() {
        Object gameState = new Object();

        try {
            FileInputStream fileIn = new FileInputStream("pic.png");
            ObjectInputStream in = new  ObjectInputStream(fileIn);
            Object temp = in.readObject();
            if ((temp instanceof Object)) {
                gameState = (Object) temp;
            }
            in.close();
            fileIn.close();
            return gameState;
        } catch (FileNotFoundException f) {
            System.err.println("File does not exist");
        } catch (IOException i) {
            System.err.println("IO exception found");
        } catch (ClassNotFoundException c) {
            System.err.println("Class not found in file");
        }
        return null;
    }
    
}
