package exam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 120. Triangle
 * @Author zyj
 * @Date 2019/1/18 10:53
 **/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                //获取当前数字
                int self = triangle.get(i).get(j);
                //得到下一行中较小的数字 与之相加
                int res = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+ self;
                //更新结果
                triangle.get(i).set(j,res);
            }
        }
        return triangle.get(0).get(0);
    }

    @Test
    public void test(){
        List<List<Integer>> data = new ArrayList<>();
        Integer[] data1 = {2};
        Integer[] data2 = {3, 4};
        Integer[] data3 = {6, 5, 7};
        Integer[] data4 = {4, 1, 8, 3};
        data.add(Arrays.asList(data1));
        data.add(Arrays.asList(data2));
        data.add(Arrays.asList(data3));
        data.add(Arrays.asList(data4));
        System.out.print(minimumTotal(data));
    }

}
