class ANode{
    int val;
    ANode next;

    ANode(int val){
        this.val = val;
    }
}

public class ListReverse {
    private static ANode reverse(ANode head){
        ANode result = null;   //结果链表
        ANode cur = head;
        while(cur != null){
            ANode next = cur.next;

            cur.next = result;
            result = cur;

            cur = next;
        }
        return result;
    }

    private static ANode ReverseList() {

        ANode n1 = new ANode(1);
        ANode n2 = new ANode(3);
        ANode n3 = new ANode(6);
        ANode n4 = new ANode(9);
        ANode n5 = new ANode(2);
        ANode n6 = new ANode(5);
        ANode n7 = new ANode(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        return n1;
    }

    public static void main(String[] args){
        ANode head = ReverseList();

        ANode result = reverse(head);

        for (ANode cur = result; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}


