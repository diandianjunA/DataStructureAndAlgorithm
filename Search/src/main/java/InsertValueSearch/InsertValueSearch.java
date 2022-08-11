package InsertValueSearch;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i]=i+1;
        }
        int search = search(arr, 0, arr.length - 1, 77);
        System.out.println(search);
    }
    //编写插值查找算法
    public static int search(int[] arr,int left,int right,int findValue){
        System.out.println("查找次数");
        //findValue这步比较必须需要，否则mid算出来可能越界
        if(left>right||findValue<arr[0]||findValue>arr[arr.length-1]){
            return -1;
        }
        //求出mid
        int mid=left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
        int midValue=arr[mid];
        if(findValue>midValue){
            //向右递归
            return search(arr,mid+1,right,findValue);
        } else if (findValue < midValue) {
            return search(arr,left,mid-1,findValue);
        }else{
            return mid;
        }
    }
}
