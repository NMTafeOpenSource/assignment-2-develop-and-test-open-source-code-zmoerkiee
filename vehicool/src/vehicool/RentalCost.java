/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicool;

/**
 *
 * @author Elkenhound
 */
public class RentalCost {
    private final double rate;
    private final int days;
    private final int distance;
    
    public RentalCost(double rate, int days, int distance){
        this.rate = rate;
        this.days = days;
        this.distance = distance;
    }
    
    public double CalculateByDays(){
        return rate * days;
    }
    
    public double CalculateByDist(){
        return rate * distance;
    }
}
