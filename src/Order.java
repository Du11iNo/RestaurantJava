

//Also known as Food
public class Order {
    private final String Name;
    private final double Price;

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public Order(String name, double price) {
        Name = name;
        Price = price;
    }

    @Override
    public String toString(){
        return Name + ": $" + Price;
    }

}
