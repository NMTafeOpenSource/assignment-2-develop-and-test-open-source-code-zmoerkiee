/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicool;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author Elkenhound
 */
public class SaveGame {
    private final File file;
    private boolean appendage = true;
    
    public SaveGame(File file){
        this.file = file;
    }
    
    public SaveGame(File file, boolean appendage){
        this.file = file;
        this.appendage = appendage;
    }
    
    public void Save(String carDeets) throws IOException{
        FileWriter fillip = new FileWriter(file, appendage);
        PrintWriter phillip = new PrintWriter(fillip);
        phillip.println(carDeets);
        phillip.close();
    }
    
}
