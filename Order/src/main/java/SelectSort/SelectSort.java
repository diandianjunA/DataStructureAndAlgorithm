package SelectSort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {
    //选择排序
    public static void sort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int k=i;//用于记录最小值的下标，先假定第一个数为最小的
            for (int j = i+1; j <array.length; j++) {
                if(array[j]<array[k]){//如果发现更小的数，就记住这个下标
                    k=j;
                }
            }
            //将最小的数交换到第一个数的位置
            int temp=array[k];
            array[k]=array[i];
            array[i]=temp;
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
