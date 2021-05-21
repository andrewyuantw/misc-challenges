
// prints out maximum sum of consecutive elements in an array

import java.util.ArrayList;
public class MaximumSubarraySum {
    public static int sequence(int[] arr) {
        
        if (arr.length == 0)
            return 0;

        boolean positive = (arr[0] >= 0) ? false : true;
        ArrayList <Integer> theList = new ArrayList<Integer>(5);
        
        for (int i : arr) {
            if (i < 0) {
                if (positive) {
                theList.add(Integer.valueOf(i));
                positive = false;
                }
                else {
                theList.set(theList.size() - 1, theList.get(theList.size() -1) + i); 
                }
                
            }
            else if (positive) {
                theList.set(theList.size() - 1, theList.get(theList.size() -1) + i); 
            }
            else {
                theList.add(Integer.valueOf(i));
                positive = true;
            }
        }
        
        if (theList.get(0) < 0) 
            theList.remove(0);
        if (theList.size() == 0)
            return 0;
        
        int max = 0;
        for (int i = 0; i < theList.size(); i += 2) {
            int sum = theList.get(i);
            if (sum > max) 
                max = sum;
            for (int j = i + 2; j < theList.size(); j += 2 ) {
                sum += theList.get(j-1) + theList.get(j);
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}