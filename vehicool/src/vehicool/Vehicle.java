package vehicool;

import java.time.LocalDate;

 
public class Vehicle {
	private String	manufacturer;
	private String	model;
	private int	makeYear;
        private String  rego;
        private int     odo;
        private double  tank;
        private double  rate;
        
        private double fuelSpent        = 0;
        private double fuelMoneySpent   = 0;
        private double moneySpent       = 0;
        private double moneyEarned      = 0;
        private int    lastServiceKM    = 0;
        private int    serviceCount     = 0;
        
        private LocalDate lastServiceDate;
        
        private Service sally;
        private FuelPurchase frank;
        private Journey jeb;

	/**
	 * Class constructor for new vehicles.
	 * @param manufacturer
	 * @param model
	 * @param makeYear
         * @param rego
         * @param odo
         * @param tank
         * @param rate
	 */
        @SuppressWarnings("empty-statement")
	public Vehicle(String manufacturer, String model, int makeYear,
                String rego, int odo, double tank, double rate) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.makeYear = makeYear;
                this.rego = rego;
                this.odo = odo;
                this.tank = tank;
                this.rate = rate;
                
                lastServiceDate = LocalDate.of(1970, 1, 1);
                
                sally = new Service();
                frank = new FuelPurchase();
                jeb = new Journey();
	}
        
        /**
         * Vehicle constructor for vehicles being loaded from file.
         * @param manufacturer
         * @param model
         * @param makeYear
         * @param rego
         * @param odo
         * @param tank
         * @param rate
         * @param fuelSpent
         * @param fuelMoneySpent
         * @param moneySpent
         * @param moneyEarned
         * @param lastServiceKM
         * @param serviceCount 
         * @param year
         * @param month
         * @param day
         */
        public Vehicle(String manufacturer, String model, int makeYear,
                String rego, int odo, double tank, double rate, double fuelSpent,
                double fuelMoneySpent, double moneySpent, double moneyEarned,
                int lastServiceKM, int serviceCount, int year, int month, int day) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.makeYear = makeYear;
                this.rego = rego;
                this.odo = odo;
                this.tank = tank;
                this.rate = rate;
                this.fuelSpent = fuelSpent;
                this.fuelMoneySpent  = fuelMoneySpent;
                this.moneySpent = moneySpent;
                this.moneyEarned = moneyEarned;
                this.lastServiceKM = lastServiceKM;
                this.serviceCount = serviceCount;
                this.lastServiceDate = LocalDate.of(year, month, day);
                
                sally = new Service();
                frank = new FuelPurchase();
                jeb = new Journey();
	}

        /*
         * 
         * BEGIN GETTERS & SETTERS
         *
         */
        public String getManufacturer(){
            return manufacturer;
        }
        
        public void setManufacturer(String manufacturer){
            this.manufacturer = manufacturer;
        }
        
        public String getModel(){
            return model;
        }
        
        public void setModel(String model){
            this.model = model;
        }
        
        public int getMakeYear(){
            return makeYear;
        }
        
        public void setMakeYear(int makeYear){
            this.makeYear = makeYear;
        }
        
        public String getRego(){
            return rego;
        }
        
        public void setRego(String rego){
            this.rego = rego;
        }
        
        public int getOdo(){
            return odo;
        }
        
        public void setOdo(int odo){
            this.odo = odo;
        }
        
        public double getTank(){
            return tank;
        }
        
        public void setTank(double tank){
            this.tank = tank;
        }
        
        public double getRate(){
            return rate;
        }
        
        public void setRate(double rate){
            this.rate = rate;
        }
        /*
         * 
         * END GETTERS & SETTERS
         * 
         */
        
	/**
	 * Prints details to save {@link Vehicle} to plain text file
         * @return String
	 */
	public String saveDetails() {
		String carDeets = manufacturer +
                        ":" + model + ":" + makeYear + ":" + rego + ":" + odo
                        + ":" + tank + ":" + rate + ":" + fuelSpent + ":" + 
                        fuelMoneySpent + ":" + moneySpent + ":" + moneyEarned +
                        ":" + lastServiceKM + ":" + serviceCount + ":" +
                        lastServiceDate.getYear() + ":" + lastServiceDate.getMonthValue()
                        + ":" + lastServiceDate.getDayOfMonth();
                return carDeets;
	}
        
        /**
         * Prints details for {@link Vehicle} in a user-readable format
         * @return String
         */
        public String printDetails() {
            String details = "Vehicle: " + manufacturer + " " + model + " " +
                    makeYear + "\nRegistration No: " + rego + "\nTotal KMs travelled: "
                    + odo + "\nTotal services: " + serviceCount + "\nTotal revenue: $"
                    + moneyEarned + "\nTotal cost: $" + moneySpent + "\nTotal profit: $"
                    + profitCalc() + "\n" + sally.printServiceNeeded(odo,
                    serviceCount) + "\nDistance traveled since last service: "
                    + jeb.distance(odo, lastServiceKM) + "km\nFuel economy: "
                    + frank.fuelEconomy(fuelSpent, odo) + "L per 100KM";
            return details;
        }
        
        /**
         * Returns a string with information to identify the vehicle by
         * @return String
         */
        public String printID() {
            String id = makeYear + " " + model + " " + rego;
            return id;
        }

        //adds kilometers to the odometer
        public void addKilos(int kilometers){
            odo = odo + kilometers;
        }
        
        //returns a string with information about the vehicle's fuel tank
        public String checkFuel(){
            if (tank <= 0){
                return "This vehicle is out of fuel";
            } else{
                return "This vehicle has " + Double.toString(tank) +
                        " litres of fuel remaining";
            }
        }
        
        // calculates profit generated by this specific vehicle
        public double profitCalc(){
            return moneyEarned - moneySpent;
        }

        // adds fuel to the car
        public void addFuel(double litres, double price){            
            tank = tank + litres;
            fuelMoneySpent = fuelMoneySpent + price;
            moneySpent = moneySpent + price;
        }
        
        // removes fuel from the car
        public void remFuel (double litres){
            tank = tank - litres;
            fuelSpent = fuelSpent +litres;
        }
        
        
        //records rental information
        public void recRental(int time, int odo, double fuel){
            int odoDelta = odo - this.odo;
            double fuelDelta = this.tank - fuel;
            RentalCost randy = new RentalCost(rate, time);
            double charge = randy.CalculateByDays();
            addKilos(odoDelta);
            remFuel(fuelDelta);
            moneyEarned = moneyEarned + charge;
        }
        
        //records service information
        public void recService(double cost){
            serviceCount = serviceCount + 1;
            lastServiceDate = LocalDate.now();
            lastServiceKM = odo;
            moneySpent = moneySpent + cost;
        }

}
