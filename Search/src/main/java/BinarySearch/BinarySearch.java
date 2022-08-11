package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1234};
        int i = binarySearch(arr, 0, arr.length - 1, 88);
        System.out.println(i);
    }

    /**
     * 二分查找算法
     * @param arr:查找数组
     * @param left:数组最左侧下标
     * @param right:数组最右侧下标
     * @param findValue:要找的值
     * @return 如果找到，返回下标，如果没找到，返回-1
     */
    public static int binarySearch(int[] arr,int left,int right,int findValue){
        if(left>right){
            return -1;
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
            return mid;
        }
    }
}
