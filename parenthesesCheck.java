import java.util.*;
import java.lang.System;
import java.io.*;

class paranthesisCheckTest{
    static class Stack{
        int top=-1;
        char items[] = new char[100];

        void push(char e){
            if(top > 99){
                System.out.println("Stack is full");
            }else{
                items[++top] = e;
            }
        }

        char pop(){
            char e;
            if(top == -1){
                System.out.println("Underflow error");
                e = '\0';
            }else{
                e = items[top];
                --top;
            }
            return e;
        }

        boolean isEmpty(){
            return (top==-1);
        }
    }

    static boolean isMatchingPair(char left, char right){
        if(left=='(' && right==')') return true;
        if(left=='{' && right=='}') return true;
        if(left=='[' && right==']') return true;
        return false;
    }

    static boolean isBalanced(String expr){

        Stack stack = new Stack();
        for(int i=0;i<expr.length();++i){
            if(expr.charAt(i) == '(' || expr.charAt(i) == '{' || expr.charAt(i) == '['){
                stack.push(expr.charAt(i));
            }
            if(expr.charAt(i) == ')' || expr.charAt(i) == '}' || expr.charAt(i) == ']'){
                if(stack.isEmpty()) return false;
                if(!isMatchingPair(stack.pop(), expr.charAt(i))) return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    public static void main(String[] args)  
    { 
        String exp = "int main(){print(Hello)}"; 
        if (isBalanced(exp)) 
           System.out.println("Balanced."); 
        else
           System.out.println("Not Balanced.");   
    }
}