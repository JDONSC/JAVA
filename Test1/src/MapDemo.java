import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        //返回键值对的数量
        System.out.println(map.size());

        //判断是否为空
        System.out.println(map.isEmpty());

        //根据指定的 查找对应的
        System.out.println(map.get("作者"));

        //根据指定的 查找对应的，没有找到用默认值 代替
        System.out.println(map.getOrDefault("作者", "佚名"));

        //判断是否包含 key
        System.out.println(map.containsKey("作者"));

        //判断是否包含 value
        System.out.println(map.containsValue("佚名"));

        //将指定的 内容 放入 Map
        map.put("作者", "鲁迅");
        map.put("标题", "狂人日记");
        map.put("发表时间", "1918年");

        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("作者"));
        System.out.println(map.getOrDefault("作者", "佚名"));
        System.out.println(map.containsKey("作者"));
        System.out.println(map.containsValue("佚名"));

        //将所有键值对返回
        for(Map.Entry<String, String>entry : map.entrySet()){
            System.out.print(entry.getKey() + ":");
            System.out.println(entry.getValue());
        }
    }
}