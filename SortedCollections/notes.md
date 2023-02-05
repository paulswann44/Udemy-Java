**Note to reader:** This readme file serves as my notes so that I may go back to my notes for review major concepts that are new to me.

### **Comparable [1]** 

--The Comparable **interface** is used to **compare an object of the same class with an instance** of that class, it provides ordering of data for objects of the user-defined class.

-- The Comparable interface **contains the method compareTo** to decide the order of the elements.
-- Override the compareTo method in the Pair class.

### **Hashcode [2]**
--The value 44 is added to the hash code of the name for the purpose of generating a unique hash code for the StockItem object. In practice, it's common to add an arbitrary constant value to the hash code to ensure that hash codes generated from different properties are unique. However, it's important to note that the choice of constant value should be made carefully to minimize the number of hash code collisions (when two or more objects have the same hash code value).


### **UnmodifiableMap [3]**
--Makes it so that a map is unable to be modified.   

### **entrySet() [4]**
**entrySet()** declared by the Map interface returns a Set containing the map entries. Each of these set elements is a Map.Entry object. [Hashmap => Set]

**Map.Entry<String, StockItem>** represents an entry in a map, where each entry consists of a key (String) and a value (StockItem). The entrySet() method is used to return a set view of the mappings contained in this map.

**Explaination:**
https://www.youtube.com/watch?v=YfnyIBq6R1g