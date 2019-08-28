import java.util.*;

public class Trees {
    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode front = queue.poll();

            System.out.println(front.val);
            if(front.left != null){
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }
    }

    private static class Element{
        TreeNode node;
        int level;            //层数

        Element(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> reList = new ArrayList<>();
        if(root == null){
            return reList;
        }

        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(root, 0));

        while(!queue.isEmpty()){
            Element front = queue.poll();

            if(front.level == reList.size()){
                reList.add(new ArrayList<>());
            }
            reList.get(front.level).add(front.node.val);

            if(front.node.left != null){
                queue.add(new Element(front.node.left, front.level + 1));
            }

            if(front.node.right != null){
                queue.add(new Element(front.node.right, front.level + 1));
            }
        }
        return reList;
    }

    public static boolean isCompleteTree(TreeNode root){
        if(root == null) {
            return true;
        }

        //层序遍历,直到遇到 null
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(true) {
            TreeNode front = queue.poll();
            if (front == null) {
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }

        //判断队列中剩余元素是否都是 null
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                return false;
            }
        }
        return true;
    }

    //非递归前序遍历
    public static void preorderNoR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.empty() || cur != null){
            while(cur != null){
                System.out.println(cur.val);
                //入栈
                stack.push(cur);
                cur = cur.left;
            }

            //出栈
            TreeNode top = stack.pop();
            cur = top.right;
        }
    }

    //非递归中序遍历
    public static void inorderNoR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.empty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val);
            cur = top.right;
        }
    }

    //非递归后序遍历
    public static void postorderNoR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;          //上一次被三次完整经过的结点

        while(!stack.empty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            if(top.right == null || top.right == last) {
                stack.pop();
                System.out.println(top.val);
                last = top;
            }else {
                cur = top.right;
            }
        }
    }
}