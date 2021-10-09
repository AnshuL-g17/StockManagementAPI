/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gupanshu;

/**
 * The class models a very simple model of the inventory and keeps a track 
 * of the quantity of an item on hand and reorder point of the item.
 *
 * @author Anshul Gupta
 */
public class Inventory {
    private String id = "ABC-1234";
    private String name = "New Item";
    int qoh = 0;
    int rop = 25;
    private double sellPrice = 0.0;


public Inventory(){

}

/**
     * Constructs an Inventory object with a given id, name and selling price
     * 
     * @param id the id of the inventory
     * @param name the name of the item
     * @param sellPrice the selling price of the item
     */
public Inventory(String id, String name, double sellPrice){
    this.id = id;
    this.name = name;
    this.sellPrice += sellPrice;
}

    /**
     * Constructs an Inventory object with a given id, name and selling price
     * 
     * @param id the id of the inventory
     * @param name the name of the item
     * @param qoh the quantity on hand in the inventory
     * @param rop the reorder point if the item
     * @param sellPrice the selling price of the item
     */
public Inventory(String id, String name, int qoh, int rop, double sellPrice){
    this.id = id;
    this.name = name;
    this.qoh += qoh;
    this.rop = rop;
    this.sellPrice += sellPrice;
}

    /**
     * Retrieves the inventory id.
     *
     * @return the inventory id
     */
public String getId(){
    return this.id;
}

    /**
     * Assigns the inventory id.
     *
     * @param id sets the inventory id
     * @throws IllegalArgumentException if id is not in the form of ABC-1234
     * which is determined by using regular expression.
     */
public void setId(String id) throws IllegalArgumentException{
    if(id.length() !=8 || id == null){
        throw new IllegalArgumentException("ERROR: Inventory ID must be in the form ABC-1234");
    }
    
    boolean isTrue = false;
    for (int i = 0; i < 3; i++)
        {
            char c = id.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                isTrue= true;
            }
        }
        boolean isTrue1= false;
         if(id.charAt(3)=='-'){
            isTrue1=true;
        }
         
         boolean isTrue2 = false;
        for (int x = 4; x < 8; x++)
        {
            char d = id.charAt(x);
            if ((d >= '0' && d <= '9')) {
                isTrue2= true;
            }
        }
 
       
        if(!isTrue || !isTrue1 || !isTrue2){
            throw new IllegalArgumentException("ERROR: Inventory ID must be in the form ABC-1234");
        }else{
            this.id=id;
        }
            
 }


    /**
     * Retrieves the item name.
     *
     * @return the item name
     */
public String getName(){
    return this.name;
}

    /**
     * Assigns the item name.
     *
     * @param name
     * @throws IllegalArgumentException if the name string is null or empty
     */
public void setName(String name) throws IllegalArgumentException{
    if(name != null && !name.trim().isEmpty()){
        this.name = name;
    }else{
    throw new IllegalArgumentException("ERROR: You must enter an Item name.");
    }
}

    /**
     * Retrieves the quantity on hand.
     *
     * @return the quantity on hand
     */
public int getQoh(){
    return this.qoh;
}

    /**
     * Assigns the quantity on hand of the item.
     *
     * @param qoh sets the value of quantity of order
     * @throws IllegalArgumentException if QOH is less than 0
     */
public void setQoh(int qoh) throws IllegalArgumentException{
    if(qoh<0){
        throw new IllegalArgumentException("ERROR: QOH must be 0 or more");
    }else{
    this.qoh += qoh;
    }
}

    /**
     * Retrieves the reorder point.
     *
     * @return the reorder point of the item.
     */
public int getRop(){
    return this.rop;
}

    /**
     * Assigns the reorder point of the item.
     *
     * @param rop sets value od reorder point
     * @throws IllegalArgumentException if ROP is less than or equals to 0
     */
public void setRop(int rop) throws IllegalArgumentException{
    if(rop<=0){
        throw new IllegalArgumentException("ERROR: Rop must be greater than 0");
    }else{
    this.rop = rop;
    }
}

    /**
     * Retrieves the selling price.
     *
     * @return the selling price of the item
     */
public double getSellPrice(){
    return this.sellPrice;
}

    /**
     * Assigns the selling price of the item.
     *
     * @param sellPrice sets value of selling price
     * @throws IllegalArgumentException if selling price is less than 0
     */
public void setSellPrice(double sellPrice) throws IllegalArgumentException{
    if(sellPrice<=0){
        throw new IllegalArgumentException("ERROR: Selling price must be greater than 0");
    }else{
    this.sellPrice = sellPrice;
    }
}

    /**
     * Converts the methods of the inventory class into a string
     */
    @Override
    public String toString(){
    return String.format("Item ID: %7s Item Name:%6s QOH:%3d  Price: $%4.2f",id ,name,qoh ,sellPrice);
}
}
