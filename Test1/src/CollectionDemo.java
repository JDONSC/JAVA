import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();

        //返回集合中的元素个数
        System.out.println(list.size());

        //判断集合是否没有任何元素，俗称空集合
        System.out.println(list.isEmpty());

        //将元素放入集合中
        list.add("我");
        list.add("爱");
        list.add("Java");

        System.out.println(list.size());
        System.out.println(list.isEmpty());

        //返回一个装有所有集合中元素的数组
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));

        for(String s : list){
            System.out.println(s);
        }

        //如果元素出现在集合中，删除其中一个
        list.remove("爱");
        for(String s : list){
            System.out.println(s);
        }

        //删除集合中的所有元素
        list.clear();

        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
