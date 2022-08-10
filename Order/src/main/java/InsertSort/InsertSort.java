package InsertSort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        int[] arrays = {101, 34, 119, 1,-1,89};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));;
    }
    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int insertVal=array[i];
            int insertIndex=i-1;//给当前这个数找插入的位置，先假定就是它前面的那个
            while(insertIndex>=0&&insertVal<array[insertIndex]){//说明待插入数还没找到该插入的位置
                //就需要将array[insertIndex]后移，让出位置
                array[insertIndex+1]=array[insertIndex];
                insertIndex--;
            }
            //当退出循环时，找到插入位置，位置为insertIndex+1
            array[insertIndex+1]=insertVal;
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
