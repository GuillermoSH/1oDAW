public class Car {
    private String name;
    private String engine;
    public static int numberOfCars;
    
    public Car(){
    }
    public Car(String name, String engine){
        this.name=name;
        this.engine=engine;
        numberOfCars++;
    }
    public static void setNumberOfCars(int n){
        numberOfCars=n;
    }
    public static int getNumberOfCars(){
        return numberOfCars;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setEngine(String engine){
        this.engine=engine;
    }
    public String getEngine(){
        return this.engine;
    }
}
