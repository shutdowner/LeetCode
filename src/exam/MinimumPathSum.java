package exam;

import org.junit.Test;

/**
 * @Description
 * @Author zyj
 * @Date 2019/1/18 9:40
 **/
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        //行
        int m = grid.length;
        //列
        int n = grid[0].length;

        int[][] result = new int[m][n];
        //初始化第一个位置的结果为grid[0][0]
        result[0][0] = grid[0][0];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i+j==0){
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i-1>=0){
                    up = result[i-1][j];
                }
                if(j-1>=0){
                    left = result[i][j-1];
                }

                result[i][j] = grid[i][j]+ Math.min(up, left);
            }
        }
        return result[m-1][n-1];
    }
    @Test
    public void test(){
        int[][] data = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.print(minPathSum(data));
    }
}
