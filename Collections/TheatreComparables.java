package Collections;

import java.util.*;


public class TheatreComparables {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>(); //A list with a generic name of lists
    static final Comparator<Seat> PRICE_ORDER; //<---[UNNATURAL ORDER]




// This is a static block of code that initializes a static variable called PRICE_ORDER.
// PRICE_ORDER is an instance of the Comparator interface.

    static {
        PRICE_ORDER = new Comparator<Seat>() { //<---makes it easier to sort seats by price, and it does not follow a natural order

            @Override
//            provides a way to sort elements based on custom sorting logic, rather than relying on the natural order of elements
            public int compare(Seat seat1, Seat seat2) { //<---[]
                // This method compares two Seat objects based on their price.

                // If the price of seat1 is less than the price of seat2, the method returns -1.
                if (seat1.getPrice() < seat2.getPrice()) { //<------[This is related to the compareTo Method in the seat class]
                    return -1;
                }
                // If the price of seat1 is greater than the price of seat2, the method returns 1.
                else if (seat1.getPrice() > seat2.getPrice()) { //<------[This is related to the compareTo Method in the seat class]
                    return 1;
                }
                // If the price of seat1 is equal to the price of seat2, the method returns 0.
                else {
                    return 0; //<------[This is related to the compareTo Method in the seat class]
                }
            }
        };
    }



    //Constructor
    public TheatreComparables(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        // Calculate the last row by adding the number of rows (numRows) to the ASCII value of 'A'(65)
        int lastRow = 'A' + (numRows -1); //OUTPUT: 65 + (30 -1)

        // Loop through the rows from 'A' to the last row
        for (char row = 'A'; row <= lastRow; row++) {
            // Loop through the seats in each row
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                // Set the base price to $12.00
                double price = 12.00;

                // If the row is 'A', 'B', or 'C' and the seat number is between 4 and 9 (inclusive),
                // set the price to $14.00
                if((row < 'D') && (seatNum >=4 && seatNum <=9)) {
                    price = 14.00;
                    // If the row is 'G' or higher or the seat number is less than 4 or greater than 9,
                    // set the price to $7.00
                } else if((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }

                // Create a Seat object with the row and seat number formatted as a string,
                // and the price, and add it to the seats list
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }


    public String getTheatreName() {
        return theatreName;
    }

    private boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }


    // for testing
    public Collection<Seat> getSeats() {return seats;}


    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

//        Comparable interface and is used to compare objects to determine their ordering in a sorted collection.
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());//compare if is
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }



        public double getPrice() {
            return  price;
        }
    }


    public static void main(String[] args) {
        TheatreComparables theatre = new TheatreComparables("Olympian", 8, 12);


        if (theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved");
        }
        if (theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat already reserved");
        }
        if (theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat already reserved");
        }




//        List<TheatreComparables.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
//        Collections.reverse(reverseSeats);
//        printList(reverseSeats);

        List<TheatreComparables.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, TheatreComparables.PRICE_ORDER);
        printList(priceSeats);


        // Sorting seats by seat number using the compareTo method
        List<Seat> seatList = new ArrayList<>(theatre.getSeats());
        Collections.sort(seatList);
        System.out.println("Seats sorted by seat number:");
        printList(seatList);

        // Sorting seats by price using the PRICE_ORDER comparator
        seatList = new ArrayList<>(theatre.getSeats());
        Collections.sort(seatList, TheatreComparables.PRICE_ORDER);
        System.out.println("Seats sorted by price:");
        printList(seatList);
    }


//}
        public static void printList(List<TheatreComparables.Seat> list) {
            for(TheatreComparables.Seat seat : list) {
                System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
            }
            System.out.println();
            System.out.println("======================================================================");
        }


    }

/*
COMPARABLE
The Comparable interface is used to compare objects of the same class with each other.
It provides a way to sort the data within that class.
The class needs to implement the Comparable interface and provide a "compareTo" method to define how to compare its objects.
This allows sorting of arrays of objects based on certain criteria.

* */

/* COMPARATOR:
The java.util.Comparator interface is used to define a custom ordering for a collection of objects.
It provides a single method "compare" to compare two objects and determine their order.
You use it when you want to sort a collection of objects based on some custom order that is different from their natural ordering
(i.e. order defined by the class's implementation of the java.lang.Comparable interface).
*/

/* STATIC INITIALIZER BLOCK
Think of a static initializer block as a special set of instructions that helps set up a class.
This block of code runs automatically, only once,
when the class is first used. It's like a helper that gets the class ready for use.

It gets everything ready and in place before you start using the class.


Gets called every time an instance of the class is constructed.
The static block only gets called once, when the class itself is initialized,
no matter how many objects of that type you create.

the compiler executes static blocks during class loading.
Static blocks can be used to initialize static variables or to call a static method.
However, an instance block is executed every time an instance of the class is created, and it can be used to initialize the instance data members.


*/



