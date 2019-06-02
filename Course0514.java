public class Course0514{
	public static void printIsGreatThan10(int n){
		if(n>10){
			//回车用%n不要直接用\n
			System.out.printf("%d 是大于10的%n",n);
		}
	}
	
	//switch支持String类型
	public static void printColour(String colour){
		switch(colour){
			case "Red":
			    System.out.println("红色");
				break;
			case "Yellow":
			    System.out.println("黄色");
				break;
			default:
			    System.out.println("不知道是什么颜色!");
		}
	}
	
	public static void foreach(int[] array){
		for(int item : array){
			System.out.println(item);
		}
	}
	
	public static void displayMutipyCation(){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=i;j++){
				System.out.printf("%d * %d = %d  ",j,i,i*j);
			}
			System.out.println();
		}
	}
	public static void find(){
		int[] array={1,2,3,4,5,6,7};
		for(int i=0;i<array.length;i++){
			if(array[i]==3){
				break;
			}
		}
		int[][] twoArray={
			{1,2,3},
			{4,5,6},
			{7,8,9},
		};
		//认识即可
		found:
		    for(int i = 0;i < 3; i++){
				for(int j = 0;j < 3; j++){
					if(twoArray[i][j] == 5){
						break found;     //找到found跳出
						//continue found;
					}
				}
			}
	}
	
	//n是盘子数
	//src是源柱子编号
	//dest是目标柱子的编号
	//柱子0 1 2
	public static void hannoi(int n,int src,int dest){
		if(n==1){
			System.out.printf("从%d移到%d%n",src,dest);
		}else{
			int other = 3 - src - dest;
			hannoi(n - 1, src, other);
			System.out.printf("从%d移到%d%n",src,dest);
			hannoi(n - 1, other, dest);
		}
	}
	
	/**
	 * 计算 n 的位数，n 一定是一个正数
	 */
	public static int calcDigitNum(long n){
        int digitNum=0;
	    while(n>0){
		    n=n/10;
		    digitNum++;
	    }
		return digitNum;
    }
	
	public static void main(String[] args){

		printIsGreatThan10(100);
		printIsGreatThan10(9);
		
		//printColour(args[0]);
		
		foreach(new int[] {1,3,5,6,7});
		
		displayMutipyCation();
		
		hannoi(3,0,2);
		
		//把String类型的数字找出来
		long n = Long.parseLong(args[0]);
        System.out.printf("%d一共有%d位%n",n,calcDigitNum(n));
	}
}
