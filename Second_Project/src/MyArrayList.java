import java.util.Arrays;

public class MyArrayList implements List {
    // 懒加载的模型
    // 1. 好处：节省空间，用的时候再申请
    // 2. 坏处：第一用到时，耗时比平时更大
    int[] array = null;
    int size = 0;

    private void ensureCapacity(){
        //容量够用,直接返回
        if(array != null && size < array.length){
            return ;
        }

        //计算新的容量大小
        int capacity;
        if(array == null){
            capacity = 10;
        }else{
            capacity = 2 * array.length;
        }

        //申请新空间 - 搬家 - 发朋友圈
        if(array != null){
            array = Arrays.copyOf(array,capacity);
        }else{
            array = new int[capacity];
        }
    }

    @Override
    public boolean add(int element) {
        return add(size, element);
    }

    @Override
    public boolean add(int index, int element) {
        //1.index的合法性
        if(index < 0 || index > size){
            System.out.println("越界");
            return false;
        }

        //2.空间(容量)够不够再插一个数,确保空间够用
        ensureCapacity();

        //3.为index腾空间
        System.arraycopy(array, index, array, index + 1,size - index);

        //4.插入元素
        array[index] = element;

        //5.长度加一
        size++;

        return true;
    }

    @Override
    public int get(int index) {
        //判断下标合法性
        if(index < 0|| index >= size){
            System.out.println("下标错误");
            return -1;
        }

        return array[index];
    }

    @Override
    public int set(int index, int val) {
        if(index < 0|| index >= size){
            System.out.println("下标错误");
            return -1;
        }

        int oldVal = array[index];
        array[index] = val;

        return oldVal;
    }

    @Override
    public int remove(int index) {
        if(index < 0|| index >= size){
            System.out.println("下标错误");
            return -1;
        }
        int oldValue = array[index];
        System.arraycopy(array,index + 1, array, index, size - index - 1);

        size--;

        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array,size));
    }
}
