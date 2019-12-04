/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicool;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author Elkenhound
 */
public class SaveGame {
    private final String filePath;
    private boolean appendage = true;
    
    public SaveGame(String filePath){
        this.filePath = filePath;
    }
    
    public SaveGame(String filePath, boolean appendage){
        this.filePath = filePath;
        this.appendage = appendage;
    }
    
    public void Save(String carDeets) throws IOException{
        FileWriter fillip = new FileWriter(filePath, appendage);
        PrintWriter phillip = new PrintWriter(fillip);
        phillip.println(carDeets);
        phillip.close();
    }
    
}
