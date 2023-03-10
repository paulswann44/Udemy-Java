package SortedCollections;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Main {
        private static StockList stockList = new StockList();
        public static void main(String[] args) {
                StockItem temp = new StockItem("bread", 0.86, 100);

                temp = new StockItem("cake", 1.10,7);
                stockList.addStock(temp);

                temp = new StockItem("car", 12.50,2);
                stockList.addStock(temp);

                temp = new StockItem("chair", 62.0,10);
                stockList.addStock(temp);

                temp = new StockItem("cup", .5,200);
                stockList.addStock(temp);

                //duplicate
                temp = new StockItem("cup", .45,7);
                stockList.addStock(temp);

                temp = new StockItem("door", 72.95,4);
                stockList.addStock(temp);

                temp = new StockItem("juice", 2.5,36);
                stockList.addStock(temp);

                temp = new StockItem("towel", 2.4,80);
                stockList.addStock(temp);

                temp = new StockItem("vase", 8.76,40);
                 stockList.addStock(temp);

                System.out.println(stockList);

                for (String s: stockList.Items().keySet()){
                        System.out.println(s);
                }

                Basket paulsBasket = new Basket("Paul");
                sellItem(paulsBasket, "car",1);
                System.out.println(paulsBasket);

                sellItem(paulsBasket, "car",1);
                System.out.println(paulsBasket);

                //This is just testing that the quanty of two != -1
                if(sellItem(paulsBasket, "car",1) != 1){
                        System.out.println("There are no  more cars in stock");
                }

                //an item that does not exist
                sellItem(paulsBasket, "spanner", 5);
                System.out.println(paulsBasket);

                sellItem(paulsBasket ,"juice", 4);
                sellItem(paulsBasket, "cup", 12);
                sellItem(paulsBasket, "bread", 1);
                System.out.println(paulsBasket);

                System.out.println(stockList);


                //but the individual objects are modifiable if accessed
//                temp = new StockItem("pen", 1.12);


                //Only the collection itself is unmodifiable
                stockList.Items().get("car").adjustStock(2000); //The map is unmodified, but the item can change
                System.out.println(stockList);  //OUTPUT = There are 2001 in stock. Value of items 25012.50

//                stockList.Items().get("car").adjustStock(-1000); //The map is unmodified, but the item can change

//                Now the entries in the map consist of pairs of strings and double.
//                Now both of these are immutable. So not only can't the map be modified,
//                but the individual entries in it can't be either.
                for(Map.Entry<String,Double> price: stockList.PriceList().entrySet()){
                        System.out.println(price.getKey() + " cost " +price.getValue());
                }

        }

        public static int sellItem(Basket basket , String item, int quantity){
                //retrieve item from stock list
                StockItem stockItem = stockList.get(item);
                if(stockItem == null){
                        System.out.println("We don't sell " + item);
                        return 0;
                }
                if(stockList.sellStock(item, quantity) != 0){
                        basket.addToBasket(stockItem, quantity);
                        return quantity;
        }
                //Insf stock
                return 0;
        }


        }

