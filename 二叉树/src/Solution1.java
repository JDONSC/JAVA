import java.util.ArrayList;
import java.util.List;

public class Solution1 {
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

    //前序
    public static List<Character> preOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Character> list = new ArrayList<>();
        List<Character> leftPreOrder = preOrder(root.left);
        List<Character> rightPreOrder = preOrder(root.right);

        list.add(root.val);
        list.addAll(leftPreOrder);
        list.addAll(rightPreOrder);

        return list;
    }

    //中序
    public static List<Character> inOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Character> leftInOrder = inOrder(root.left);
        List<Character> list = new ArrayList<>();
        List<Character> rightInOrder = inOrder(root.right);

        list.addAll(leftInOrder);
        list.add(root.val);
        list.addAll(rightInOrder);

        return list;
    }

    //后序
    public static List<Character> postOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Character> leftPostOrder = postOrder(root.left);
        List<Character> rightPostOrder = postOrder(root.right);
        List<Character> list = new ArrayList<>();

        list.addAll(leftPostOrder);
        list.addAll(rightPostOrder);
        list.add(root.val);

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        System.out.println(preOrder(root));
        System.out.println("=======================");
        System.out.println(inOrder(root));
        System.out.println("=======================");
        System.out.println(postOrder(root));
    }
}
