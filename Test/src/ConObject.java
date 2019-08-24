class Parent1{
    {
        System.out.println("A");
    }
    Parent1(){
        System.out.println("B");
    }
    {
        System.out.println("C");
    }
}
public class ConObject extends Parent1{
    ConObject(){
        super();
        System.out.println(1);
    }

    ConObject(int v){
        this();
        System.out.println(2);
    }

    private int initA(){
        System.out.println(3);
        return 0;
    }

    private int initB(){
        System.out.println(4);
        return 0;
    }

    int a = initA();

    {
        System.out.println(5);
    }

    int b = initB();

    {
        System.out.println(6);
    }

    public static void main(String[] args){
        new ConObject(1000);
    }
}