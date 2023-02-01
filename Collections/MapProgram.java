package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        if(languages.containsKey("Java")){
            System.out.println("Java already exists");
        }else{
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java already exists");
        }

        languages.put("Python", "an interpreted, object-orientated, high-level programming language with dynamic semantics");
        languages.put("Algol", "An algorithmic language");
        languages.put("BASIC", "rookie code" );
        languages.put("Lisp", "Therein lies madness");
        System.out.println(languages.get("Java"));

        //1. overrides a value
        if(languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about java.");
        }
        System.out.println("===========================");

        //2. remove a key:value
        if(languages.remove("Algol", "An algorithmic language")){
            System.out.println("Algol removed");
        } else{
            System.out.println("Algol not removed, key/value pair not found");
        }
        //3. remove
        System.out.println(languages.replace("lisp", "a functional programming language"));
        if (languages.remove("Algol", "An algorithmic language")){
            System.out.println("Lisp was not replaced");
        }else{
            System.out.println("Lisp esd not replaces ");
        }
        //4. replace
        if(languages.replace("lisp", "This will not work", "a functional programming language")){
            System.out.println("scala, this will not be added");
        }else {

        }
        //4. find the key: value via a loop
        for (String key : languages.keySet()){
            System.out.println(key+  " : " + languages.get(key)); //get is to retrieve value
        }
    }
}
/*
The keys are unique, so you can use the value again, so it overrides a value.

Hashmap
Get (get(key))
Put (put(key, value))
Contains Key (containsKey(key))
Size (size())
Is Empty (isEmpty())
Remove (remove(key))
Values (values())
Entry Set (entrySet())
replace


the keys and values stored in a HashMap are mutable,
which means they can be changed after they are added to the map.
TRY NOT TO CHANGE THEM OR EXPECT CRAZY BEHAVIOR

Arrays on the other hand can me mutable




*/