package vehicool;

public class FuelPurchase {
        public double fuelEconomy(double litres,int odo){
            double avgLitres;
            //if loop to avoid divide by zero
            if(litres > 0 && odo > 0){
                avgLitres = (litres / odo) * 100;
            } else{
                avgLitres = 0;
            }
            return avgLitres;
        }
}
