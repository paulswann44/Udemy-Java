package SortedCollections;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;

    //constructor
    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0; //or here(but you won't normally do both)
    }

    //for overloading the constructor
    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    //getters
    public double getPrice() {
        return price;
    }

    //This is a getter
    public int quantityInStock() {
        return quantityStock;
    }

    public String getName() {
        return name;
    }

    //It sets the price so that it is not 0
    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }
    //allows stock levels to be increased or decreased as stock is added and sold
    //It cannot go below zero
    public void adjustStock(int quantity) {
        //adds beginning inventory with current inventory
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity > 0) {
            this.quantityStock = newQuantity;
        }

    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        //testing if the object being compared is the same instance in memory
        if (obj == this) {
            return true;
        }
        //checking if the object being compared is null or if its class does not equal this instance's class
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        //casting obj to StockItem to access its name
        String objName = ((StockItem) obj).getName();
        //comparing the names of the StockItem objects
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() { //[2]
        return this.name.hashCode() + 44;
    }

    @Override
    public int compareTo(StockItem o) { //[1]
        System.out.println("Entering Stock.Item.compareTo");
        if (this == o) {
            return 0;
        }
        if (o != null) {
            //if not null compare this instance name with the objects name
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }



    @Override
    // returns the name and price of this StockItem instance
    public String toString() {
        return this.name + price;
    }
}