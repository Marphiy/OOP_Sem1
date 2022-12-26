package DZ;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<HotDrink> hotDrinks = new ArrayList<>();
        hotDrinks.add(new HotDrink(1, "Lemon Tea", 0.5, 
        40, 10, 10));
        hotDrinks.add(new HotDrink(2, "Ice Tea", 0.5, 
        8, 16, 21));
        hotDrinks.add(new HotDrink(3, "Coffee Mocko", 0.2, 
        50, 12, 17));
        hotDrinks.add(new HotDrink(4, "Coffee Late", 0.2, 
        50, 11, 32));
        hotDrinks.add(new HotDrink(5, "Coffee Capuchino", 0.2, 
        50, 11, 19));
        hotDrinks.add(new HotDrink(6, "Coffee Capuchino", 0.4, 
        50, 26, 19));
        hotDrinks.add(new HotDrink(7, "GlintVine", 0.2, 
        70, 54, 35));
        hotDrinks.add(new HotDrink(8, "GlintVine", 0.5, 
        70, 100, 15));
        hotDrinks.add(new HotDrink(9, "Milk Chocolate", 0.2, 
        62, 31, 13));
        hotDrinks.add(new HotDrink(10, "Nuts Milk Chocolate", 0.2, 
        62, 45, 7));
        hotDrinks.add(new HotDrink(11, "Double Milk Chocolate", 0.4, 
        62, 96, 6));

        HotDrinkVM vm = new HotDrinkVM(hotDrinks, 1072);
        System.out.println(vm);
        Scanner scanner = new Scanner(System.in);
        while(true){
            int choice = 0;
            System.out.println("\nPlease select:      '0' - id\n                    '1' - tempr.\n" +
            "                    'q' - exit\n                    '100' - shaw all\n");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if(choice == 0) {
                    System.out.println("Enter pruduct id: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if(vm.showProduct(choice) != null) System.out.println(vm.showProduct(choice));
                    

                }
                else if(choice == 1) { 
                    while(true){
                        System.out.println("Enter pruduct temperature: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        if(vm.getVolumes().contains(choice)){
                            ArrayList<Integer> list = vm.showProductByTemperaturet(choice);
                            while(true){
                                System.out.println("Choose a product id to buy!:");
                                choice = Integer.parseInt(scanner.nextLine());
                                if(list.contains(choice)) break;
                                else System.out.println("No such id!");
                            }
                            break;
                        }
                        else System.out.println("No such drink temperature!");
                    }
                }
                else if(choice == 2) {
                    while(true){
                        System.out.println("Enter pruduct volume: ");
                        double volume = Double.parseDouble(scanner.nextLine());
                        if(vm.getVolumes().contains(volume)){
                            ArrayList<Integer> list = vm.showProductByVolume(volume);
                            while(true){
                                System.out.println("Choose a product id to buy!:");
                                choice = Integer.parseInt(scanner.nextLine());
                                if(list.contains(choice)) break;
                                else System.out.println("No such id!");
                            }
                            break;
                        }
                        else System.out.println("No such drink volume!");
                    }
                }
                else if(choice == 100) {
                    System.out.println(vm);
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Have a good day!\nBuy!");
                scanner.close();
                break;
            }
            if (choice != 100 && choice > 0 && choice < hotDrinks.size()){
                System.out.println("Would you like to buy it? (y/n)");
                String yn = scanner.nextLine();
                if(yn.equals("y")) {
                    while(true) {
                        System.out.println("Enter amount: ");
                        try {
                            int money = Integer.parseInt(scanner.nextLine());
                            vm.pay(choice, money);
                            break;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Amount incorrect!");
                        }
                    }
                }
            }
            
            
            
        }
    }
}
