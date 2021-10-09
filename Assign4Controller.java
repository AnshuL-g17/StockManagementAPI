/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gupanshu;


import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Assign4Controller implements Initializable {

   
    ArrayList<Inventory> invList = new ArrayList<>();
    ObservableList<Inventory> list = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    TextField idVal,itemVal,qohVal,ropVal,spVal;
    @FXML
    Label idLbl,itemNameLbl,qohLbl,ropLbl,spLbl,errorLbl,infoLbl;
    @FXML
    Button addBtn,orderBtn,saveBtn,exit;
    @FXML
    ListView display;
    


    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idLbl.setText(Fields.ITEM_ID.getCaption());
        itemNameLbl.setText(Fields.ITEM_NAME.getCaption());
        qohLbl.setText(Fields.QOH.getCaption());
        ropLbl.setText(Fields.ROP.getCaption());
        spLbl.setText(Fields.PRICE.getCaption());
        
        idVal.setEditable(false);
        itemVal.setEditable(false);
        qohVal.setEditable(false);
        ropVal.setEditable(false);
        spVal.setEditable(false);
        
        addBtn.setDisable(false);
        orderBtn.setDisable(false);
        saveBtn.setDisable(true);
        exit.setDisable(false);
    
        addBtn.setOnAction((ActionEvent event) -> {
            addBtn.setDisable(true);
            orderBtn.setDisable(true);
            
            idVal.clear();
            itemVal.clear();
            qohVal.clear();
            ropVal.clear();
            spVal.clear();
            saveBtn.setDisable(false);
            
            idVal.setEditable(true);
            itemVal.setEditable(true);
            qohVal.setEditable(true);
            ropVal.setEditable(true);
            spVal.setEditable(true);
            saveBtn.setDisable(false);
    }); 
        
        orderBtn.setOnAction((ActionEvent event) -> {
            list.clear();
            
        if(invList.size()> 0){
           
        for(int i=0;i<invList.size();i++){
            if(invList.get(i).rop > invList.get(i).qoh) {
                
                list.add(invList.get(i));
                display.setItems(list);
                display.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener(){
                    @Override 
                    public void invalidated(Observable o)  {
                    infoLbl.setText(display.getSelectionModel().getSelectedItem().toString());
                }});
            }else{
                infoLbl.setText("No Items to Re-Order");
            }
        }
        }else{
                 errorLbl.setText("No items in list. Add some");
            }
        
    }); 
        
        saveBtn.setOnAction((ActionEvent event) -> {
         
             Inventory stock = new Inventory();
            
            idVal.setEditable(false);
            itemVal.setEditable(false);
            qohVal.setEditable(false);
            ropVal.setEditable(false);
            spVal.setEditable(false);
            saveBtn.setDisable(true);
            addBtn.setDisable(false);
            orderBtn.setDisable(false);
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            
            alert.setTitle("Data Entry Error");
            alert.setHeaderText("Invalid Value Entered");
            try{
            stock.setId(idVal.getText());
            }catch(Exception e){
            alert.setContentText("Item ID must be in the form of ABC-1234.");
            alert.showAndWait();
            }
            try{
            stock.setName(itemVal.getText());
            }catch(Exception e){
            alert.setContentText("Enter some value for Item Name.");
            alert.showAndWait();
            }
            try{
            stock.setQoh(Integer.parseInt(qohVal.getText()));
            stock.setRop(Integer.parseInt(ropVal.getText()));
            }catch(Exception e){
            alert.setContentText("Enter an Integer for QOH and ROP.");
            alert.showAndWait();
            }
            try{
            stock.setSellPrice(Double.parseDouble(spVal.getText()));
            }catch(Exception e){
            alert.setContentText("Enter a numeric value for Unit Price.");
            alert.showAndWait();
            }
            invList.add(stock);
            
            idVal.clear();
            itemVal.clear();
            qohVal.clear();
            ropVal.clear();
            spVal.clear();
            
    }); 
        
        exit.setOnAction((ActionEvent event) -> {
            Alert alertExit = new Alert(Alert.AlertType.CONFIRMATION, 
                "Are you sure you wish to exit?", ButtonType.YES, 
                ButtonType.NO);
            alertExit.setTitle("Exit Program");
            alertExit.setHeaderText(null);
            Optional<ButtonType> result = alertExit.showAndWait();

            if (result.get() == ButtonType.YES) 
                System.exit(0);
    });
    
}
}

