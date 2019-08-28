public class MyPriorityQueue {
    //先不考虑 array 存不下数据的情况
    private int[] array = new int[100];
    private int size = 0;

    //O(log(n))
    //插入
    public void add(int element){
        array[size++] = element;
        Heaps.adjustUp(array, size - 1);
    }

    //O(log(n))
    //删除
    public int poll(){
        int e = array[0];
        array[0] = array[--size];
        Heaps.heapify(array, size, 0);
        return e;
    }

    //O(1)
    //返回当前最大值
    public int peek(){
        return array[0];
    }
}
