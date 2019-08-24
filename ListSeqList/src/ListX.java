class BNode{
    int val;
    BNode next = null;

    BNode(int val){
        this.val = val;
    }
}

public class ListX {
    private static BNode separate(BNode head, int x){
        //尾插

        BNode cur = head;
        BNode small = null;
        BNode smallLast = null;
        BNode big = null;
        BNode bigLast = null;

        while(cur != null){
            if(cur.val < x){
                //把cur尾插到small
                if(small == null){
                    small = cur;
                }else{
                    smallLast.next = cur;
                }
                smallLast = cur;
            }else{
                //把cur尾插到big
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
            cur = cur.next;
        }
        //把big接到small后边
        if(smallLast == null){
            return big;
        }else{
            smallLast.next = big;
        }

        if(bigLast == null){
            return small;
        }else{
            bigLast.next = null;
        }

        return small;
        //引用.属性
        //引用.方法
        //NullPointerException,没有对象
        //引用==null
        //1.根据引用找到对象
        //2.访问对象的属性或者调用对象的方法
    }

    private static BNode CreateList(){
        BNode n1 = new BNode(1);
        BNode n2 = new BNode(9);
        BNode n3 = new BNode(7);
        BNode n4 = new BNode(5);
        BNode n5 = new BNode(4);
        BNode n6 = new BNode(2);
        BNode n7 = new BNode(1);
        BNode n8 = new BNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        return n1;
    }

    public static void main(String[] args){
        BNode head = CreateList();

        BNode result = separate(head,5);

        for (BNode cur = result; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}
