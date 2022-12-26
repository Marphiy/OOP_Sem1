package DZ;

public class Product {
    private int id;
    private String name;
    private double volume;
    private int price;
    private int quantity;

    

    public Product(int id, String name, double volume, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.volume = volume;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId(){
        return id;
    }

    public void setQuantity(int num){
        this.quantity = num;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getPrice(){
        return price;
    }



    @Override
    public String toString() {
        return "\nProduct id:         " + id + "\n" + "name:               " + name +
            "\n" + "volume:             " + volume + "\n" + "price:              " + 
            price + "\n" + "quantity:           " + quantity + "\n";
    }

    

}
