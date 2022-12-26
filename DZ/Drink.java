package DZ;

public class Drink extends Product{
    int volume;
    int temperature;

    public Drink(int id, String name, double volume, int temperature, int price, int quantity) {
        super(id, name, volume, price, quantity);
        this.temperature = temperature;
    }

    public int getTemperature(int id){
        return temperature;
    }

    public int getTemperature(String name){
        return temperature;
    }

    public double getVolume(){
        return volume;
    }

    @Override
    public String toString() {
        return super.toString() + "temperature:        " + temperature + "\n";
    }

    
}
