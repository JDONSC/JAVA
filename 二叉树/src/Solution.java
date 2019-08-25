import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static TreeNode buildTree() {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        d.left = null; d.right = null;
        e.left = null; e.right = h;
        f.left = null; f.right = null;
        g.left = null; g.right = null;
        h.left = null; h.right = null;

        return a;
    }

    private static List<Character> list;

    //前序遍历
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    //后序遍历
    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }

    public static List<Character> preorderTraversal(TreeNode root){
        list = new ArrayList<>();
        preOrder(root);
        return list;
    }

    public static List<Character> inorderTraversal(TreeNode root){
        list = new ArrayList<>();
        inOrder(root);
        return list;
    }

    public static List<Character> postorderTraversal(TreeNode root){
        list = new ArrayList<>();
        postOrder(root);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        System.out.println(preorderTraversal(root));
        System.out.println("==========");
        System.out.println(inorderTraversal(root));
        System.out.println("==========");
        System.out.println(postorderTraversal(root));
    }
}
