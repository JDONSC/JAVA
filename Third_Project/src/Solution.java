import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate0(int numRows){
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> nums = new ArrayList<>();
            nums.add(1);
            for(int j = 0; j <= i - 2; j++){
                List<Integer> preNums = list.get(i - 1);
                int p = preNums.get(j);
                int q = preNums.get(j + 1);
                int n = p + q;

                nums.add(n);
            }
            if(i != 0){
                nums.add(1);
            }
            list.add(nums);
        }

        return list;
    }

    public List<List<Integer>> generate(int numRows){

        //List list = new ArrayList();
        //List<Integer>
        //list是一种引用,List类型的接口引用(java语法)
        //list逻辑上是一种线性表
        //线性表的元素类型是List<Integer>
        //       (java语法) List类型的接口引用
        //                  元素类型是Integer类类型的引用
        //                  Integer是int的包装类
        List<List<Integer>> list = new ArrayList<>(numRows);

        if(numRows == 0){
            return list;
        }

        for(int i = 0; i < numRows; i++){
            list.add(new ArrayList<>(i + 1));
        }

        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for(int i = 2; i < numRows; i++){
            List<Integer> nums = list.get(i);
            nums.add(1);
            for(int j = 1; j < i; j++){
                int num = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
                nums.add(num);
            }
            nums.add(1);
        }

        return list;
    }

    /**
    public List<List<Integer>> generate1(int numRows){
        List<List<Integer>> list;
        list = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= numRows; i++){
            for(int j = 0; j < i; j++){
                list.get(i).add(1);
            }
        }
    }
     */

    private static void printPascalsTriangle(Solution s, int n){
        System.out.println(s.generate0(n));
        System.out.println(s.generate(n));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printPascalsTriangle(solution,5);
    }
}
