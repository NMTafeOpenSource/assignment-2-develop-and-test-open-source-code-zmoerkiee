/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicool;

import java.util.Random;

/**
 * Starter code for Vehicle application. 
 * This class displays sample output to the console.
 * @author AUTHORNAME
 */
public class VehicleStarter {

    /** Main entry point to the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Vehicle v = new Vehicle("Ford", "Taurus", 1996, "1EPK496", 200000, 40, 22);
		
		// Vehicle sample distance
            v.addFuel(new Random().nextInt()*10, 1);

            v.saveDetails();                
            System.out.println("\n\n");
    }
    
}
