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
import java.util.regex.Pattern;



/**
 *
 * @author Elkenhound
 */
public class ProductionLine {
    
    private File metals;
    
    public ProductionLine(File fillip){
        this.metals = fillip;
    }
    
    public ArrayList Factory() throws IOException{
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String[] fData = OpenFile();
        for(String i : fData){
            Vehicle vroom = SplitInput(i);
            vehicles.add(vroom);
        }
        return vehicles;
    }
    
    public Vehicle SplitInput(String dater){
        Vehicle vroom;
        String regex = ":";
        String input = dater;
        Pattern p = Pattern.compile(regex);
        String[] items = p.split(input);
        String make = items[0];
        String model = items[1];
        int year = Integer.parseInt(items[2]);
        String rego = items[3];
        int odo = Integer.parseInt(items[4]);
        double fuel = Double.parseDouble(items[5]);
        double rate = Double.parseDouble(items[6]);
        double fSpent = Double.parseDouble(items[7]);
        double fmSpent = Double.parseDouble(items[8]);
        double fmEarned = Double.parseDouble(items[9]);
        double mEarned = Double.parseDouble(items[10]);
        int lsKM = Integer.parseInt(items[11]);
        int sCount = Integer.parseInt(items[12]);
        int sYear = Integer.parseInt(items[13]);
        int sMonth = Integer.parseInt(items[14]);
        int sDay = Integer.parseInt(items[15]);
        vroom = new Vehicle(make, model, year, rego, odo, fuel, rate, fSpent,
                fmSpent, fmEarned, mEarned, lsKM, sCount, sYear, sMonth, sDay);
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
