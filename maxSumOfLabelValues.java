/* Two arrays are given -> labels and values. Each index of labels has an integer number as the category
and the corresponding index of the values array has the value for that label.
E.g. labels = 1,2,2,3,1
     values = 7,9,2,5,6
where the values under label one are 7 and 6.
Also given are max_limit (limit of usage of values in each category) and num_wanted (number of total elements)
E.g. max_limit = 2 (Only 2 values from each category can be considered)
     num_wanted = 4 (Total 4 values can be considered.)

Need to find max sum of all valid elements.
*/

import java.util.*;
import java.lang.System;
import java.io.*;

class MaxSumOfLabelValues{
    //Class to store the label and value combination instead of referring to two separate lists
    class Item{
        int label;
        int value;

        public Item(int label, int value){
            this.label = label;
            this.value = value;
        }
    }

    //Function to find the max sum
    public int getMaxSum(int[] values, int[] labels, int num_wanted, int use_limit){
        List<Item> items = new ArrayList<>();//List of the items of each label-value combo
        for(int i=0;i<labels.length;++i){
            items.add(new Item(labels[i],values[i]));//Adding all label-value combos in the list
        }
        PriorityQueue<Item> maxHeap = new PriorityQueue<>((Item a, Item b)-> b.value - a.value);//max heap to values
        maxHeap.addAll(items);//Adding all the items (label-value combo) in the max Heap.
        Map<Integer,Integer> labelCount = new HashMap<>(); //Hash map to store count of each label

        int max_sum = 0;//maximum sum variable initialized
        while(!maxHeap.isEmpty() && num_wanted>0){//if heap is not empty or number of elements required is still more than 0
            Item current_item = maxHeap.remove();//Item object with highest value is popped from the stack
            labelCount.put(current_item.label, labelCount.getOrDefault(current_item.label, 0)+1);//If the corresponding label of the popped value is not present in the count list, it is added.
            if(labelCount.get(current_item.label)<=use_limit){//if the label count of the current item is less than the provided limit, it is considered
                max_sum+=current_item.value;//max sum variable is increased by the value of the current element
                num_wanted--;//Number of elements still required is decremented.
            }
        }
        return max_sum;
    }
    public static void main(String args[]){
        int[] values = {5,4,3,2,1};
        int[] labels = {1,3,3,3,2};
        int num_wanted = 3;
        int use_limit = 1;
        MaxSumOfLabelValues resObj = new MaxSumOfLabelValues();
        int res = resObj.getMaxSum(values,labels,num_wanted,use_limit);
        System.out.println(res);
    }
}