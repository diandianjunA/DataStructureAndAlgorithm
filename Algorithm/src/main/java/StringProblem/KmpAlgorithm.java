package StringProblem;

import java.util.Arrays;

public class KmpAlgorithm {
    public static void main(String[] args) {
        String str1="BBC ABCDAB ABCDABCDABDE";
        String str2="ABCDABD";
        System.out.println(kmpSearch(str1,str2));
    }
    //获取子串的部分匹配值
    public static int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0]=0;
        for (int i = 1, j=0; i < dest.length(); i++) {
            while(j>0&&dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];//已经匹配到了j个数，所以从第j+1个数开始重新匹配
            }
            if(dest.charAt(i)==dest.charAt(j)){
                j++;//部分匹配值加1
            }
            next[i]=j;
        }
        return next;
    }
    //KMP算法
    public static int kmpSearch(String str1,String str2){
        int[] next = kmpNext(str2);
        for (int i = 0,j=0; i < str1.length(); i++) {
            while(j>0&&str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }
}
