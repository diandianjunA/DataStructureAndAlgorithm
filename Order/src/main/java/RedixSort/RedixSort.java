package RedixSort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RedixSort {
    public static void main(String[] args) {
        int[] arr={53,3,542,748,14,214};
        sort(arr);
    }
    //基数排序方法
    public static void sort(int[] arr){
        //先得到数组中最大的位数
        int max=arr[0];//假设第一个数就是最大的数
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //得到最大数的位数
        int maxlength=(max+"").length();
        //定义一个二维数组，每个桶是一个一维数组
        //为防止放入数时数据溢出，每个一维数组（桶）的大小定为arr.length
        //基数排序是空间换时间的经典算法
        int[][] buckets = new int[10][arr.length];
        //为了记录每个桶实际存放了多少数据，再定义一个一维数组来记录各个桶每次放入数据的个数
        int[] bucketElementCount = new int[10];
        //循环执行，比较每一位数
        for (int k = 0,n=1; k < maxlength; k++,n*=10) {
            for (int i = 0; i < arr.length; i++) {
                //取出每个元素的第k位
                int digitOfElement=arr[i]/n%10;
                //放入到对应的桶中
                buckets[digitOfElement][bucketElementCount[digitOfElement]++]=arr[i];
            }
            int index=0;//放入arr的指针
            for (int i = 0; i < buckets.length; i++) {
                //如果桶中有数据，我们才放到原数组中
                if(bucketElementCount[i]!=0){
                    //循环第k个桶，放入
                    for (int j = 0; j < bucketElementCount[i]; j++) {
                        //取出元素，放入arr
                        arr[index++]=buckets[i][j];
                    }
                }
                //每轮处理后，要将bucketElementCount置为零
                bucketElementCount[i]=0;
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
