import java.util.Arrays;
//Sequence List
//顺序表中保存的数据元素类型是int
public class SeqList{
	//属性
	private int[] array;     //用来保存数据
	private int size;        //用来array中已经有的数据个数
	
	//构造方法
	public SeqList(){
		//初始化部分
		//1.初始化array,给定一个默认大小
		//2.初始化size,没有数据,所以size=0
		array = new int[11];   //11可以调节
		size = 0;
	}
	
	//支持的方法
	//头插
	public void pushFront(int element){
		ensureCapacity();
		//1.需要从后往前遍历,否则数据会被覆盖
		//2.数据下标遍历的范围[size-1,0],空间下标遍历范围[size,1]
		//3.搬移的过程 array[空间] = array[数据],空间的下标=数据的下标+1
		for(int i = size - 1; i >= 0; i--){    //i是数据下标
			array[i + 1] = array[i];
		}
		//[0]空出来
		array[0] = element;
		size++;
	}
	//O(n)
	
	//尾插
	public void pushBack(int element){
		ensureCapacity();
		array[size++] = element;
	}
	//O(1)
	
	//中间插入,根据下标做插入
	public void insert(int index, int element){
		//index的合法性
		if(index < 0 || index > size){
			System.out.println("index非法");
			return;
		}
		
		ensureCapacity();
		//类似于头插
		//i空间的下标
		
		for(int i = size; i > index; i--){
			array[i] = array[i - 1]; 
		}
		
		/*
		i数据的下标
		for(int i = size - 1; i >= index; i--){
			array[i + 1] = array[i];
		}
		*/
		
		/*
		i循环的次数
		for(int i = 0; i < size - index; i++){
			array[size - i] = array[size - i - 1];
		}
		*/
		
		//[index]空出来
		array[index] = element;
		size++;
	}
	//O(n)
	
	//头删
	public void popFront(){
		if(size == 0){
			System.out.println("空顺序表,无法删除");
			return;
		}
		
		//从前往后
		for(int i = 0; i < size - 1; i++){
			array[i] = array [i + 1];
		}
		array[--size] = 0;
	}
	
	public void popBack(){
		if(size == 0){
			System.out.println("空顺序表,无法删除");
			return;
		}
		array[--size] = 0;
	}
	
	public void erase(int index){
		if(size == 0){
			System.out.println("空顺序表,无法删除");
			return;
		}
		
		for(int i = index; i < size - 1; i++){
			array[i] = array [i + 1];
		}
		size--;
	}
	
	//查找
	public int indexOf(int element){
		for(int i = 0; i < size; i++){
			if(array[i] == element){
				return i;
			}
		}
		return -1;
	}
	
	//根据下标,获取元素
	public int get(int index){
		if(index < 0 || index >= size){
			System.out.println("下标错误");
			return -1;
		}
		return array[index];
	}
	
	//给定下标,修改下标所在的元素的值
	public void set(int index, int element){
		array[index] = element;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int capacity(){
		return array.length;
	}
	
	//便于打印,显示顺序表中已有元素
	public String toString(){
		return Arrays.toString(Arrays.copyOf(array,size));
	}
	
	//删除指定元素
	public void remove(int element){
		int index = indexOf(element);
		if(index != -1){
			erase(index);
		}
	}
	//O(n)
	
	//删除所有指定元素,相同的数字
	public void removeAll(int element){
		/*
		时间O(n^2)  空间O(1)
		int index;
		while((index = indexOf(element)) != -1){
			erase(index);
		}
		*/
		
		/*
		时间O(n)   空间O(n)
		int[] newArray = new int[size];
		int j = 0;
		for(int i = 0; i < size; i++){
			if(array[i] != element){
				newArray[j++] = array[i];
			}
		}
		//最后剩下的数一共有j个
		//1.把数据搬回去 2.更新size
		for(int i = 0; i < j; j++){
			array[i] = newArray[i];
		}
		size = j;
		*/
		
		//时间O(n)   空间O(1)
		int j = 0;
		for(int i = 0; i < size; i++){
			if(array[i] != element){
				array[j++] = array[i];
			}
		}
		size = j;
	}
	
	//内部使用的方法
	//无论是否使用扩容,调用完这个方法,保证容量一定够用
	private void ensureCapacity(){
		if(size < array.length){
			//不需要扩容
			return;
		}
		//申请新房子
		int newCapacity = array.length + array.length / 2;
		int[] newArray = new int[newCapacity];
		//搬家
		for(int i = 0; i < array.length; i++){
			newArray[i] = array[i]; 
		}
		//发朋友圈
		this.array = newArray;
		//退老房子,利用java的垃圾回收,自动回收原来的数组
	}
	
	public static void test1(String[] args){
		SeqList seqList = new SeqList();
		//[]
		System.out.println(seqList.toString());
		
		//尾插1,2,3
		seqList.pushBack(1);
		seqList.pushBack(2);
		seqList.pushBack(3);
		//[1, 2, 3]
		System.out.println(seqList.toString());
		
		//头插
		seqList.pushFront(10);
		seqList.pushFront(20);
		seqList.pushFront(30);
		//[30, 20, 10, 1, 2, 3]
		System.out.println(seqList.toString());
		
		//中间插入
		seqList.insert(2,100);
		seqList.insert(4,200);
		//[30, 20, 100, 10, 200, 1, 2, 3]
		System.out.println(seqList.toString());
		
		System.out.printf("当前容量: %d%n",seqList.capacity());
		
		seqList.pushBack(1000);
		seqList.pushBack(2000);
		seqList.pushBack(3000);
		seqList.pushBack(4000);
		seqList.pushBack(5000);
		seqList.pushBack(6000);
		//[30, 20, 100, 10, 200, 1, 2, 3, 1000, 2000, 3000, 4000, 5000, 6000]
		System.out.println(seqList.toString());
		System.out.printf("当前容量: %d%n", seqList.capacity());

		//头删
		seqList.popFront();
		seqList.popFront();
		seqList.popFront();
		seqList.popFront();
		//[200, 1, 2, 3, 1000, 2000, 3000, 4000, 5000, 6000]
		System.out.println(seqList.toString());
		
		//尾删
		seqList.popBack();
		seqList.popBack();
		seqList.popBack();
		//[200, 1, 2, 3, 1000, 2000, 3000]
		System.out.println(seqList.toString());
		
		/*
		//中间删除
		seqList.erase(2);
		System.out.println(seqList.toString());
		
		//查找
		System.out.println(seqList.indexOf(200));
		
		//根据下标,获取元素
		System.out.println(seqList.get(2));
		
		//修改
		seqList.set(1,300);
		System.out.println(seqList.toString());
		*/
	}
	
	public static void test2(String[] args){
		SeqList s = new SeqList();
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		s.pushBack(1);
		s.pushBack(2);
		s.pushBack(3);
		s.pushBack(4);
		// [ 1, 2, 3, 4, 1, 2, 3, 4 ]
		System.out.println(s.toString());
		
		s.remove(2);
		// [ 1, 3, 4, 1, 2, 3, 4 ]
		System.out.println(s.toString());
		
		s.removeAll(4);
		// [ 1, 3, 1, 2, 3 ]
		System.out.println(s.toString());
	}
	
	public static void main(String[] args){
		test1(args);
		test2(args);
	}
}