import java.util.Scanner;
import java.util.Stack;

public class Solution1 {
    public static boolean isVaild1(String s){
        Stack<Character> stack = new Stack<Character>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
                //遍历过程中如果stack为空,证明左符号少于右符号
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        //遍历完成以后如果stack不为空,那么证明左符号多于右符号
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String line = in.nextLine();
            boolean res = isVaild1(line);
            System.out.println(res);
        }
    }
}
