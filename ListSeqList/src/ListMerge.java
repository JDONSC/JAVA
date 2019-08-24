class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}

public class ListMerge {
    private static Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }
        // 1. 分别遍历两个链表，取值比较小的结点，尾插到新链表中
        // 2. 把剩余链表接到新链表的后边

        Node cur1 = head1;
        Node cur2 = head2;
        Node rhead = null;
        Node rlast = null;

        while (cur1 != null && cur2 != null) {
            // 取值比较小的结点
            if (cur1.val <= cur2.val) {
                // 把 c1 尾插到新链表
                // 如果链表中没有结点，更新链表的第一个结点
                // 否则，找到链表的最后一个结点，让它的 next = 要插入的结点
                if (rhead == null) {
                    rhead = cur1;
                } else {
                    rlast.next = cur1;
                }

                // 再更新下链表的最后一个结点
                rlast = cur1;

                // 让 c1 指向原来的下一个结点
                cur1 = cur1.next;
            } else {
                // 把 c2 尾插到新链表
                if (rhead == null) {
                    rhead = cur2;
                } else {
                    rlast.next = cur2;
                }

                rlast = cur2;

                cur2 = cur2.next;
            }
        }

        if (cur1 != null) {
            rlast.next = cur1;
        } else {
            rlast.next = cur2;
        }

        return rhead;
    }

    private static Node List1() {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(3);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(9);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        return n1;
    }

    private static Node List2() {
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        n1.next = n2;
        n2.next = n3;

        return n1;
    }

    public static void main(String[] args) {
        Node head1 = List1();
        Node head2 = List2();

        Node result = merge(head1, head2);

        for (Node cur = result; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
}