import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.push("C++");
        list.push("JavaSE");
        list.push("数据");
        list.push("系统");
        System.out.println(list.pop());
        System.out.println(list.size());

        list.addLast("C");
        list.addLast("Java");
        list.addLast("数据结构");
        list.addLast("操作系统");
        System.out.println(list.peek());
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        System.out.println(list.size());

        System.out.println(list.poll());
        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());
        System.out.println(list.size());
    }
}
