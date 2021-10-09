/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gupanshu;

/**
 *
 * @author Anshul Gupta
 */
public enum Fields {
    ITEM_ID ("Inventory ID"),
    ITEM_NAME ("Item Name"),
    QOH ("Qty. on Hand"),
    ROP ("Re-Order Point"),
    PRICE ("Unit Price");
    
    private String caption;
    
    
    /**
     * retrieves the province name and cost for the enum constants
     * 
     * @param name the name of the province
     * @param cost the amount of the shipment
     */
    private Fields(String caption){
        this.caption = caption;
    }
       
    /**
     * Retrieves the value of field name.
     * 
     * @return the value of field name
     */
    public String getCaption(){
        return this.caption;
    }
    
}
