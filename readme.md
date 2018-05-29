# Limebike Coding Exercise

## Usage

``` 
$ git clone git@github.com:colinshum/limebike-coding-challenge.git
$ cd limebike-coding-challenge
$ javac *.java
$ java ItemCounter
```

## Modifying Test Cases

Below is a sample `Ride` object from `ItemCounter()` which can be modified to store different time intervals and items within the `Ride`.

```
Ride testRide = new Ride(
    timeFormat.parse("07:00"),
    timeFormat.parse("07:30"),
    new Basket(new HashMap<String, Integer>() {
    {
        put("apple", 2);
        put("brownie", 1);
    }
}));
```

A `Ride` can be processed using `process_ride(testRide)` and all processed rides can be printed using `printItemsPerInterval()` found in the `ItemCounter` class. 

## Implementation

Modern Java practices were used, such as the `Comparator.comparing()` method used to sort an ArrayList.

This solution uses 4 classes to complete the exercise:

1. Basket: contains the items stored within a bike's basket, stored using a `HashMap` for O(1) access times.
2. Ride: contains a start/end time interval and a `Basket`.
3. RideLog: contains a time, a `Basket` and boolean indicating whether the items should be kept beyond this time interval. A single `Ride` will have 2 `RideLog` entries for the start and end periods. 
4. ItemCounter: implements printing and processing feature using an `ArrayList<RideLog>` to quickly access and print `Basket` data for all processed `Rides`. 
