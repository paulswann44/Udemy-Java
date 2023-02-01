package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class TheatreCollectionsMethods {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();



    public TheatreCollectionsMethods(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00; //<----[basepay]

                if((row < 'D') && (seatNum >=4 && seatNum <=9)) {
                    price = 14.00; //<----[premium seats]
                } else if((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    //This is the long way to do a Binary Search
    //There is a shorter method using Collections.BinarySearch
    //The purpose of
    //It works great with ArrayLists where the size is unknown
    //This is the source code within java below
//    public boolean reserveSeat(String seatNumber) {
//        int low = 0;
//        int high = seats.size()-1;
//
//
//        while (low <= high) {
//            System.out.print(".");
//            int mid = (low + high) / 2;
//            Seat midVal = seats.get(mid);
//            int cmp = midVal.getSeatNumber().compareTo(seatNumber);
//
//            if (cmp < 0) {
//                low = mid + 1;
//            } else if (cmp > 0) {
//                high = mid - 1;
//            } else {
//                return seats.get(mid).reserve();
//            }
//        }
//        System.out.println("There is no seat " + seatNumber);
//        return false;
//    }


//Alternative binary search method from collections
public boolean reserveSeat(String seatNumber) {
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


    //Would not normally change an inner class from private to public
    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
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
        return price;
    }
}


    public static void main(String[] args) {
        TheatreCollectionsMethods theatre = new TheatreCollectionsMethods("Olympian", 8, 12);
        List<TheatreCollectionsMethods.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);

        seatCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")){
            System.out.println("Please pay for A02");
        } else{
            System.out.println("Seat already reserved");
        }
        //Shuffle
        Collections.shuffle(seatCopy);
        System.out.println("SHUFFLE Printing theatre.seat");
        System.out.println();
        printList(seatCopy);

        //Reverse
//        Collections.reverse(seatCopy);
//        System.out.println("REVERSE Printing theatre.seat");
//        System.out.println();
//        printList(seatCopy);

        //Max & Min
        TheatreCollectionsMethods.Seat minSeat = Collections.min(seatCopy);
        TheatreCollectionsMethods.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max Seat number is " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

    }

    public static void printList(List<TheatreCollectionsMethods.Seat> list){
        for (TheatreCollectionsMethods.Seat seat: list){
            System.out.println(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("============================================");
    }


    //? is a wildcard for generics
    //This is a bubble sort- requires less memory than merge sort
    public static void sortList(List<? extends TheatreCollectionsMethods.Seat> list){
        for (int i = 0; i < list.size() -1; i++) { //<--- outer loop
            for (int j = i + 1; j < list.size(); j++) {  //<--inner loop
                if(list.get(i).compareTo(list.get(j))> 0){
                    Collections.swap(list, i,  j);
                }
            }

        }
    }



}
