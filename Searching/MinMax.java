package prac;

public class MinMax {
	/* Class Pair is used to return two values from getMinMax() */
    static class Pair {

        int min;
        int max;
    }
 
    static Pair getMinMax(int arr[], int low, int high) {
        Pair minmax = new Pair(); //actual storing for Min Max of the tree
        Pair mml = new Pair(); //Min Max of the Left Sub Tree
        Pair mmr = new Pair(); //Min Max of Right Sub Tree
        int mid;
 
        //For leaf node
        if (low == high) {
            minmax.max = arr[low];
            minmax.min = arr[low];
            return minmax;
        }
 
        //For only two nodes
        if (high == low + 1) {
        	// left node is greater than right node
            if (arr[low] > arr[high]) {
                minmax.max = arr[low];
                minmax.min = arr[high];
            } else {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }
 
        //mid value
        mid = (low + high) / 2;
        //recursive call to the left subtree
        mml = getMinMax(arr, low, mid);
        //recursive call to the right sub tree
        mmr = getMinMax(arr, mid + 1, high);
 
        //Compare the Min max value of left and right sub tree 
        if (mml.min < mmr.min) {
            minmax.min = mml.min;
        } else {
            minmax.min = mmr.min;
        }
 
        if (mml.max > mmr.max) {
            minmax.max = mml.max;
        } else {
            minmax.max = mmr.max;
        }
 
        return minmax;
    }
 
    public static void main(String args[]) {
        int arr[] = {5, 7, 2, 4, 9, 6};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, 0, arr_size - 1);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

    }

}
