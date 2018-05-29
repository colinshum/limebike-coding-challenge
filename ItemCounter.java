import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ItemCounter {
    ArrayList<RideLog> riders = new ArrayList<>();
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    public static void main(String[] args) {
        new ItemCounter();
    }

    public ItemCounter() {
        try {
            Ride testRide1 = new Ride(
                timeFormat.parse("07:00"),
                timeFormat.parse("07:30"),
                new Basket(new HashMap<String, Integer>() {
                {
                    put("apple", 2);
                    put("brownie", 1);
                }
            }));

            Ride testRide2 = new Ride(
                timeFormat.parse("07:10"),
                timeFormat.parse("08:00"),
                new Basket(new HashMap<String, Integer>() {
                {
                    put("apple", 1);
                    put("carrot", 3);
                }
            }));

            Ride testRide3 = new Ride(
                timeFormat.parse("07:20"),
                timeFormat.parse("07:45"),
                new Basket(new HashMap<String, Integer>() {
                {
                    put("apple", 1);
                    put("brownie", 2);
                    put("diamond", 4);
                }
            }));

            processRide(testRide1);
            processRide(testRide2);
            processRide(testRide3);

            printItemsPerInterval();

        } catch (ParseException e) {
            System.err.println("Parse Exception: " + e.getMessage());
        }
    }

    public void processRide(Ride ride) {
        // Process ride information and times as a RideLog object in an ArrayList
        // Time Complexity: O(1)
        riders.add(new RideLog(ride.getBasket(), ride.getRideStart(), true));
        riders.add(new RideLog(ride.getBasket(), ride.getRideEnd(), false));
    }

    public void printItemsPerInterval() {
        Date prevInterval = null;
        Date nextInterval = null;
        boolean validIntervals = false;
        Basket tempItems = new Basket();

        // Define the sort comparator to be in ascending order for the ride start/end time of a ride
        // Time Complexity: O(n*log(n))
        riders.sort(Comparator.comparing(RideLog::getTimeInterval));

        // Iterating over all RideLog objects in the 'riders' ArrayList
        // Time Complexity: O(m*n) where m = size of riders, n = size of tempItems
        for (RideLog cur : riders) {

            // Cycle through time intervals within the ArrayList of RideLog objects and determine validity of the interval
            prevInterval = nextInterval;
            nextInterval = cur.getTimeInterval();
            validIntervals = prevInterval != null && !prevInterval.equals(nextInterval);

            // Prints interval with basket items only if prevInterval is populated and start/end times are different
            if (validIntervals) {
                System.out.print(timeFormat.format(prevInterval) + "-" + timeFormat.format(nextInterval) + " -> ");
                System.out.print(tempItems.listItems());
            }
            
            // Items are added to the 'tempItems' basket if the interval is the start of a new ride
            // Otherwise, the items are removed from the 'tempItems' basket as the ride is completed
            // Time Complexity: O(n)
            tempItems.modifyBasket(cur.getKeepItems(), cur.getBasket());
        }
    }
}
