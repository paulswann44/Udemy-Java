package SortedCollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;


    public StockList() {
        //this should make the output in main in alphabetical order by using linked hashmap
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if(item !=null){
            //It gets the item or ...
            StockItem inStock = list.getOrDefault(item.getName(), item);
            //Check if we already have quantities if this item
            if(inStock != item){
                //if it already exists in the map prior to calling add stock,
                //then we are going to pass the value of whatever was already in the map
                item.adjustStock(inStock.quantityInStock());
            }
            //if it already exists automatically, the put method should overwrite it or just add it to the map
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        //b/c there was no stock
        return 0;
    }


    public int sellStock(String item, int quantity) {

        //finds item that matches the string or returns a null value
        StockItem stock = list.getOrDefault(item, null);

        //if stock is not null, and has a known quantity and quantity is greater than 0....
        if (stock != null && stock.quantityInStock() >= quantity && quantity > 0) {
        //adjust the stock by calling the adjustStock and decrements it by the provided quantity
            stock.adjustStock(-quantity);
            //and returns the result
            return quantity;
        }

        // If nothing was taken out of stock, return 0
        return 0;
    }

    //getter gets a string Key and returns that value
    public  StockItem get(String key){
        return list.get(key); //<---[returns value]
    }

    //return type has to be a map, in this case it is an unmodifiable map
    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list); //[3]
    }

    public Map<String, Double> PriceList(){
        Map<String, Double> price = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()){
            price.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(price);

    }
    @Override
    public String toString() {

        String s ="\nStock List\n";
        //tracks the total cost of the item
        double totalCost =0.0;

        //Looping through Map
        for(Map.Entry<String, StockItem> item : list.entrySet()){  //[4]

        // gets the current stock item
        StockItem  stockItem = item.getValue();

        //calculates the inventory items price x quantity
        double itemValue = stockItem.getPrice()* stockItem.quantityInStock();

        s= s + stockItem + " : " + " There are " + stockItem.quantityInStock() + " in stock. Value of items ";
        s = s + String.format("%.2f ", itemValue)+ "\n";
//        calculates the total cost by adding the accumulated total cost to the value of the items
        totalCost += itemValue;
    }
        return s+" Total stock value " + totalCost;
    }


}


