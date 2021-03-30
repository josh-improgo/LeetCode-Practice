import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class MedianFinder {
    private ArrayList<Integer> array;

    /** initialize your data structure here. */
    public MedianFinder() {
        array = new ArrayList<>();
    }

    public void addNum(int num) {
        array.add(num);
    }

    public double findMedian() {
        int length = this.array.size();
        Collections.sort(array);
        if ( length % 2 == 0 ) {// it is even {
            int a = array.get(length/2);
            int b = array.get( (length/2) + 1 );
            return a / (double) b;
        } else {
            return array.get(length/2);
    }
}
}