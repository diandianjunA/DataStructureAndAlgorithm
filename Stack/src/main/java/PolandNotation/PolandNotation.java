package PolandNotation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> listString = getListString(suffixExpression);
        System.out.println(listString);
        int calculate = calculate(listString);
        System.out.println(calculate);
    }

    //将逆波兰表达式的元素分割，放在一个ArrayList里面
    public static List<String> getListString(String expression) {
        String[] s = expression.split(" ");
        ArrayList<String> strings = new ArrayList<>();
        for (String string : s) {
            strings.add(string);
        }
        return strings;
    }

    //完成逆波兰表达式的运算
    public static int calculate(List<String> list) {
        //创建一个栈
        Stack<String> stack = new Stack<String>();
        for (String item : list) {
            //使用正则表达式来取出数字
            if (item.matches("\\d+")) {//正则表达式，表示匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数来运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                switch (item) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("输入运算符有误");
                }
                stack.push(String.valueOf(result));
            }
        }
        //最终留在stack中的数就是结果
        return Integer.parseInt(stack.pop());
    }
    //将中缀表达式转为List
    public static List<String> getExpressionList(String s){
        ArrayList<String> strings = new ArrayList<>();
        int i=0;//用于遍历中缀表达式
        String str = "";//对多位数进行拼接
        char c;//遍历得到的字符放入c中
        do{
            c=s.charAt(i);
           //如果c不是数字，就加入到ls中
            if(c<48||c>57){
                strings.add(c+"");
                i++;//指针后移
            }else{
                //是一个数字，需要考虑多位数,用str来拼接
                str+=c;
                if(i==s.length()-1){
                    strings.add(str);
                }else{
                    if(s.charAt(i+1)<48||s.charAt(i+1)>57){
                        strings.add(str);
                        str="";
                    }
                }
                i++;
            }
        }while(i<s.length());
        return strings;
    }
    public static List<String> getSuffixExpression(List<String> list){
        //定义两个栈
        Stack<String> operationStack = new Stack<>();
        //因为第二个栈在整个过程中没有pop操作，最后还还要逆序输出，因此直接用一个集合来装就好
        ArrayList<String> temp = new ArrayList<>();
        for (String s:list) {
            //如果是数字，就入temp栈
            if(s.matches("\\d+")){
                temp.add(s);
            }else if(s.equals("(")){//如果是左括号，入operation栈
                operationStack.push(s);
            }else if(s.equals(")")){
                while (!operationStack.peek().equals("(")){
                    String pop = operationStack.pop();
                    temp.add(pop);
                }
                operationStack.pop();//消掉了一对括号
            }else{
                while(operationStack.size()!=0&&Operation.getValue(operationStack.peek())>=Operation.getValue(s)){
                    temp.add(operationStack.pop());
                }
                operationStack.push(s);
            }
        }
        while(!operationStack.isEmpty()){
            temp.add(operationStack.pop());
        }
        return temp;
    }
    @Test
    public void ExpressionTransformTest(){
        String expression="1+((2+3)*4)-5";
        List<String> expressionList = getExpressionList(expression);
        List<String> suffixExpression = getSuffixExpression(expressionList);
        int calculate = calculate(suffixExpression);
        System.out.println(calculate);
    }
}
class Operation{
    private final static int ADD=1;
    private final static int SUB=1;
    private final static int MUL=2;
    private final static int DIV=2;

    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            case "(":
                break;
            default:
                System.out.println("运算符输入有误");
        }
        return result;
    }
}