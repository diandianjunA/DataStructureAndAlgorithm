package Queen8;

public class Queen8 {
    //定义一个max表示有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果，比如arr={0,4,7,5,2,6,1,3}
    int[] array = new int[max];
    int answer=0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(queen8.answer);
    }

    //将皇后摆放位置输出
    private void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    //放置第n个皇后时，检测是否冲突
    /**
     *
     * @param n:表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //array[i]==array[n],表示判断第n个皇后和第i个皇后是否在同一列
            //Math.abs(n-i)==Math.abs(array[n]-array[i]),表示判断第n个皇后和第i个皇后是否在同一斜线
            // （由于棋盘的形状问题，处于同一斜线的话，两皇后坐标连线的斜率必为45度）
            //不可能放在同一行
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    //放置第n个皇后
    public void check(int n){
        if(n==max){
            answer++;
            print();
            return;
        }
        //从第1列开始放置这个皇后
        for (int i = 0; i < max; i++) {
            //放置
            array[n]=i;
            //判断是否冲突
            if(judge(n)){
                //不冲突，就继续放下一行的皇后
                check(n+1);
            }
            //冲突了，或者回溯回来了，就继续循环，继续将这个皇后往下一列放
        }
    }
}
