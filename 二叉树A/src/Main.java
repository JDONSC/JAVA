import java.util.Arrays;
import java.util.Scanner;

class ReturnValue{
    TreeNode root;
    int used;
}

public class Main {
    private static ReturnValue buildTree(char[] preorder){
        return null;
    }

    private static void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        inorderTraversal(root.left);
        System.out.println(root.value + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String preorderLine = scanner.nextLine();
        char[] preOrder = preorderLine.toCharArray();
        ReturnValue rv = buildTree(preOrder);
        inorderTraversal(rv.root);
    }
}
