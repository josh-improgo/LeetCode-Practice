import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;



class Result {

    /*
     * Complete the 'maxPoints' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY elements as parameter.
     */

    public static long maxPoints(List<Integer> elements) {

        // possible options:
        // 1. choose a value v, delete all elements of that value [add sum to the points]
        // 2. delete all elements equal to v + 1 or v - 1 for [no points]
        // 3. repeat steps 1 and 2 until no more elements in array

        // special cases: not removing the maximum, so start from different values
        // HashMap and add every element

        HashMap<Integer, Long> map = new HashMap<>(); // where key is the element, long is the total points
        for (int i = 0; i < elements.size(); i++) {
            int element = elements.get(i);
            if (map.containsKey(element)) {
                long newValue = map.get(element) + element;
                map.put(element, newValue);
            } else {
                map.put(element, (long)element);
            }
        }
        long maxPoints = 0;
        int keyWithMaxElement = elements.get(0);

        long maxPointsInSet = Long.MIN_VALUE;
        for (int i : map.keySet()) {
            if (map.get(i) > maxPointsInSet) {
                keyWithMaxElement = i;
                maxPointsInSet = map.get(i);
            }
        }

        while (!map.isEmpty()) {
            map.get(keyWithMaxElement);
            long comparedTotal = 0;
            if (map.containsKey(keyWithMaxElement - 1)) {
                comparedTotal += map.get(keyWithMaxElement - 1);
            }
            if (map.containsKey(keyWithMaxElement + 1)) {
                comparedTotal += map.get(keyWithMaxElement + 1);
            }
            if (comparedTotal > map.get(keyWithMaxElement)) {
                if (map.containsKey(keyWithMaxElement - 1))
                    map.remove(keyWithMaxElement - 1);
                if (map.containsKey(keyWithMaxElement + 1))
                    map.remove(keyWithMaxElement + 1);
                maxPoints += comparedTotal;
            } else {
                maxPoints += map.get(keyWithMaxElement);
                map.remove(keyWithMaxElement);
            }
        }
        return maxPoints;
    }
}
