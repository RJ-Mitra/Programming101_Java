package Hangman;

import java.util.*;
import java.lang.System;
import java.io.*;

// class Practise{

//     public Boolean checkSumOfTwo(int arr1[], int arr2[], int sum){
//         HashSet<Integer> refSet = new HashSet<Integer>();
//         for(int i=0;i<arr1.length;++i){
//             refSet.add(sum-arr1[i]);
//         }
//         for(int i=0;i<arr2.length;++i){
//             if(refSet.contains(arr2[i])) return true;
//         }
//         return false;
//     }
//     public static void main(String args[]){
//         int arr1[] = {2,4,6,8,-10,-23};
//         int arr2[] = {32,8,23,10};
//         int sum = 26;

//         Practise p = new Practise();

//         boolean isSum = p.checkSumOfTwo(arr1, arr2, sum);
//         System.out.println(isSum);
//     }
// }


// class paranthesisCheckTest{
//     static class Stack{
//         int top=-1;
//         char items[] = new char[100];

//         void push(char e){
//             if(top > 99){
//                 System.out.println("Stack is full");
//             }else{
//                 items[++top] = e;
//             }
//         }

//         char pop(){
//             char e;
//             if(top == -1){
//                 System.out.println("Underflow error");
//                 e = '\0';
//             }else{
//                 e = items[top];
//                 --top;
//             }
//             return e;
//         }

//         boolean isEmpty(){
//             return (top==-1);
//         }
//     }

//     static boolean isMatchingPair(char left, char right){
//         if(left=='(' && right==')') return true;
//         if(left=='{' && right=='}') return true;
//         if(left=='[' && right==']') return true;
//         return false;
//     }

//     static boolean isBalanced(String expr){

//         Stack stack = new Stack();
//         for(int i=0;i<expr.length();++i){
//             if(expr.charAt(i) == '(' || expr.charAt(i) == '{' || expr.charAt(i) == '['){
//                 stack.push(expr.charAt(i));
//             }
//             if(expr.charAt(i) == ')' || expr.charAt(i) == '}' || expr.charAt(i) == ']'){
//                 if(stack.isEmpty()) return false;
//                 if(!isMatchingPair(stack.pop(), expr.charAt(i))) return false;
//             }
//         }
//         if(stack.isEmpty()) return true;
//         else return false;
//     }
//     public static void main(String[] args)  
//     { 
//         String exp = "int main(){print(Hello)}"; 
//         if (isBalanced(exp)) 
//            System.out.println("Balanced."); 
//         else
//            System.out.println("Not Balanced.");   
//     }
// }

// public class Trie{
//     private class TrieNode{//New TrieNode class with a map of the next char and address to the next char node
//         Map<Character,TrieNode> children;
//         boolean endOfWord;//bool variable set to true if the node is the last node/char of a word

//         public TrieNode(){
//             children = new HashMap<>(); //constructor to Trie Node class
//             endOfWord = false;
//         }
//     }

//     public final TrieNode root; //class variable root of type TrieNode in Trie class
//     public Trie(){ //Contructor of Trie class
//         root = new TrieNode();
//     }

//     public void insert(String word){
//         TrieNode current = root;//Sets the current node to the root node
//         for(int i=0;i<word.length;++i){ //Iterate through each word
//             char c = word.charAt(i);//Get each char from word
//             TrieNode node = current.children.get(c);//Gets address to node of the character in map, returns null if character does not exist in map
//             if(node == null){
//                 node = new TrieNode(); //If null, creates new trie node
//                 current.children.put(c, node); //Pushes the character and node in the map of the newly create node
//             }//If node exists already, we check if the node has a reference to the next node
//             current = node; //Sets the newly created node as the current node to link next char in word to this node
//         }
//         current.endOfWord = true; //After all char nodes are created, sets status of last node to true
//     }
// }


// class RearrangeString{
//     static String getRearrangedString(String str){
//         HashMap<Character,Integer> charCount = new HashMap<>();
//         for(char c:str.toCharArray()){
//                 charCount.put(c, charCount.getOrDefault(c,0)+1);
//             }
//         PriorityQueue<Character> MaxHeap = new PriorityQueue<>((a,b)->charCount.get(b) - charCount.get(a));
//         MaxHeap.addAll(charCount.keySet());
//         StringBuilder result = new StringBuilder();
//         while(MaxHeap.size()>1){
//             char curr = MaxHeap.remove();
//             char next = MaxHeap.remove();
//             result.append(curr);
//             result.append(next);
//             charCount.put(curr,charCount.get(curr)-1);
//             charCount.put(next,charCount.get(next)-1);
//             if(charCount.get(curr)>0) MaxHeap.add(curr);
//             if(charCount.get(next)>0) MaxHeap.add(next);
//         }
//         if(!MaxHeap.isEmpty()){
//             char last = MaxHeap.remove();
//             if(charCount.get(last)>1) return "";
//             result.append(last);
//         }
//         return result.toString();
//     }
//     public static void main(String args[]){
//         String inputString = "aabcaddceaff";
//         String result = getRearrangedString(inputString);
//         System.out.println(result);
//     }
// }


// class MaxSumOfLabelValues{
//     //Class to store the label and value combination instead of referring to two separate lists
//     class Item{
//         int label;
//         int value;

//         public Item(int label, int value){
//             this.label = label;
//             this.value = value;
//         }
//     }

//     public int getMaxSum(int[] values, int[] labels, int num_wanted, int use_limit){
//         List<Item> items = new ArrayList<>();//List of the items of each label-value combo
//         for(int i=0;i<labels.length;++i){
//             items.add(new Item(labels[i],values[i]));//Adding all label-value combos in the list
//         }
//         PriorityQueue<Item> maxHeap = new PriorityQueue<>((Item a, Item b)-> b.value - a.value);//max heap to values
//         maxHeap.addAll(items);//Adding all the items (label-value combo) in the max Heap.
//         Map<Integer,Integer> labelCount = new HashMap<>(); //Hash map to store count of each label

//         int max_sum = 0;//maximum sum variable initialized
//         while(!maxHeap.isEmpty() && num_wanted>0){
//             Item current_item = maxHeap.remove();
//             labelCount.put(current_item.label, labelCount.getOrDefault(current_item.label, 0)+1);
//             if(labelCount.get(current_item.label)<=use_limit){
//                 max_sum+=current_item.value;
//                 num_wanted--;
//             }
//         }
//         return max_sum;
//     }
//     public static void main(String args[]){
//         int[] values = {5,4,3,2,1};
//         int[] labels = {1,3,3,3,2};
//         int num_wanted = 3;
//         int use_limit = 1;
//         MaxSumOfLabelValues resObj = new MaxSumOfLabelValues();
//         int res = resObj.getMaxSum(values,labels,num_wanted,use_limit);
//         System.out.println(res);
//     }
// }


/*Find max sum of a sub-array in a given array (Kadane's algorithm)
*/

// class MaxSumKadane{

//     // //brute force
//     // public static int getMaxSum(int[] arr){
//     //     int max_sum = 0;
//     //     int curr_sum;
//     //     for(int i=0;i<arr.length;++i){
//     //         curr_sum = 0;
//     //         for(int j=i;j<arr.length;++j){
//     //             curr_sum+=arr[j];
//     //             //System.out.println(curr_sum);
//     //             if(curr_sum>max_sum) max_sum = curr_sum;
//     //         }
//     //     }
//     //     return max_sum;
//     // }

//     public static int getMaxSum(int[] arr){
//         int max_sum = 0;
//         int curr_sum = max_sum;
//         for(int i=0;i<arr.length;++i){
//             curr_sum = Integer.max(curr_sum+arr[i], arr[i]);
//             max_sum = Integer.max(max_sum,curr_sum);
//         }
//         return max_sum;
//     }

//     public static void main(String args[]){
//         int[] arr = {-2,2,5,4,-11,6};
//         int maxSum = getMaxSum(arr);
//         System.out.println("Max Sum = "+maxSum);
//     }
// }



// class Hangman{

//     public static String getWord(){
//         double randomNum = Math.random();
//         int index = (int)(Math.floor(randomNum*100));
//         String[] common = {"the","of","and","ant","total","intelligent","island","you","that","bait","she","was","for","online","are","castor","with","his","they","open","at","be","this","have","from","valor","one","had","by","word","button","not","what","all","were","we","when","your","can","said","there","use","titan","each","which","she","do","how","their","if","will","up","other","about","out","many","then","them","these","so","some","her","would","make","like","him","into","time","has","look","two","more","write","goat","see","number","no","way","could","people","my","than","first","water","been","call","who","oil","its","now","find","long","down","day","did","get","come","made","may","part"};
//         return common[index];
//     }

//     public static void guess(String word){
//         int guesses = 6;
//         int wordLen = word.length();

//         char[] wordArr = new char[wordLen];
//         for(int i=0;i<wordLen;++i){
//             wordArr[i] = word.charAt(i);
//         }

//         char[] guessed = new char[wordLen];
//         for(int i=0;i<wordLen;++i){
//             guessed[i] = '*';
//         }

//         System.out.println("Guess the word: ");
//         for(char c:guessed) System.out.print(c);
//         System.out.println();
        
//         Scanner sc = new Scanner(System.in);
//         while(guesses>0){
//             System.out.println("Guess a character: ");
//             char guessed_char = sc.nextLine().charAt(0);
//             //Create guessed list check to prevent re entering of previously guessed char
//             boolean isCorrect = false;
//             for(int i=0;i<wordLen;++i){
//                 if(wordArr[i] == guessed_char){
//                     isCorrect = true;
//                     guessed[i] = guessed_char;
//                 }
//             }
//             if(isCorrect==false){
//                 System.out.println("Wrong guess");
//                 guesses--;
//                 System.out.println("Choices left: "+guesses);
//             }
//             boolean hasWon = true;
//             for(char c:guessed){
//                 if(c=='*') hasWon = false;
//             }
//             if(!hasWon){
//                 for(char c:guessed) System.out.print(c);
//                 System.out.println("\n");
//             }else{
//                 System.out.println("You won!");
//                 System.out.println("Word is "+word);
//                 return;
//             }               
//         }
//         System.out.println("Word is "+word+". Better luck next time!");
//         System.out.println("::: Game Over :::\n");
//         return;
//     }

//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         char choice = 'Y';
//         while(choice=='Y'||choice=='y'){
//             guess(getWord());
//             System.out.println("Play again? (Y/N) ");
//             choice=sc.next().charAt(0);
//         }
//         System.out.println("Thanks for playing Hangman.");
//         sc.close();
//     }
// }




class Test{
    public static void main(String... args){
        Words w = new Words();
        System.out.println(w.common[0]);
    }
}