

//Also known as Food
public class Product {
    private final String Name;
    private final double Price;

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public Product(String name, double price) {
        Name = name;
        Price = price;
    }

    @Override
    public String toString(){
        return Name + ": $" + Price;
    }

}
