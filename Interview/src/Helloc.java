class Helloa {
    //构造方法
    public Helloa(){
        System.out.println("1Hello A!父类构造方法");
    }
    //非静态代码块
    {
        System.out.println("2i'm A class.父类非静态代码块");
    }
    //静态代码块
    static{
        System.out.println("3static A 父类静态代码块");
    }
}

class Hellob extends Helloa {
    //构造方法
    public Hellob(){
        System.out.println("4Hello B! 构造方法");
    }
    //非静态代码块
    {
        System.out.println("5i'm B class.非静态代码块");
    }
    //静态代码块
    static{
        System.out.println("6static B 静态代码块");
    }
}

public class Helloc {
    public static void main(String[] args) {
        System.out.println("7---start---");
        new Hellob();
        new Hellob();
        System.out.println("8---end---");
    }
}