package QuickSort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

//    public static void sort(int[] arr,int left,int right){
//        if(left>=right){
//            return;
//        }
//        int l=left;//左下标
//        int r=right;//右下标
//        int pivot=arr[(left+right)/2];//中轴值
//        //while循环的目的是让比pivot值小的放到左边，比pivot大的放在右边
//        while(l<r){
//            //在pivot的左边一直找，找到大于等于pivot的值，才退出
//            while(arr[l]<pivot){
//                l++;
//            }
//            //在pivot的右边一直找，找到小于等于pivot的值时才退出
//            while(l<r&&arr[r]>pivot){
//                r--;
//            }
//            //如果l>=r，说明两指针已经相交，在pivot两边的数已经左边全小于等于pivot，右边全大于等于pivot
//            if(l>=r){
//                break;
//            }
//            //否则说明左边还有比pivot小的数，右边还有比pivot大的数
//            int temp=arr[l];
//            arr[l]=arr[r];
//            arr[r]=temp;
//            //如果交换完后，发现这个arr[l]==pivot
//            if(arr[l]==pivot){
//                r--;
//            }
//            //如果交换完后，发现这个arr[r]==pivot
//            if(arr[r]==pivot){
//                l++;
//            }
//        }
//        sort(arr,left,l-1);
//        sort(arr,r+1,right);
//    }
    public static void sort(int[] arr,int start,int end){
        if(start<end){
            int q=partition(arr,start,end);
            sort(arr,start,q-1);
            sort(arr,q+1,end);
        }
    }
    public static int partition(int[] arr,int start,int end){
        int x=arr[end];//选择一个元素作为基准
        int i=start-1;
        for (int j = start; j < end ; j++) {
            if(arr[j]<=x){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,end);
        return i+1;
    }
    public static void swap(int[] arr,int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
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
