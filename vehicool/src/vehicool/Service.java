package vehicool;

public class Service {
    
    // Constant to indicate that the vehicle needs to be serviced every 10,000km
    public static final int SERVICE_KILOMETER_LIMIT = 10000;
    
    /**
     * Takes two ints to determine whether or not the vehicle is due for a
     * service
     * @param odo
     * @param lastServiceKM
     * @return 
     */
    public boolean serviceNeeded(int odo, int lastServiceKM){
        boolean needy = false;
        int odoDelta = odo - lastServiceKM;
        
        if(odoDelta >= SERVICE_KILOMETER_LIMIT){
            needy = true;
        }
        
        return needy;
    }
    
    /**
     * Takes two ints and provides a string to tell the user if the vehicle
     * is due for a service
     * @param odo
     * @param lastServiceKM
     * @return 
     */
    public String printServiceNeeded(int odo, int lastServiceKM){
        String teller;
        if(serviceNeeded(odo, lastServiceKM)){
            teller = "This vehicle is due for a service.";
        } else{
            teller = "This vehicle does not need a service.";
        }
        
        return teller;
    }
    
}
