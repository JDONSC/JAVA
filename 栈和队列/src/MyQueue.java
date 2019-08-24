public class MyQueue {
    static class Node{
        int value;
        Node next = null;

        Node(int value){
            this.value = value;
        }
    }

    private Node front = null;
    private Node rear = null;
    private int size = 0;

    public void push(int element){
        //尾插
        size++;
        if(rear != null) {
            rear.next = new Node(element);
            rear = rear.next;
        }else {
            front = rear = new Node(element);
        }
    }

    public int pop(){
        int element = front.value;
        size--;
        front = front.next;
        if(front == null){
            rear = null;
        }
        return element;
    }

    public int rear(){
        return rear.value;
    }

    public int front(){
        return front.value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
