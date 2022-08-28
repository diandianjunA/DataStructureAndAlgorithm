package BinarySearch;

import org.junit.Test;

public class BinarySearchDemo {
    @Test
    public void Test1(){
        int[] arr={1,3,8,10,11,67,100};
        int i = binarySearch(arr, -8);
        System.out.println(i);
    }

    /**
     * 二分查找的非递归实现
     * @param arr 待查找的数组，升序排列
     * @param target 目标值
     * @return 对应下标，-1表示未找到
     */
    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]>target) {
                right=mid-1;//向左查找
            }else {
                left=mid+1;//向右查找
            }
        }
        return -1;
    }
}
