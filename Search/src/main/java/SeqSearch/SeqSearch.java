package SeqSearch;

public class SeqSearch {
    public static void main(String[] args) {
        int arr[]={1,9,11,-1,34,89};
        int i = seqSearch(arr, -11);
        if (i==-1){
            System.out.println("未查找到");
        }else{
            System.out.println("下标为"+i);
        }
    }

    /**
     * 找到一个满足条件的就返回
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
