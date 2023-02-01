package ImmutableClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, ImmutableLocation> Immutables = new HashMap<Integer, ImmutableLocation>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        //This is our starting point
        //Creating a new Immutable object and storing it in the Immutables Map
        Immutables.put(0, new ImmutableLocation(0, "You are sitting in front of a computer learning Java",tempExit));


        //Room 1
        //We got rid of addExit method
        //Sat up a temporary a new instance of a hashmap => That goes inside the permanent as the value
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        //Creating a new Immutable object and storing it in the Immutables Map
//        Immutables.put(1, new ImmutableLocation(1, "You are standing at the end of a road before a small brick building", tempExit));
        Immutables.put(1, new ImmutableLocation(1, "You are standing at the end of a road before a small brick building", tempExit));


        //****THIS IS THE SET-UP TO PROMOTE IMMUTABILITY ****
        //Key = 1 : Value = new instance of class ----> location 1, description, tempExit = K/V =W/2 & E/3 & S/4...

        //Room 2
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        //Creating a new Immutable object and storing it in the Immutables Map
        Immutables.put(2, new ImmutableLocation(2, "You are at the top of a hill",tempExit));

        //Room 3
        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        //Creating a new Immutable object and storing it in the Immutables Map
        Immutables.put(3, new ImmutableLocation(3, "You are inside a building, a well house for a small spring",tempExit));

        //Room 4
        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        //Creating a new Immutable object and storing it in the Immutables Map
        Immutables.put(4, new ImmutableLocation(4, "You are in a valley beside a stream",tempExit));

        //Room 5
        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        //Creating a new Immutable object and storing it in the Immutables Map
        Immutables.put(5, new ImmutableLocation(5, "You are in the forest",tempExit));

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");


        int loc = 1;
        while(true) {
            //Fetching the description of the Immutable object stored in the Immutables Map
            System.out.println(Immutables.get(loc).getDescription());
            tempExit.remove("S");

            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = Immutables.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }

    }
}
