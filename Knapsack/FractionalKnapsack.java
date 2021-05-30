package prac;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
	
	// item value class
    static class ItemValue {
        Double ratio;
        double weight, profit, index;
 
        // item value function
		public ItemValue(int wt, int val, int ind)
        {
            this.weight = wt;
            this.profit = val;
            this.index = ind;
            ratio = (double)val / (double)wt;
        }
    }
    
    // function to get maximum value
    private static double getMaxValue(int[] weight, int[] profit,
                                      int capacity)
    {
        ItemValue[] iVal = new ItemValue[weight.length];
 
        for (int i = 0; i < weight.length; i++) {
            iVal[i] = new ItemValue(weight[i], profit[i], i);
        }
 
        // sorting items by value;
        Comparator<ItemValue> compareByRatio = (ItemValue o1, ItemValue o2) -> o2.ratio.compareTo(o1.ratio);
        Arrays.sort(iVal, compareByRatio);
 
        double totalProfit = 0d;
 
        for (ItemValue i : iVal) {
 
            int curWt = (int)i.weight;
            int curVal = (int)i.profit;
 
            if (capacity - curWt >= 0) {
                // this weight can be picked so we take it completely
                capacity = capacity - curWt;
                totalProfit += curVal;
            }
            else {
                // item cant be picked whole so we take a fraction that can be taken
                double fraction = ((double)capacity / (double)curWt);
                totalProfit += (curVal * fraction);
                capacity = (int)(capacity - (curWt * fraction));
                break;
            }
        }
 
        return totalProfit;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int[] weight = { 10, 40, 20, 30 };
        int[] profit = { 60, 40, 100, 120 };
        int capacity = 50;
 
        double maxValue = getMaxValue(weight, profit, capacity);

        System.out.println("Maximum value we can obtain = " + maxValue);
    }

}
