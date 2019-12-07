/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author 20002384
 */
public class FXMLDocumentController implements Initializable {
    
    ArrayList<Vehicle> vehicles;
    File vile;
    Verifier veg;
    
    @FXML
    private ListView vehicleListView;
    @FXML
    private ListView compseView;
    @FXML
    private Button loadB;
    @FXML
    private Button saveB;
    @FXML
    private Button newB;
    @FXML
    private Button paramB;
    @FXML
    private Button delB;
    @FXML
    private Button upB;
    @FXML
    private Button kPIB;
    @FXML
    private Label rentaL;
    @FXML
    private Label quantL;
    @FXML
    private Label priceL;
    @FXML
    private Label distanceL;
    @FXML
    private Label consumeL;
    @FXML
    private Label daysL;
    @FXML
    private Label servkmL;
    @FXML
    private Label scheduL;
    @FXML
    private TextField makeT;
    @FXML
    private TextField modelT;
    @FXML
    private TextField yearT;
    @FXML
    private TextField regoT;
    @FXML
    private TextField odoT;
    @FXML
    private TextField fuelT;
    @FXML
    private TextField rateT;
    @FXML
    private TextField compT1;
    @FXML
    private TextField compT2;
    @FXML
    private TextField compT3;
    @FXML
    private TextField compT4;
    
    @FXML
    public void handleButtonAction(){
        
    }
    
    @FXML
    public void handleOnMouseClicked(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        vehicles = new ArrayList<>();
        vile = new File("Saves/Saves.txt");
        veg = new Verifier();
        
        compseView.getItems().add("Fuel Purchase");
        compseView.getItems().add("Rental");
        compseView.getItems().add("Service");
        vehicleListView.getItems().add("New Vehicle");
        vehicleListView.getSelectionModel().select(0);
        
        try {
            loadFromVile();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Loads saved data from plain text doc
        loadB.setOnAction((ActionEvent event) -> {
            try {
                loadFromVile();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Saves all vehicles recorded in the current session to plain text doc
        saveB.setOnAction((ActionEvent event) -> {
            if(!vehicles.isEmpty()){
                try {
                    new PrintWriter(vile).close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                SaveGame sally = new SaveGame(vile);
                vehicles.forEach((v) -> {
                    try {
                        sally.Save(v.saveDetails());
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                vListReset(0);
            } else{
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("You have no vehicle data to save!");
                a.show();
            }
        });
        
        //Creates a new vehicle with user inputs
        newB.setOnAction((ActionEvent event) -> {
            
            if (veVerify()){
                Vehicle vroom = veMake();
                vehicles.add(vroom);
                vListReset(vehicleListView.getSelectionModel().getSelectedIndex());
            }
        });
        
        //Deletes selected vehicle
        delB.setOnAction((ActionEvent event) -> {
            int s = vehicleListView.getSelectionModel().getSelectedIndex();
            vehicles.remove(s);
            vListReset(s);
        });
        
        //Updates recorded information for selected vehicle
        upB.setOnAction((ActionEvent event) -> {
            int s = vehicleListView.getSelectionModel().getSelectedIndex();
            
            if (veVerify()){
                Vehicle vroom = veMake();
                vehicles.set(s, vroom);
                vListReset(s);
                veDisp(s);
            }
        });
        
        //Routes user rental input to appropriate methods
        paramB.setOnAction((ActionEvent event) -> {
            int s = compseView.getSelectionModel().getSelectedIndex();
            int s2 = vehicleListView.getSelectionModel().getSelectedIndex();
            switch(s){
                case(0):
                    if(fuelVerify()){
                        fuelBuy(s2);
                    }
                    break;
                case(1):
                    if(rentVerify()){
                        makeRent(s2);
                    }
                    break;
                case(2):
                    if(serviceVerify()){
                        makeService(s2);
                    }
                    break;
            }
        });
        
        //Displays complete rental information about the selected vehicle
        kPIB.setOnAction((ActionEvent event) -> {
            int s = vehicleListView.getSelectionModel().getSelectedIndex();
            
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText(vehicles.get(s).printDetails());
            a.show();
        });
        
        //Updates UI according to user input
        vehicleListView.setOnMouseClicked((MouseEvent event) -> {
            int s = vehicleListView.getSelectionModel().getSelectedIndex();
                if(vehicles != null){
                    if(s < vehicles.size()){
                        veDisp(s);
                    } else {
                        newVeLayout();
                    }
                }
            
            });
        
        
        //hides/shows information according to the selected catergory
        compseView.setOnMouseClicked((MouseEvent event) -> {
            int s = compseView.getSelectionModel().getSelectedIndex();
            switch(s){
                case(0):
                    quantL.setVisible(true);
                    priceL.setVisible(true);
                    distanceL.setVisible(false);
                    consumeL.setVisible(false);
                    daysL.setVisible(false);
                    servkmL.setVisible(false);
                    scheduL.setVisible(false);
                    compT1.setVisible(true);
                    compT1.setText("");
                    compT2.setVisible(true);
                    compT2.setText("");
                    compT3.setVisible(false);
                    compT4.setVisible(false);
                    break;
                case(1):
                    quantL.setVisible(false);
                    priceL.setVisible(false);
                    distanceL.setVisible(true);
                    consumeL.setVisible(true);
                    daysL.setVisible(true);
                    servkmL.setVisible(false);
                    scheduL.setVisible(false);
                    compT1.setVisible(true);
                    compT1.setText("");
                    compT2.setVisible(true);
                    compT2.setText("");
                    compT3.setVisible(true);
                    compT3.setText("");
                    compT4.setVisible(false);
                    break;
                case(2):
                    quantL.setVisible(false);
                    priceL.setVisible(false);
                    distanceL.setVisible(false);
                    consumeL.setVisible(false);
                    daysL.setVisible(false);
                    servkmL.setVisible(true);
                    scheduL.setVisible(false);
                    compT1.setVisible(true);
                    compT1.setText("");
                    compT2.setVisible(false);
                    compT3.setVisible(false);
                    compT4.setVisible(false);
                    break;
            }
        });
    }    
    
    //Clears vehicles list view and re-fills it with more current data
    private void vListReset(int s){
        int sizzle = vehicles.size();
        vehicleListView.getSelectionModel().clearSelection();
        vehicleListView.getItems().clear();
        for (Vehicle v : vehicles) {
            vehicleListView.getItems().add(v.printID());
        }
        vehicleListView.getItems().add("New Vehicle");
        if(s < sizzle){
            vehicleListView.getSelectionModel().select(s);
            veDisp(s);
        } else{
            
            vehicleListView.getSelectionModel().select(s);
            newVeLayout();
        }
        
    }
    
    public void loadFromVile() throws IOException{
        if(veg.chkValidLoadFile(vile)){
            vehicleListView.getSelectionModel().clearSelection();
            vehicleListView.getItems().clear();
            ProductionLine pat = new ProductionLine(vile);
            vehicles = pat.Factory();
            vListReset(0);
        } else {
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText("Invalid file.");
            a.show();
            vListReset(0);
        }
    }
    
    /*
    Displays information about the selected vehicle and activates UI elements
    to accept user updates
    */
    private void veDisp(int s){
        Vehicle vroom = vehicles.get(s);
        makeT.setText(vroom.getManufacturer());
        modelT.setText(vroom.getModel());
        yearT.setText(Integer.toString(vroom.getMakeYear()));
        regoT.setText(vroom.getRego());
        odoT.setText(Integer.toString(vroom.getOdo()));
        fuelT.setText(Double.toString(vroom.getTank()));
        rateT.setText(Double.toString(vroom.getRate()));
        compT1.setText("");
        compT2.setText("");
        compT3.setText("");
        compT4.setText("");
        rentaL.setVisible(true);
        compseView.setVisible(true);
        newB.setVisible(false);
        upB.setVisible(true);
        delB.setVisible(true);
        paramB.setVisible(true);
        kPIB.setVisible(true);
    }
    
    /*
    Clears fields for user input to create vehicles and hides elements that we 
    don't want users to be messing with right now.
    */
    private void newVeLayout(){
        makeT.setText("");
        modelT.setText("");
        yearT.setText("");
        regoT.setText("");
        odoT.setText("");
        fuelT.setText("");
        rateT.setText("");
        newB.setVisible(true);
        upB.setVisible(false);
        delB.setVisible(false);
        paramB.setVisible(false);
        kPIB.setVisible(false);
        rentaL.setVisible(false);
        compseView.setVisible(false);
        quantL.setVisible(false);
        priceL.setVisible(false);
        distanceL.setVisible(false);
        consumeL.setVisible(false);
        daysL.setVisible(false);
        servkmL.setVisible(false);
        scheduL.setVisible(false);
        compT1.setVisible(false);
        compT2.setVisible(false);
        compT3.setVisible(false);
        compT4.setVisible(false);
    }
    
    //Records user inputs for vehicles
    private Vehicle veMake(){
        String make = makeT.getText();
        String model = modelT.getText();
        int year = Integer.parseInt(yearT.getText());
        String rego = regoT.getText();
        int odo = Integer.parseInt(odoT.getText());
        double fuel = Double.parseDouble(fuelT.getText());
        double rate = Double.parseDouble(rateT.getText());
        Vehicle vroom = new Vehicle(make, model, year, rego, odo, fuel, rate);
        return vroom;
    }
    
    //Verifies user inputs for vehicle information
    private boolean veVerify(){
        boolean makeVal = true;
        boolean modelVal = true;
        boolean yearVal = true;
        boolean regoVal = true;
        boolean odoVal = true;
        boolean fuelVal = true;
        boolean rateVal = true;
        
        Alert a = new Alert(AlertType.INFORMATION);
        
        if(!veg.chkString(makeT.getText())){
            makeVal = false;
        }
        if(!veg.chkString(modelT.getText())){
            modelVal = false;
        }
        if(!veg.chkInt(yearT.getText())){
            yearVal = false;
        }
        if(!veg.chkString(regoT.getText())){
            regoVal = false;
        }
        if(!veg.chkInt(odoT.getText())){
            odoVal = false;
        }
        if(!veg.chkDub(fuelT.getText())){
            fuelVal = false;
        }
        if(!veg.chkDub(rateT.getText())){
            rateVal = false;
        }
        
        if(makeVal && modelVal && yearVal && regoVal && odoVal && fuelVal){
            return true;
        } else{
            String errorMsg = "";
            
            if(!makeVal){
                errorMsg = errorMsg + "Your make input was invalid.\n";
            }
            if(!modelVal){
                errorMsg = errorMsg + "Your model input was invalid.\n";
            }
            if(!yearVal){
                errorMsg = errorMsg + "Your year input was invalid.\n";
            }
            if(!regoVal){
                errorMsg = errorMsg + "Your registration input was invalid.\n";
            }
            if(!odoVal){
                errorMsg = errorMsg + "Your odometer input was invalid.\n";
            }
            if(!fuelVal){
                errorMsg = errorMsg + "Your fuel input was invalid.\n";
            }
            if(!rateVal){
                errorMsg = errorMsg + "Your rate input was invalid.";
            }
            
            a.setContentText(errorMsg);
            a.show();
            
            return false;
        }
    }
    
    //Records user inputs for fuel purchases
    private void fuelBuy(int s){
        double quant = Double.parseDouble(compT1.getText());
        double cost = Double.parseDouble(compT2.getText());
        vehicles.get(s).addFuel(quant, cost);
    }
    
    //Verifies user inputs for fuel purchase information
    private boolean fuelVerify(){
        boolean quantValid = true;
        boolean priceValid = true;
        
        if(!veg.chkDub(compT1.getText())){
            quantValid = false;
        }
        if(!veg.chkDub(compT2.getText())){
            priceValid = false;
        }
        
        if(quantValid && priceValid){
            return true;
        } else{
            String errorMSG = "";
            
            if(!quantValid){
                errorMSG = errorMSG + "Your fuel quantity is invalid.";
            }
            if(!priceValid){
                errorMSG = errorMSG + "Your fuel quantity is invalid.";
            }
            
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText(errorMSG);
            a.show();
            
            return false;
        }
    }
    
    //Records user inputs for rental information
    private void makeRent(int s){
        int odo = Integer.parseInt(compT1.getText());
        double fuel = Double.parseDouble(compT2.getText());
        int time = Integer.parseInt(compT3.getText());
        vehicles.get(s).recRental(time, odo, fuel);
    }
    
    //Verifies user inputs for rental information
    private boolean rentVerify(){
        boolean timeValid = true;
        boolean odoValid = true;
        boolean fuelValid = true;
        
        if(!veg.chkInt(compT3.getText())){
            timeValid = false;
        }
        if(!veg.chkInt(compT2.getText())){
            odoValid = false;
        }
        if(!veg.chkDub(compT3.getText())){
            fuelValid = false;
        }
        
        if(timeValid && odoValid && fuelValid){
            return true;
        } else{
            String errorMSG = "";
            
            if(!timeValid){
                errorMSG = errorMSG + "Your time input is invalid.";
            }
            if(!odoValid){
                errorMSG = errorMSG + "Your odometer reading is invalid.";
            }
            if(!fuelValid){
                errorMSG = errorMSG + "Your fuel reading is invalid.";
            }
            
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText(errorMSG);
            a.show();
            
            return false;
        }
    }
    
    //Records user inputs for service information
    public void makeService(int s){
        double cost = Double.parseDouble(compT1.getText());
        
        vehicles.get(s).recService(cost);
        System.out.println(vehicles.get(s).printDetails());
    }
    
    //Verifies user inputs for service information
    private boolean serviceVerify(){
        boolean costValid = true;
        
        if(!veg.chkDub(compT1.getText())){
            costValid = false;
        }
        
        if(costValid){
            return true;
        } else{
            String errorMSG =  "Your service cost input is invalid.";
            
            Alert a = new Alert(AlertType.INFORMATION);
            a.setContentText(errorMSG);
            a.show();
            
            return false;
        }
    }
    
}
