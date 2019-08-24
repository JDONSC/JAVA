import java.util.Iterator;

class A implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator(){
        return null;
    }
}

public class ForeachDemo {
    public static void main(String[] args) {
        A a = new A();
        for (int i : a) {
        }
    }
}
