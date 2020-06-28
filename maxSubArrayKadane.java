/*Find max sum of a sub-array in a given array (Kadane's algorithm)
Brute force and linear
Brute force: Get sum of all possible sub-arrays and select the maximum one
Linear: Get the max sub-array by selecting the maximum among the sum of all elements in the current
        sub-array and the next element in the subarray. If next element is negative, the sub-array
        till the negative element is taken.
*/

import java.util.*;
import java.lang.System;
import java.io.*;


class MaxSumKadane{

    // //brute force
    // public static int getMaxSum(int[] arr){
    //     int max_sum = 0;
    //     int curr_sum;
    //     for(int i=0;i<arr.length;++i){
    //         curr_sum = 0;
    //         for(int j=i;j<arr.length;++j){
    //             curr_sum+=arr[j];
    //             //System.out.println(curr_sum);
    //             if(curr_sum>max_sum) max_sum = curr_sum;
    //         }
    //     }
    //     return max_sum;
    // }

    public static int getMaxSum(int[] arr){
        int max_sum = 0;
        int curr_sum = max_sum;
        for(int i=0;i<arr.length;++i){
            curr_sum = Integer.max(curr_sum+arr[i], arr[i]);//if curr_sum + the next element is greater than the next element alone, take the curr_sum
            max_sum = Integer.max(max_sum,curr_sum);//If curr_sum is greater than max_sum, set max_sum as curr_sum
        }
        return max_sum;
    }

    public static void main(String args[]){
        int[] arr = {-2,2,5,4,-11,6};
        int maxSum = getMaxSum(arr);
        System.out.println("Max Sum = "+maxSum);
    }
}