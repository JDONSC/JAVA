public class Practice0514{
	public static long factorial1(int n){
		//终止条件
		//1!=1     0!=1
	    if(n == 1||n == 0){
		    return 1;
	    }
		//递推公式
		//n!==(n-1)!*n
		return factorial1(n-1)*n;
    }
	
	public static long factorial2(int n){
		//n!=1*2*3*....*n
		//一共循环n次
		long fact=1;
	    for(int i=1;i<=n;i++){
		    fact=fact*i;
	    }
		return fact;
    }
	
	
	/**
     * 利用公式
     * e = 1 + 1/1! + 1/2! + 1/3! + 1/4! + ...
     * 计算自然对数的底 e
     * @param n 一共需要计算 n 项
     * @return
     */
	public static double calcE(int n){
	    double e=0;
	    for(int i=0;i<n;i++){
		    e=e+((double)1/factorial1(i));  //强制转化(double)1
	    }
	    return e;
    }
	
	
	/**
     * 利用公式
     * e = 1 + 1/1! + 1/2! + 1/3! + 1/4! + ...
     * 计算自然对数的底 e
     * @param precision 最后一项的精度 <= precision
     * @return
     */
	public static double calcE(double precision){
		double e=0;
		int n=0;
		while(true){
			double item=1.0/factorial1(n++); 
			e+=item;
			if(item<precision){
				break;
			}
		}
		return e;
	}
	
	/**
     * 利用公式
     * Pi / 4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 - ...
     * 计算 pi 的值
     * @param n 一共计算 n 项
     * @return
     */
	public static double calcPi(int n){
		double Pi=0;
		for(int i=0;i<n;i++){
			if(i%2==0){
				//加
				Pi=Pi+(1.0/(2*i+1));
			}else{
				//减
				Pi=Pi-(1.0/(2*i+1));
			}
		}
		return 4*Pi;
	}
	
	public static String reverse(String s){
		int length=s.length();
		String r="";
		//0,1,2...length-1
		for(int i=length-1;i>=0;i--){
			char ch=s.charAt(i);
			r=r+ch;
		}
		return r;
	}
	
	/**
     * 10 进制转 16 进制，计算公式如下例
     * 1958 转 16 进制
     * 1958 % 16 == 6   1958 / 16 == 122
     * 122 % 16 == 10 也就是 A   122 / 16 == 7
     * 7 < 16
     * 1958 的 16 进制 为 7A6
     * @param n
     * @return
     */
	public static String decToHex(int dec){
		String hex="";
		while(dec >= 16){
			int remainder = dec % 16;
			dec = dec / 16;
			if(remainder < 10){
				hex += remainder;//字符串+int类型仍然是字符串
			}else{
				char ch=(char)('A' + (remainder - 10));
				hex += ch;
			}
		}
		if(dec != 0){
			hex += dec;
		}
		return reverse(hex);
	}
	
	public static void main(String[] args){
		int n=12;
		//求阶乘的方法
		//通过递归
		long fact1=factorial1(n);
		System.out.printf("阶乘是%d%n",fact1);
		//通过循环
		long fact2=factorial2(n);
		System.out.printf("阶乘是%d%n",fact2);
		
		//求e
		//计算多少项
		double e=calcE(10);
		System.out.printf("e=%f%n",e);
		//给定精度去求,要求最后一项的结果<精度
		e=calcE(1E-4);//e=clacE(0.0001);
		System.out.printf("e=%f%n",e);
		
		double Pi=calcPi(5000);
		System.out.printf("Pi=%f%n",Pi);
		
		//逆置字符串
		//结果应该是olleH
		System.out.println(reverse("Hello"));
		
		//10进制转化成16进制
		System.out.println(decToHex(21954));
	}
}