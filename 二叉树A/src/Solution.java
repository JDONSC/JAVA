public class Solution {
    public static int calcHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(calcHeight(root.left), calcHeight(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root){
        //平衡树的条件
        //0. 空树是平衡的
        //1. 左子树是平衡的
        //2. 右子树是平衡的
        //3. 左右子树高度差不超过1
        if(root == null){
            return true;
        }

        boolean leftBalance = isBalanced(root.left);
        boolean rightBalance = isBalanced(root.right);

        if(!leftBalance){
            return false;
        }

        if(!rightBalance){
            return false;
        }

        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);
        int diff = leftHeight - rightHeight;
        //Math.abs()求绝对值
        if(diff < 1 || diff > -1){
            return true;
        }

        return false;
    }

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public static boolean search(TreeNode root, TreeNode n){
        if(root == null){
            return false;
        }

        if(root == n){
            return true;
        }

        if(search(root.left, n)){
            return true;
        }
        return search(root.right, n);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == p || root == q){
            return root;
        }

        boolean pInLeft = search(root.left, p);
        boolean qInLeft = search(root.left, q);

        if(pInLeft && qInLeft){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(!pInLeft && qInLeft){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
