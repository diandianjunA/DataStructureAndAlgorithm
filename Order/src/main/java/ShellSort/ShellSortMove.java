package ShellSort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSortMove {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        sort(arr);
    }

    public static void sort(int[] array){
        //增量gap，并逐渐缩小增量
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素开始，逐个对其所在组直接进行插入排序
            for (int i = gap; i < array.length; i++) {
                int j=i;
                int temp=array[j];
                while(j-gap>=0&&temp<array[j-gap]){
                    //移动
                    array[j]=array[j-gap];
                    j=j-gap;
                }
                //当退出循环后，说明找到了插入的位置
                array[j]=temp;
            }
        }
    }
    @Test
    public void TimeTest(){
        int[] array=new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i]= (int) (Math.random()*800000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Date date1 = new Date();
        String format1 = simpleDateFormat.format(date1);
        System.out.println("排序前的时间："+format1);
        sort(array);
        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+format2);
    }
}
