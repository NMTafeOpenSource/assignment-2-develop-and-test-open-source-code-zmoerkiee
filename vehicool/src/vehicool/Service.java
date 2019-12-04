package vehicool;

public class Service {
    
    // Constant to indicate that the vehicle needs to be serviced every 10,000km
    public static final int SERVICE_KILOMETER_LIMIT = 10000;
    
    /**
     * Takes two ints to determine whether or not the vehicle is due for a
     * service
     * @param odo
     * @param sCount
     * @return 
     */
    public boolean serviceNeeded(int odo, int sCount){
        boolean needy = false;
        int savrg = odo / SERVICE_KILOMETER_LIMIT;
        
        if(sCount <= savrg && odo >= 10000){
            needy = true;
        }
        
        return needy;
    }
    
    /**
     * Takes two ints and provides a string to tell the user if the vehicle
     * is due for a service
     * @param odo
     * @param sCount
     * @return 
     */
    public String printServiceNeeded(int odo, int sCount){
        String teller;
        if(serviceNeeded(odo, sCount)){
            teller = "This vehicle is due for a service.";
        } else{
            teller = "This vehicle does not need a service.";
        }
        
        return teller;
    }
    
}
