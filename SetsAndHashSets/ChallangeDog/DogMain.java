package SetsAndHashSets.ChallangeDog;

public class DogMain {
    public static void main(String[] args) {

        //NARRATIVE:
        //We lost our dog named Rover, but they have a Labrador named Rover.
        //We go to the dog pound to see if our Dog Rover equals Lab Rover.
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        //Labrador is an instance of Dog
        System.out.println(rover2.equals(rover)); //true
        //but Dog is not an instance of Labrador
        System.out.println(rover.equals(rover2)); //false

        //The best way to correct this is to remove the override equals in Labrador



    }
}
