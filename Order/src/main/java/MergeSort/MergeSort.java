package MergeSort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 合并
     * @param arr:原始数组
     * @param left:有序数列的左边索引
     * @param mid:中间索引
     * @param right：右边索引
     */
    public static void merge(int[] arr,int left,int mid,int right){
        int[] leftArr = new int[mid - left+1+1];//用于存放左边的数组
        int[] rightArr=new int[right-mid+1];//用于存放右边的数组
        for (int i = 0; i < leftArr.length-1; i++) {
            leftArr[i]=arr[i+left];
        }
        leftArr[leftArr.length-1]=Integer.MAX_VALUE;//多设一个元素，设置最后一个元素为无穷大，以便于后续的代码中无需判断左右两边哪边有剩余
        for (int i = 0; i < rightArr.length-1; i++) {
            rightArr[i]=arr[mid+1+i];
        }
        rightArr[rightArr.length-1]=Integer.MAX_VALUE;//同上
        int i = 0,j=0;
        for (int k = left; k <= right; k++) {//哪边的数小就先放进数组中
            if(leftArr[i]<=rightArr[j]){
                //由于这两个数组最后一个数都是无穷大，所以通过这种方式
                //当一个数组掏空之后，可以自发的将另一个数组的全部数字都按顺序放回数组中
                arr[k]=leftArr[i];
                i++;
            }else{
                arr[k]=rightArr[j];
                j++;
            }
        }

    }
    public static void sort(int[] arr,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            sort(arr,left,mid);
            sort(arr,mid+1,right);
            merge(arr,left,mid,right);
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
        sort(array,0,array.length-1);
        Date date2 = new Date();
        String format2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+format2);
    }
}
