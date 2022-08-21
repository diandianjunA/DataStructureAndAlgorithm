package HeapSort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSortDemo {
    public static void main(String[] args) {
        //升序排列
        int[] arr={4,6,8,5,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int temp=0;
        //将待排序的序列构造成一个大顶堆
        for (int i = arr.length/2-1; i >=0; i--) {
            adjust(arr,i, arr.length);
        }
        //将其与末尾元素进行交换，此时末尾就是最大元素
        for (int i = arr.length-1; i >0; i--) {
            temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            adjust(arr,0, i);//因为以下的节点已经是大顶堆了，所以只需要从0开始调整
        }
    }

    /**
     * 将以i为根节点的树调整成大顶堆
     * @param arr:要调整的数组
     * @param i:非叶子节点的索引
     * @param length:数组中要调整序列的长度
     */
    public static void adjust(int arr[],int i,int length){
        int temp=arr[i];
        //j是i的左子节点,循环结束后j变成你呢j的左子节点
        for (int j = 2*i+1; j <length; j=2*j+1) {
            if(j+1<length&&arr[j]<arr[j+1]){//找到左子节点和右子节点中最大的那一个
                j++;
            }
            if(arr[j]>temp){//跟中间节点比较如果下面更大就换上去
                arr[i]=arr[j];
                i=j;
            }else{
                break;
            }
        }
        //for循环结束后，以i为根节点的数已经是一个大顶堆了
        arr[i]=temp;//i此时指向最底端被换掉的一个节点，所以将temp移到这来
    }
    @Test
    public void TimeTest(){
        int[] array=new int[80000];
        for (int i = 0; i < 80000; i++) {
            array[i]= (int) (Math.random()*80000);
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
