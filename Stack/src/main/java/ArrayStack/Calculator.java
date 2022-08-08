package ArrayStack;

public class Calculator {
    public static void main(String[] args) {
        String expression="9-7*1+2";//7-7*2*2-4/2*3+4+2*3
        //创建两个栈，一个数栈，一个符号栈
        ArrayStack<Integer> numberStack = new ArrayStack<Integer>(10);
        ArrayStack<Character> operStack = new ArrayStack<Character>(20);
        //定义一个用于扫描表达式的变量
        int index=0;
        //其他暂存结果的变量
        int num1=0;
        int num2=0;
        char oper=0;
        int result=0;
        char ch=' ';//用于存放每次扫描所得的char
        String keepNum="";//用于多位数拼接
        //开始循环扫描
        while(true){
            //依次得到每一个字符
            ch = expression.charAt(index);
            //判断ch是什么，做相应处理
            if(operStack.isOper(ch)){
                //判断当前的符号栈是否为空
                if(!operStack.isEmpty()){
                    //不为空，比较优先级，如果优先级小于栈顶的运算符，则将栈顶的运算符弹出进行运算
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        //计算时，要一直计算，直到栈顶运算符的优先级小于当前的运算符为止
                        //即符号栈里，高位的运算符优先级必须高于低位的运算符
                        //否则需要一直运算直到为空或者即将压入栈的运算符优先级高于栈顶为止
                       while(!operStack.isEmpty()&&operStack.priority(operStack.peek())>=operStack.priority(ch)){
                           num1=numberStack.pop();
                           num2=numberStack.pop();
                           oper=operStack.pop();
                           result=numberStack.cal(num1,num2,oper);
                           numberStack.push(result);
                       }
                        operStack.push(ch);
                    }else{
                        operStack.push(ch);
                    }
                }else {
                    //为空直接入栈
                    operStack.push(ch);
                }
            }else{
                //如果是数，要判断是否是多位数
                keepNum+=ch;
                //如果是最后一位数，则不能查看下一位数，直接提交所有拼接的数字
                if(index==expression.length()-1){
                    numberStack.push(Integer.parseInt(keepNum));
                }else{
                    //不是最后一位数，判断下一位是不是运算符，如果是，那么直接提交，并将keepNum清空，以存储下一个多位数
                    if(operStack.isOper(expression.charAt(index+1))){
                        numberStack.push(Integer.parseInt(keepNum));
                        keepNum="";
                    }
                    //下一位不是运算符，那么不提交，等下一个循环再来拼接下一个数，直到拼到下一位为运算符，说明拼完了，才可以提交了
                }
            }
            index++;
            //判断是否扫描到expression的最后
            if(index>=expression.length()){
                break;
            }
        }
        //扫描完毕，将数栈和符号栈依次弹出运算
        while (true){
            //如果符号栈为空，则计算结束，数栈只剩一个数，即结果
            if(operStack.isEmpty()){
                break;
            }
            num1=numberStack.pop();
            num2=numberStack.pop();
            oper=operStack.pop();
            result=numberStack.cal(num1,num2,oper);
            numberStack.push(result);
        }
        System.out.println("表达式 "+expression+" 的值为："+numberStack.pop());
    }
}
