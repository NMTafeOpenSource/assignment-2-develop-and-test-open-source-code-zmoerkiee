package vehicool;

 
public class Vehicle {
	private String	manufacturer;
	private String	model;
	private int	makeYear;
        private String rego;
        private int odo;
        private double tank;
        private double capacity;
               
	private FuelPurchase	fuelPurchase;

	/**
	 * Class constructor specifying name of make (manufacturer), model and year
	 * of make.
	 * @param manufacturer
	 * @param model
	 * @param makeYear
	 */
	public Vehicle(String manufacturer, String model, int makeYear, String rego, int odo, double tank) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.makeYear = makeYear;
                this.rego = rego;
                this.odo = odo;
                this.tank = tank;
		fuelPurchase = new FuelPurchase();
	}

        /**
         * 
         * BEGIN GETTERS & SETTERS
         * @return 
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
        /**
         * 
         * END GETTERS & SETTERS
         * 
         */
        
	/**
	 * Prints details for {@link Vehicle}
	 */
	public void printDetails() {
		System.out.println("Vehicle: " + makeYear + " " + manufacturer +
                        " " + model + " " + rego + " " + odo + " " + tank + ".");
	}

        
        public void addKilos(int kilometers){
            odo = odo + kilometers;
        }
        
        public String checkFuel(){
            if (tank <= 0){
                return "Out of fuel!";
            } else{
                return "This vehicle has " + Double.toString(tank) + " litres of fuel remaining";
            }
        }

        // adds fuel to the car
        public void addFuel(double litres, double price){            
            fuelPurchase.purchaseFuel(litres, price);
        }        

}
