
package DZ;

import java.util.*;

public class HotDrinkVM implements VendingMachine{
    private ArrayList<HotDrink> drinks;
    private int cash;

    public HotDrinkVM(ArrayList<HotDrink> drinks, int cash) {
        this.drinks = drinks;
        this.cash = cash;
    }

    public void addPruduct(Product product, int num){
        product.setQuantity(num);
    }

    public void getProduct(){
        System.out.println("Here's your drink!\n*******************");
    }

    public Drink showProduct(int id){
        for(HotDrink drink : drinks){
            try { 
                if(id == drink.getId()) return drink;
                
            }
            catch (IllegalStateException e) {
                System.out.println("No such product!");
            }
        }
        return null;
    
    }

    public ArrayList<Integer> showProductByTemperaturet(int temperature){
        ArrayList<Integer> list = new ArrayList<>();
        for(HotDrink drink : drinks){
            try { 
                if(temperature == drink.getTemperature(temperature)) {
                    System.out.println(drink);
                    list.add(drink.getId());
                }
            }
            catch (IllegalStateException e) {
                System.out.println("No such product!");
            }
        }
        return list;
    }

    public ArrayList<Integer> showProductByVolume(double volume){
        ArrayList<Integer> list = new ArrayList<>();
        for(HotDrink drink : drinks){
            try { 
                if(volume == drink.getVolume()) {
                    System.out.println(drink);
                    list.add(drink.getId());
                }
            }
            catch (IllegalStateException e) {
                System.out.println("No such product!");
            }
        }
        return list;
    }

    public double getProductPrice(int id){
        for(Product drink : drinks){
            try { 
                if(id == drink.getId()) return drink.getPrice();
            }
            catch (IllegalStateException e) {
                System.out.println("No such product!");
                return 0;
            }
        }
        return 0;
    }

    public void pay(int id, int money){
        for(Product drink : drinks){
            if(getProductPrice(id) == 0 || drink == null) {
                return;
            }
            else if(id == drink.getId()) {
                if(drink.getQuantity() == 0) {
                    System.out.println("No enough product quantity, sorry!");
                    return;
                }
                if(money >= drink.getPrice()){
                    int quantity = drink.getQuantity();
                    if(quantity == 0) {
                        System.out.println("No such product!");
                        return;
                    }
                    else {
                        this.cash += money;  
                        drink.setQuantity(quantity -= 1);
                        this.getProduct();
                        if(money > drink.getPrice()) {
                            int change = money - drink.getPrice();
                            this.cash -= change;
                            System.out.printf("Here's your change! - %d\n", change);
                        }
                    }
                }
                if(money < drink.getPrice()){
                    System.out.println("Not enough!\nGet your money back!\n");

                }
            }   
        }
    }

    public ArrayList<Integer> getTemperatures(){
        ArrayList<Integer> tmps = new ArrayList<>();
        for(Drink drink : drinks) tmps.add(drink.temperature);
        return tmps;
    }

    public ArrayList<Integer> getVolumes(){
        ArrayList<Integer> vlms = new ArrayList<>();
        for(Drink drink : drinks) vlms.add(drink.volume);
        return vlms;
    }

    @Override
    public String toString() {
        return "\nVM contains:\n" + drinks + "\nVM cash:" + cash + "\n\n";
    }

    
    
}
