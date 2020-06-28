/*Problem to write program that takes a string and outputs the rearranged string such that
no two same characters in the string are placed next to each other. Outputs empty string if
such an arrangement is not possible.
E.g. aab -> aba; aaab -> ""*/
import java.util.*;
import java.lang.System;
import java.io.*;


class RearrangeString{
    static String getRearrangedString(String str){
        HashMap<Character,Integer> charCount = new HashMap<>();
        for(char c:str.toCharArray()){
                charCount.put(c, charCount.getOrDefault(c,0)+1);
            }
        PriorityQueue<Character> MaxHeap = new PriorityQueue<>((a,b)->charCount.get(b) - charCount.get(a));
        MaxHeap.addAll(charCount.keySet());
        StringBuilder result = new StringBuilder();
        while(MaxHeap.size()>1){
            char curr = MaxHeap.remove();
            char next = MaxHeap.remove();
            result.append(curr);
            result.append(next);
            charCount.put(curr,charCount.get(curr)-1);
            charCount.put(next,charCount.get(next)-1);
            if(charCount.get(curr)>0) MaxHeap.add(curr);
            if(charCount.get(next)>0) MaxHeap.add(next);
        }
        if(!MaxHeap.isEmpty()){
            char last = MaxHeap.remove();
            if(charCount.get(last)>1) return "";
            result.append(last);
        }
        return result.toString();
    }
    public static void main(String args[]){
        String inputString = "aabcaddceaff";
        String result = getRearrangedString(inputString);
        System.out.println(result);
    }
}