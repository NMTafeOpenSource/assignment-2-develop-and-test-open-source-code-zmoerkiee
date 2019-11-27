/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;



/**
 *
 * @author Elkenhound
 */
public class ProductionLine {
    
    private File metals;
    
    public ProductionLine(File fairu){
        this.metals = fairu;
    }
    
    public ArrayList Factory() throws IOException{
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String[] fData = OpenFile();
        for(String i : fData){
            Vehicle vroom = SplitNShit(i);
            vehicles.add(vroom);
        }
        return vehicles;
    }
    
    public Vehicle SplitNShit(String dater){
        Vehicle vroom;
        String regex = ":";
        String input = dater;
        Pattern p = Pattern.compile(regex);
        String[] items = p.split(input);
        vroom = new Vehicle(items[0], items[1], Integer.parseInt(items[2]), items[3], Integer.parseInt(items[4]), Double.parseDouble(items[5]));
        return vroom;
    }
    
    public String[] OpenFile() throws IOException{
        FileReader froggy = new FileReader(metals);
        BufferedReader broggy = new BufferedReader(froggy);
        int nOfLs = LineCount();
        String[] fileData = new String[nOfLs];
        int i;
        for (i = 0;i < nOfLs;i++){
            fileData[i] = broggy.readLine();
        }
        broggy.close();
        return fileData;
    }
    
    public int LineCount() throws IOException{
        int counter = 0;
        FileReader froggy = new FileReader(metals);
        BufferedReader broggy = new BufferedReader(froggy);
        String linus;
        while ((linus = broggy.readLine()) != null){
            counter++;
        }
        broggy.close();
        return counter;
    }
}
