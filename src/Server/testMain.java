/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Business.Employee;
import Business.Manufacturer;
import Business.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class testMain {
    public static void main(String[] args) {
        
   List<User> list = new ArrayList();
   list.add(new Employee("sd", "sds"));
   list.add(new Employee("2sd", "sds"));
   list.add(new Manufacturer("hallo", "ting", "sdoin", 3434, "dimg", "ssidsoiniso"));
   list.add(new Employee("s2d", "sds"));
   list.add(new Employee("sd3", "sds"));
   list.add(new Employee("sd1", "sds"));
   list.add(new Employee("sd5", "sds"));
   list.add(new Employee("sd4", "sds"));

   
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)instanceof Manufacturer){
                System.out.println(list.get(i).toString());
            }
        }
        
        
    }
    
}
