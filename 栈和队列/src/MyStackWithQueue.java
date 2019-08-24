import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithQueue {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x){
        //尾插
        queue.add(x);
    }

    public int pop(){
        //先把前 size-1 个数,处理
        int size = queue.size();
        for(int i = 0; i < size - 1; i++){
            int v = queue.poll();
            queue.add(v);
        }

        return queue.poll();
    }

    public int top(){
        int size = queue.size();
        for(int i = 0; i < size - 1; i++){
            int v = queue.poll();
            queue.add(v);
        }

        int v = queue.poll();
        queue.add(v);

        return v;
    }

    public boolean empty(){
        return queue.isEmpty();
    }
}
