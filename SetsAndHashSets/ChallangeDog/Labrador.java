package SetsAndHashSets.ChallangeDog;

public class Labrador extends Dog{

    public Labrador(String name) {
        super(name);
    }
    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(obj instanceof Dog){
            String objName = ((Dog) obj).getName();
            //switch name to get name to retrived the dog's name
            return this.getName().equals((objName));
        }
        return false;
    }
}

