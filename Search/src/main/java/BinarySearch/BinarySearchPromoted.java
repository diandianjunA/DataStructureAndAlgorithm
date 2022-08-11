package BinarySearch;

import java.util.ArrayList;

public class BinarySearchPromoted {
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1234};
        ArrayList<Integer> integers = binarySearch(arr, 0, arr.length - 1, 1001);
        System.out.println(integers);
    }
    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int findValue){
        if(left>right){
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        int midValue=arr[mid];
        if(findValue>midValue){
            //向右递归
            return binarySearch(arr,mid+1,right,findValue);
        } else if (findValue < midValue) {
            //向左递归
            return binarySearch(arr,left,mid-1,findValue);
        }else{
            ArrayList<Integer> integers = new ArrayList<>();
            //分别向左向右扫描
            int temp=mid-1;
            while(temp>=0&&arr[temp]==findValue){
                integers.add(temp);
                temp--;
            }
            integers.add(mid);
            temp=mid+1;
            while(temp<arr.length&&arr[temp]==findValue){
                integers.add(temp);
                temp++;
            }
            return integers;
        }
    }
}
