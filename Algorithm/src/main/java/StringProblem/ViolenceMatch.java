package StringProblem;

public class ViolenceMatch {
    public static void main(String[] args) {
        String s1="Hello, Hello, I am Alice,Do you like java?";
        String s2="Alice";
        System.out.println(violenceMatch(s1,s2));
    }
    public static int violenceMatch(String str1,String str2){
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        int s1len=s1.length;
        int s2len=s2.length;
        int i=0;//指向s1的索引
        int j=0;//指向s2的索引
        while(i<s1len&&j<s2len){
            if(s1[i]==s2[j]){
                //匹配ol，继续匹配
                i++;
                j++;
            }else{
                //没匹配到,到最开始匹配到的位置的下一个字符开始重新匹配
                i=i-j+1;
                j=0;
            }
        }
        if(j==s2len){
            return i-j;
        }else{
            return -1;
        }
    }
}
