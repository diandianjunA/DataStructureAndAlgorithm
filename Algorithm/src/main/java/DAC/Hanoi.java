package DAC;

import org.junit.Test;

public class Hanoi {
    @Test
    public void Test1(){
        hanoi(5,'A','B','C');
    }

    /**
     * 汉诺塔求解
     * @param num 盘子总数
     * @param a 从哪个位置开始
     * @param b 借助哪个盘子
     * @param c 移动到哪个盘子
     */
    public static void hanoi(int num,char a,char b,char c){
        if(num==1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else{
            hanoi(num-1,a,c,b);
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            hanoi(num-1,b,a,c);
        }
    }
}
