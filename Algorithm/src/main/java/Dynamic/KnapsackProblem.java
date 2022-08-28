package Dynamic;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w={0,1,4,3};
        int[] val={0,1500,3000,2000};
        int n=val.length;//物品个数
        int m=4;//背包容量
        //用于记录背包内的最大价值
        int[][] v=new int[n][m+1];//表格纵坐标。0磅，1磅，2,磅，3磅，4磅，所以需要申请5个，也就是m+1个
        int[][] path=new int[n][m+1];//用于记录物品放入情况
        //初始化第0行和第0列
        for (int i = 0; i < v.length; i++) {
            v[i][0]=0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i]=0;
        }
        //动态规划处理
        for (int i = 1; i < v.length; i++) {//不处理第0行，第0行认为是没有商品，全0
            for (int j = 1; j < v[i].length; j++) {//不处理第0列，第0列认为重量为0磅，自然也没有商品，价值为0
                if (w[i]>j){
                    v[i][j]=v[i-1][j];
                }else{
//                    v[i][j]=Math.max(v[i-1][j],val[i]+v[i-1][j-w[i]]);
                    if(v[i-1][j]>val[i]+v[i-1][j-w[i]]){
                        v[i][j]=v[i-1][j];
                    }else{
                        v[i][j]=val[i]+v[i-1][j-w[i]];
                        path[i][j]=1;
                    }
                }
            }
        }
        for (int[] arr:v) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("=============");
        //这会输出所有的放入情况，但其实只需要最后的放入情况
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if(path[i][j]==1){
//                    System.out.printf("第%d个商品放入背包中\n",i);
//                }
//            }
//        }
        int i= path.length-1;//行的最大下标
        int j= path[0].length-1;//列的最大下标
        while (i>=0&&j>=0){
            if (path[i][j]==1){
                System.out.printf("第%d个商品放入背包\n",i);
                j-=w[i];//从后往前遍历，发现某个商品放入后，直接跳到减去某个商品后的重量的位置，能直接得到剩下的商品的放入策略
            }
            i--;//由于一个商品只能放一次，所以i--
        }
    }
}
