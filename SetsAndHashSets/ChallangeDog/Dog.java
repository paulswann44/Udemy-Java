package SetsAndHashSets.ChallangeDog;

public class Dog {
    private final String name;

    public Dog(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object obj) { //<---[if we put final, then we can't override in subclass]
        //comparing it with itself
        //is this object it's true self?
        if(this == obj){
            return true;
        }

        if(obj instanceof Dog){
            // If it is an instance of the Dog class, retrieve its name
            // If it is a dog, get its name, get name and store in string
            String objName = ((Dog) obj).getName(); //<--[casted as the dog class]
//            returns this object's name that equals
            return this.name.equals((objName)); //<--[checks if the string is the same]
        }
        return false;
    }
}
