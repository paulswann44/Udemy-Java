
**HASH COLLECTION** - Hashmap &  HashSet
A hash collection, also known as a hash map or dictionary, stores objects by using a hash function to map the object's key to an index in an array. The value of the object is then stored at this index. When two keys produce the same hash value, this is known as a collision, and the hash collection must use some form of collision resolution to handle it, such as chaining or open addressing. The key feature of a hash collection is that it allows for efficient insertion, retrieval, and deletion of objects based on their keys.

Two objects that are equal do not have to have different hashcodes.

How equal() works is that hashcodes must be equal in order to return true.
The example is that we have a duplicate of Pluto, but with different hashcode

**SOURCE:** https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

**HashMap and HashSet** use the hashcode value of an object to find out how the object would be stored in the collection, and subsequently hashcode is used to help locate the object in the collection. Hashing retrieval involves:

1. **_First_**, find out the right bucket using hashCode().
2. **_Secondly_**, search the bucket for the right element using equals()
   Let us consider all the cases of Overriding in these methods
   
**Case 1:** -  Overriding both equals(Object) and hashCode() method

**WHY?**
-- You must override hashCode() in every class that overrides equals(). 
-- Failure to do so will result in a violation of the general contract for Object.hashCode(), which will prevent your class from functioning properly in conjunction with all hash-based collections, including HashMap, HashSet, and Hashtable.


What 


**SOURCE:** https://www.geeksforgeeks.org/override-equalsobject-hashcode-method/


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


What does it mean for **TWO** instance to be "equal".  

1. If we have one instance equal than it's self then it is truly equal.
`public static void main(String args[]){
DJ a == new DJ("blue";)
if(a==a)
System.out.println("it is equal")
}
`
2. 
**SOURCE:** https://www.youtube.com/watch?v=7V3589CReug
