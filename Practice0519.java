import java.util.Arrays;

public class Practice0519{
	public static int max(int[] array){
		int maxValue = Integer.MIN_VALUE;
		for(int item : array){
			if(item > maxValue){
				maxValue = item;
			}
		}
		return maxValue;
	}
	
	public static int indexOf(int[] array, int key){
		for(int i = 0; i < array.length; i++){
			if(array[i] == key){
				return i;
			}
		}
		return -1;
	}
	
	//去掉一个最高分,去掉一个最低分后的平均分
	public static double average(int[] scores){
		int maxScore = scores[0] ;
		int minScore = scores[0];
		int sumScore = scores[0];
        for(int i = 1; i < scores.length; i++){
			if(scores[i] > maxScore){
				maxScore = scores[i];
			}else if(scores[i] < minScore){
				minScore = scores[i];
			}
			sumScore += scores[i];
		}
		System.out.println(sumScore);
		System.out.println(maxScore);
		System.out.println(minScore);
		return (double)(sumScore - maxScore - minScore) / (scores.length - 2);
	}	
	
	public static int[] copyOf(int[] src, int newLength){ 
		//newLength可能大于src.length
		//newLength可能小于等于src.length
		int[] dest = new int[newLength];
		//利用默认值的特性,每个元素都是0
		int minLength = src.length < newLength ? src.length : newLength;
        for(int i = 0; i < minLength; i++){
			dest[i] = src[i];
		}
		return dest;
	}
	
	public static int binarySearch(int[] array, int key){
		int left = 0;
		int right = array.length - 1;
		//[left,right]区间内还有数
		while(left < right){
			//计算中间位置的下标
			int mid = left + (right - left) / 2;    //int mid = (left + rigtht) / 2;
			//比较
			if(key == array[mid]){
				return mid;
			}else if(key < array[mid]){
				right = mid;
			}else{
				left = mid + 1;
			}
		}
		return -1;
	}
	
	//交换array数组的i和j下标位置的数
	//因为修改array[i]对应的修改就是引用共同指向的数据,所以修改是可以生效的
	public static void swap(int[] array, int i, int j){
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
	//**冒泡排序
	public static void bubbleSort(int[] array){
		//减治算法
		for(int i = 0; i < array.length; i++){
			//需要经过array.length次冒泡
			//在无序区间内,经过两两比较,把最大的数冒泡至最后
			
			boolean isSwapped = false;
			
			//无序: [0, array.length - i)
			//有序: [array.length - i, array.length)
			//进行冒泡过程,遍历整个无序区间
			for(int j = 0; j < array.length - i - 1; j++){
				//冒泡的过程中,保证大的数在后面
				if(array[j] > array[j + 1]){
					swap(array, j, j + 1);
					isSwapped = true;
				}
			}
			//如果一次完整的冒泡过程中,一次交换都没有发生,表明数组已经有序,所以排序完成
			if(!isSwapped){
				return;
			}
		}
	}
	
	public static void main(String[] args){
		//初始化一个数组
		int[] array = new int[]{12,34,53,23,45,24,75,64,31,67,32,97,66,24};
		
		int maxValue = max(array);
		System.out.println("最大值是 " + maxValue);
		
		int index = indexOf(array, 67);
		System.out.println("67的下标是 " + index);
		
		double averageScore = average(array);
		System.out.printf("平均分是%.4f%n", averageScore);
		
		System.out.println(Arrays.toString(copyOf(array,3)));
		System.out.println(Arrays.toString(copyOf(array,23)));
		
		int index2 = binarySearch(array, 75);
		System.out.printf("75所在的下标是 %d%n", index2);
		
		int[] randomArray = new int[] { 9, 5, 7, 8, 3, 4, 6, 2, 1, 5, 4 };
		bubbleSort(randomArray);
		System.out.println(Arrays.toString(randomArray));
	}
}