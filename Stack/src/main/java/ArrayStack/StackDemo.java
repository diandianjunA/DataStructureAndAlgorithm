package ArrayStack;

import org.junit.Test;

import java.util.Scanner;

public class StackDemo {
    @Test
    public void stackTest(){
        ArrayStack arrayStack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        String key;
        while(loop){
            System.out.println("show:表示显示栈");
            System.out.println("exit:表示退出程序");
            System.out.println("push:表示添加数据入栈");
            System.out.println("pop:表示取出数据出栈");
            System.out.println("请输入你的选择");
            key=scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int i = scanner.nextInt();
                    arrayStack.push(i);
                    break;
                case "pop":
                    try{
                        int res= (int) arrayStack.pop();
                        System.out.println("出栈的数据为"+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
        System.out.println("程序退出");
    }
}
