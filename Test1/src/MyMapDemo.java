import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMapDemo {
    public static void main(String[] args) {
        // 姓名     电话
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("唐老师"));
        System.out.println(map.getOrDefault("唐老师", "秘密"));
        System.out.println(map.get("唐老师"));

        map.put("唐老师", "13912345678");
        map.put("徐老师", "13987654321");
        System.out.println("=======================");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("唐老师"));
        System.out.println(map.getOrDefault("唐老师", "秘密"));
        System.out.println(map.get("徐老师"));
        System.out.println("=======================");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.print(entry.getKey() + "=");
            System.out.println(entry.getValue());
        }
    }
}
