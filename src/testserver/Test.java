/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testserver;

/**
 *
 * @author nicol
 */
public class Test {
   
    private final String KON = "aAeEiIoOuUyYæÆøØåÅ";
        
   public String Ting(String input){
       char[] j = input.toLowerCase().toCharArray();
       String noget ="";
       String outpu = "";
       for (int i = 0; i < input.length(); i++) {
           noget = j[i]+"";
           if(KON.contains(noget)){
              outpu = outpu+noget.toUpperCase();
           }else{
               outpu = outpu+noget;
           }
           
       }
       
       
       
       return outpu;
   }
    
}
