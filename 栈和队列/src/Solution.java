import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static boolean isValid(String s){
        ArrayList<Character> stack = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch(ch){
                case'(': case'[': case'{':
                    stack.add(ch);
                    break;
                case')': case']': case'}':{
                    if(stack.isEmpty()){
                        return false;
                    }
                    char left = stack.remove(stack.size() - 1);
                    if(!match(left,ch)){
                        return false;
                    }
                    break;
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }

    private static boolean match(char left, char right){
        if(left == '(' && right == ')'){
            return true;
        }
        if(left == '[' && right == ']'){
            return true;
        }
        if(left == '{' && right == '}'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            boolean res = isValid(line);
            System.out.println(res);
        }
    }
}
