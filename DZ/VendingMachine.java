package DZ;

public interface VendingMachine {
    public abstract void getProduct();
    public abstract Product showProduct(int id);
    public abstract void pay(int id, int money);
}
