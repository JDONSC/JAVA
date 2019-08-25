import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    public static boolean isSameTree(Node p, Node q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return p.value == q.value
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static boolean isMirror(Node p, Node q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        if(p.value == q.value){
            return true;
        }

        if(isMirror(p.left,q.right)){
            return true;
        }

        if(isMirror(q.left,p.right)){
            return true;
        }

        return false;
    }

    public static boolean search(Node root, Node t){
        if(root == null){
            return false;
        }

        if(root.value == t.value && isSameTree(root,t)){
            return true;
        }

        //去左子树查找
        if(search(root.left,t)){
            return true;
        }

        //去右子树查找
        return search(root.right,t);
    }

    public static boolean isSubtree(Node s, Node t){
        return search(s,t);
    }

    //前序 + 中序
    public static Node buildTree(List<Character> preorder, List<Character> inorder){
        if(preorder.size() == 0){
            return null;
        }
        char rootValue = preorder.get(0);
        int leftCount = inorder.indexOf(rootValue);

        Node root = new Node(rootValue);

        List<Character> leftPreOrder = preorder.subList(1,1 + leftCount);
        List<Character> leftInOrder = inorder.subList(0, leftCount);
        Node left = buildTree(leftPreOrder,leftInOrder);
        root.left = left;

        List<Character> rightPreOrder = preorder.subList(1 + leftCount, preorder.size());
        List<Character> rightInOrder = inorder.subList(leftCount + 1, inorder.size());
        Node right = buildTree(rightPreOrder,rightInOrder);
        root.right = right;
        return root;
    }

    //中序 + 后序
    public static Node buildTree1(List<Character> inorder, List<Character> postorder){
        if(inorder.size() == 0){
            return null;
        }
        char rootValue = postorder.get(postorder.size() - 1);
        int leftCount = inorder.indexOf(rootValue);

        Node root = new Node(rootValue);

        List<Character> leftInOrder = inorder.subList(0, leftCount);
        List<Character> leftPostOrder = postorder.subList(0, leftCount);
        Node left = buildTree(leftInOrder,leftPostOrder);
        root.left = left;

        List<Character> rightInOrder = inorder.subList(leftCount + 1, inorder.size());
        List<Character> rightPostOrder = postorder.subList(leftCount, postorder.size() - 1);
        Node right = buildTree(rightInOrder,rightPostOrder);
        root.right = right;
        return root;
    }

    //利用数组  前序 + 中序
    public static TreeNode buildTreeArray(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        }

        int rootValue = preorder[0];
        int leftCount = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootValue){
                leftCount = i;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1,leftCount + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0,leftCount);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftCount + 1, preorder.length + 1);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftCount + 1, inorder.length + 1);

        TreeNode root = new TreeNode();
        root.value = rootValue;
        root.left = buildTreeArray(leftPreorder, leftInorder);
        root.right = buildTreeArray(rightPreorder, rightInorder);

        return root;
    }

    //利用数组  中序 + 后序
    public static TreeNode buildTreeArray1(int[] inorder, int[] postorder){
        if(inorder.length == 0){
            return null;
        }

        int rootValue = postorder[postorder.length - 1];
        int leftCount = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootValue){
                leftCount = i;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftCount);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftCount);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftCount + 1, inorder.length);
        int[] rightpostorder = Arrays.copyOfRange(postorder, leftCount, postorder.length - 1);

        TreeNode root = new TreeNode();
        root.value = rootValue;
        root.left = buildTreeArray1(leftInorder, leftPostorder);
        root.right = buildTreeArray1(rightInorder, rightpostorder);

        return root;
    }

    public static class ReturnValue{
        Node root;
        int used;
    }

    public static ReturnValue buildTreeProOrder(List<Character> preorder){
        if(preorder.size() == 0){
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 0;

            return rv;
        }

        char rootValue = preorder.get(0);

        if(rootValue == '#'){
            ReturnValue rv = new ReturnValue();
            rv.root = null;
            rv.used = 1;

            return rv;
        }

        ReturnValue leftRV = buildTreeProOrder(preorder.subList(1,preorder.size()));
        ReturnValue rightRV = buildTreeProOrder(preorder.subList(1 + leftRV.used,preorder.size()));

        Node root = new Node(rootValue);
        root.value = rootValue;
        root.left = leftRV.root;
        root.right = rightRV.root;

        ReturnValue rv= new ReturnValue();
        rv.root = root;
        rv.used = 1 + leftRV.used + rightRV.used;

        return rv;
    }

    //层序遍历
    public static void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node front = queue.poll();

            System.out.println(front.value);
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }
    }

    public static void main(String[] args) {
        List<Character> preOrder = Arrays.asList('A', 'B', 'D', 'E', 'G', 'C', 'F', 'H');
        List<Character> inOrder = Arrays.asList('D', 'B', 'G', 'E', 'A', 'C', 'F', 'H');
        List<Character> postOrder = Arrays.asList('D', 'G', 'E', 'B', 'H', 'F', 'C', 'A');
        Node root = buildTree(preOrder,inOrder);
        System.out.println("成功");
        Node root1 = buildTree1(inOrder,postOrder);
        System.out.println("成功");

        List<Character> preorder = Arrays.asList('A', 'B', 'C', '#', '#', '#', 'D', '#', 'E', '#', '#');
        ReturnValue root2 = buildTreeProOrder(preorder);
        System.out.println("成功");

        levelOrderTraversal(root2.root);
    }

    private static void preorder(StringBuilder sb, TreeNode root){
        if(root == null){
            return;
        }
        sb.append("(");
        sb.append(root.value);
        if(root.left == null && root.right == null){
            sb.append("()");
        }else{
            preorder(sb, root.left);
        }
        preorder(sb, root.right);
        sb.append(")");
    }

    public static String tree2str(TreeNode t){
        if(t == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(sb, t);
        String r = sb.toString();
        return r.substring(1, r.length() - 1);
    }
}
