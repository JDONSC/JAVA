import java.util.Arrays;

public class Heaps {
    /**
     * 前提: 除了 index 和它的孩子外, 其他位置已经满足堆的性质了
     *
     * 经过向下调整(堆化),最终完全成为一个堆
     *
     * @param array 被看成堆的数组
     * @param size  数组中被看作堆的值的个数
     * @param index 要调整位置的下标
     */
    public static void heapify(int[] array, int size, int index){
        while(true){
            int left = 2 * index + 1;  //左孩子下标
            if(left >= size){
                return;
            }
            int max = left;
            if(left + 1 < size){
                if(array[left + 1] > array[left]){
                    max = left + 1;
                }
            }
            if(array[index] >= array[max]){
                return;
            }
            swap(array, index, max);
            index = max;
        }
    }

    private static void swap(int[] array, int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    //准确的结果是O(n)
    //粗略估算是 O(n * log(n))
    public static void createHeap(int[] array, int size){
        for(int i = (size - 2) / 2; i >= 0; i--){
            heapify(array, size, i);
        }
    }

    //O(log(n))
    //向上调整
    public static void adjustUp(int[] array, int index){
        while(index > 0){
            int parent = (index - 1) / 2;
            if(array[parent] >= array[index]){
                return;
            }

            swap(array, index, parent);
            index = parent;
        }
    }

    public static void main(String[] args) {
        int[] array = {-1, 8, 4, 6, 7, 2, 3, 1, 0};
        heapify(array, array.length, 0);
        System.out.println(Arrays.toString(array));

        int[] array1 = {3, 5, 2, 4, 9, 0, 1, 9, 8, 7, 2, 3, 8, 6, 3};
        createHeap(array1, array1.length);
        System.out.println(Arrays.toString(array1));
    }

    public static void createHeapMin(int[] array, int size){
        for(int i = (size - 2) / 2; i >= 0; i--){
            heapifyMin(array, size, i);
        }
    }

    public static void heapifyMin(int[] array, int size, int index){
        while(true){
            int left = 2 * index + 1;
            if(left >= size){
                return;
            }
            int min = left;
            if(left + 1 < size){
                if(array[left + 1] < array[left]){
                    min = left + 1;
                }
            }
            if(array[index] <= array[min]){
                return;
            }
            swap(array, index, min);
            index = min;
        }
    }
}
