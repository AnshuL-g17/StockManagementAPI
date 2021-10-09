/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gupanshu;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Anshul Gupta
 */
public class InventoryList extends Application{
   public ArrayList<Inventory> invList = new ArrayList<>();
   
   public InventoryList(){
       
   }
   
   /**
     * retrieves the inventoryList index
     * 
     * @param index the index of the inventoryList object
     * @return the inventoryList Object
     */
   public Inventory get(int index){
       return invList.get(index);
   }
   
   /**
     * Add inventory to inventoryList. If the inventory province is already
     * there then the new value is added to the value of that province
     * 
     * @param inventory the inventory class object
     */
   public void add(Inventory inventory){   

           invList.add(inventory);

    }

   /**
     * Retrieves the Total Length of inventory List
     * 
     * @return the total size of inventory List
     */
   public int length(){
       return invList.size();
   }
   
   /**
     * Returns a formatted String representing this inventoryList object.
     * 
     * @return this inventoryList as a String
     */
   @Override
   public String toString(){
       String outputString = "";
       for(int i=0; i<invList.size(); i++){
           outputString += invList.get(i).getRop(); 
           outputString += " \n";
       }
       
       return outputString;     
   }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
