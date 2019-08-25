public class Trees {
    public static Node buildTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = null;
        d.right = null;
        e.left = null;
        e.right = h;
        f.left = null;
        f.right = null;
        g.left = null;
        g.right = null;
        h.left = null;
        h.right = null;

        return a;
    }

    //前序遍历
    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        //根 + 左子树 + 右子树
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        //左子树 + 根 + 右子树
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    //后序遍历
    public static void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        //左子树 + 右子树 + 根
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }

    public static int count = 0;
    public static void calcCount(Node root){
        if(root == null){
            return;
        }

        count++;
        calcCount(root.left);
        calcCount(root.right);
    }

    public static int leafCount = 0;
    public static void calcLeafCount(Node root){
        if(root == null){
            return;
        }

        calcCount1(root.left);
        //左孩子为空,右孩子为空
        if(root.left == null && root.right == null){
            leafCount++;
        }
        calcCount1(root.right);
    }

    public static int calcCount1(Node root){
        if(root == null){
            return 0;
        }
        int left = calcCount1(root.left);
        int right = calcCount1(root.right);
        int count = left + right + 1;
        return count;
    }

    public static int calcLeafCount1(Node root){
        if(root == null){
            return 0;
        }
        //左子树为空,右子树为空,代表只有一个结点的树
        if(root.left == null && root.right == null){
            return 1;
        }
        //左子树
        int left = calcLeafCount1(root.left);
        //右子树
        int right = calcLeafCount1(root.right);
        int leafCount = left + right;
        return leafCount;
    }

    public static int calcHeight(Node root) {
        if(root == null){
            return 0;
        }
        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        int height = Math.max(left,right) + 1;
        return height;
    }

    public static int calcKLevel(Node root, int k){
        if(root == null){
            return 0;
        }

        if(k == 1){
            return 1;
        }

        int left = calcKLevel(root.left,k - 1);
        int right = calcKLevel(root.right,k - 1);
        int count = left + right;
        return count;
    }

    public static Node search(Node root, char val){
        if(root == null){
            return null;
        }

        if(root.value == val){
            return root;
        }

        //去左子树查找
        Node left = search(root.left,val);
        if(left != null){
            return left;
        }

        //去右子树查找
        Node right = search(root.right,val);
        if(right != null){
            return right;
        }

        return null;
    }

    public static boolean search1(Node root, char val){
        if(root == null){
            return false;
        }

        if(root.value == val){
            return true;
        }

        if(search1(root.left,val)){
            return true;
        }

        return search1(root.right,val);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        preOrderTraversal(root);
        System.out.println("==========");
        inOrderTraversal(root);
        System.out.println("==========");
        postOrderTraversal(root);

        count = 0;
        calcCount(root);
        System.out.println(count);
        count = 0;
        calcCount(root);
        System.out.println(count);

        calcCount1(root);
        System.out.println(count);

        System.out.println(calcHeight(root));

        System.out.println(calcKLevel(root,3));

        System.out.println(search(root,'E').value);
        System.out.println(search1(root,'Y'));
    }
}
