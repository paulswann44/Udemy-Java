SETS
--Sets are not used often.
--They cannot contain duplicates.
--No defining order ---> opposite from an arrayList
--Can iterate through a set, but it is impossible to get something like the 10th item in a set is impossible

--Sets are widely used in programming, especially in Java, and are a valuable data structure for managing collections of elements.
--Sets indeed cannot contain duplicates, which is one of their main characteristics.
--Sets do not preserve any specific order of elements, but their concrete implementations, such as HashSet, LinkedHashSet, and TreeSet, have their own characteristics with respect to the order of elements.
--While it is possible to iterate through a Set using an Iterator or a for-each loop, getting an element at a specific index is not possible because Sets do not have indices.
--Sets are useful when you need to store unique elements, but you don't care about the order in which they are stored. They are also used for operations like:
                                                --union, intersection
-- Set also provides methods like:
                                                --clear(), toArray(), equals(), and hashCode().

SUMMARY: Chaotic non-repeating rare set

METHODS:
--add
--remove
--clear
--size
--contains
--exists
--isEmpty
--addAll ------->This method allows you to convert from another collection like a list to a Set

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

[**SOURCE:**](https://www.youtube.com/watch?v=QvHBHuuddYk)

**SET**
- group a whole bunch of identical items to a set.
Set<Strings> names = new HashSet<>();
- Set is an interface, not a normal class. 
- One cannot create instances of interface, thus you can only create instance of classes that implement those new interfaces.
- This is where hashmaps come into play
  **NOT:** `Set<Strings> names = new **Set<>()**;` **=>**  **BUT:** `Set<Strings> names = new **HashSet<>()**`;
- Basically how the set interface works is where Java says any class that wants tto be a set has to support operations and methods like:
1. adding
2. removing

-It is up to those individual sets on how they want to implement all of those functionalities behind the scenes.
- Hashset is just **ONE** implementation along with many others.  
- Hashset is the most common.
- Hashset does **not have any specific order**.
- Hashsets have no **duplicates**
- Cannot remove a hashset via an index.
    names.remove(0); <--- removes the first random element 



`Set<Interger> numberSet = new HashSet<>(numberList);` **<-----** This is a more simple way compared to addAll
-It is called a hashset because it implements a hash table.
-It allows for fast operations on a set
-The larger a list gets the more expensive it gets

**TREESET:**
-It will order via it's 'natural order', such as alphabetical order or descending order.
- Slower than a Hashset

**LINKED HASHSET**
-Maintains the insertion order of the hashset
-Almost as fast as HashSets
 
