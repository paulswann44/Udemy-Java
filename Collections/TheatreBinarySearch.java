package Collections;
import java.util.*;

/**
 * Created by dev on 2/12/2015.
 */
public class TheatreBinarySearch {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public TheatreBinarySearch(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        int low = 0;
        int high = seats.size()-1;

        //This is the long way to do a Binary Search
        //There is a shorter method using Collections.BinarySearch
        //The purpose of
        //It works great with ArrayLists where the size is unknown
        //This is the source code within java below
        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

//Alternative binary search method from collections
//public boolean reserveSeat(String seatNumber){
//    Seat requestedSeat = new Seat(seatNumber, 0);
//    int foundSeat = Collections.binarySearch(seats, requestedSeat, new Comparator<Seat>() {
//        public int compare(Seat seat1, Seat seat2) {
//            return seat1.getSeatNumber().compareTo(seat2.getSeatNumber());
//        }
//    });
//    if (foundSeat >= 0){
//        return seats.get(foundSeat).reserve();
//    } else{
//        System.out.println("There is no seat " + seatNumber);
//        return false;
//    }
//}


    // for testing
    public void getSeats() {
        for(Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
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
    }



















}
