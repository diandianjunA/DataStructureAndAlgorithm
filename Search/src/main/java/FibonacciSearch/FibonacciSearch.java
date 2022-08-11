package FibonacciSearch;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize=20;
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1234};
        System.out.println(search(arr,1000));
    }
    //斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i < maxSize; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    //斐波那契查找算法(非递归)
    public static int search(int[] a,int key){
        int low=0;
        int high=a.length-1;
        int k=0;//表示斐波那契分割数值的下标
        int mid=0;//存放mid值
        int f[]=fib();
        //获取斐波那契下标
        while(a.length>f[k]-1){
            k++;
        }
        //因为f[k]-1值可能大于a的长度，因此我们需要构造一个新的数组，并将a中的元素填充进去，剩余元素用最后一个元素来补，使数组长度恰好为f[k]-1
        int[] temp =Arrays.copyOf(a, f[k] - 1);//将a的元素copy到temp中，长度为f[k]-1，不足的位子补0
        for (int i = high+1; i < temp.length; i++) {
            temp[i]=a[high];
        }
        //使用while循环处理，找到key
        while(low<=high){
            mid=low+f[k-1]-1;
            if(key<temp[mid]){
                //向前查找
                high=mid-1;
                //总元素等于f[k]-1=high(初始)-low+1,前面总元素为high-low+1=mid-low=f[k-1]-1,所以向前查找的话，直接k--
                k--;
            }else if(key>temp[mid]){
                //向后查找
                low=mid+1;
                //同上，总元素等于f[k]-1=high-low(初始)+1，后面总元素high-low+1=high-mid=high-low(初始)+1-f[k-1]=f[k-2]-1,所以k-=2即可
                k-=2;
            }else{
                //防止mid找到的是扩充部分的元素，保证mid找到的一定是a数组内的数和下标
                if(mid>=a.length-1){
                    return a.length-1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }
}
