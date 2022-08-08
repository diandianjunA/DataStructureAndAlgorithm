package ArrayStack;

public class ArrayStack<T> {
    private int maxSize;//栈的大小
    private T[] stack;//数组，用来模拟栈，存储数据
    private int top = -1;//表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = (T[]) new Object[maxSize];
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-push
    public void push(T value) {
        //判断栈是否已满
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈-pop,将栈顶的数据返回
    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        T value=stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println("第"+(i+1)+"个数据为"+stack[i]);
        }
    }

    //返回运算符的优先级，优先级由程序员来确定，用数字来表示
    //数字越大，优先级越高
    public int priority(int oper){
        if(oper=='*'||oper=='/'){
            return 1;
        }else if(oper=='+'||oper=='-'){
            return 0;
        }else{
            return -1;
        }
    }
    //判断是否为运算符
    public boolean isOper(int val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    //计算方法
    public int cal(int num1,int num2,int oper){
        int result=0;
        switch (oper){
            case '+':result=num1+num2;break;
            case '-':result=num2-num1;break;
            case '*':result=num1*num2;break;
            case '/':result=num2/num1;break;
        }
        return result;
    }
    //返回栈顶的值，但不弹出
    public T peek(){
        return stack[top];
    }
}
