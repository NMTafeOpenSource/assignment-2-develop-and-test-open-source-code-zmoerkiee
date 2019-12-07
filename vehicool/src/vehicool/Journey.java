package vehicool;

 
public class Journey {
    /**
    * Takes two ints and calculates the distance traveled since last service
    * @param odo
    * @param last
    * @return 
    */
    public int distance(int odo, int last){
        return odo - last;
    }
}
