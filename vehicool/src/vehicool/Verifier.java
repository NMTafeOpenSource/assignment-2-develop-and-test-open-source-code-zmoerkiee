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
import java.util.regex.Pattern;

/**
 *
 * @author Elkenhound
 */
public class Verifier {
    
    public Verifier(){
    }
    
    public boolean chkDub(String text){
        return (text.matches("[0-9]+\\.*[0-9]*"));
    }
    
    public boolean chkInt(String text){
        return (text.matches("[0-9]+"));
    }
    
    public boolean chkString(String text){
        return (text.matches(".+"));
    }
    
    public boolean chkValidLoadFile(File fairu) throws IOException{
        String[] fData = OpenFile(fairu);
        boolean valid = true;
        
        for (String text : fData){
            if(!chkValidVeLine(text)){
                valid = false;
            }
        }
        
        return valid;
    }
    
    private boolean chkValidVeLine(String text){
        boolean boom = true;
        String regex = ":";
        String input = text;
        
        Pattern p = Pattern.compile(regex);
        String[] items = p.split(input);
        
        if(items.length == 16){
            if(!chkString(items[0])){
                boom = false;
            }
            if(!chkString(items[1])){
                boom = false;
            }
            if(!chkInt(items[2])){
                boom = false;
            }
            if(!chkString(items[3])){
                boom = false;
            }
            if(!chkInt(items[4])){
                boom = false;
            }
            if(!chkDub(items[5])){
                boom = false;
            }
            if(!chkDub(items[6])){
                boom = false;
            }
            if(!chkDub(items[7])){
                boom = false;
            }
            if(!chkDub(items[8])){
                boom = false;
            }
            if(!chkDub(items[9])){
                boom = false;
            }
            if(!chkDub(items[10])){
                boom = false;
            }
            if(!chkInt(items[11])){
                boom = false;
            }
            if(!chkInt(items[12])){
                boom = false;
            }
            if(!chkInt(items[13])){
                boom = false;
            }
            if(!chkInt(items[14])){
                boom = false;
            }
            if(!chkInt(items[15])){
                boom = false;
            }
        } else{
            boom = false;
        }
        return boom;
    }
    
    public String[] OpenFile(File file) throws IOException{
        FileReader froggy = new FileReader(file);
        BufferedReader broggy = new BufferedReader(froggy);
        int nOfLs = LineCount(file);
        String[] fileData = new String[nOfLs];
        
        int i;
        for (i = 0;i < nOfLs;i++){
            fileData[i] = broggy.readLine();
        }
        
        broggy.close();
        return fileData;
    }
    
    public int LineCount(File file) throws IOException{
        int counter = 0;
        
        FileReader froggy = new FileReader(file);
        BufferedReader broggy = new BufferedReader(froggy);
        
        String linus;
        while ((linus = broggy.readLine()) != null){
            counter++;
        }
        
        broggy.close();
        return counter;
    }
}
