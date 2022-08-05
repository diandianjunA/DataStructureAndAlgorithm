package Queue;

import java.util.Scanner;

/**
 * 数组实现队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        char key=' ';
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列头数据");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.show();
                    break;
                case 'e':
                    loop=false;
                    break;
                case 'a':
                    int i = scanner.nextInt();
                    arrayQueue.add(i);
                    break;
                case 'g':
                    try {
                        int i1 = arrayQueue.get();
                        System.out.println("取出的数据是："+i1);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 'h':
                    try {
                        int i1 = arrayQueue.headQueue();
                        System.out.println("队列头数据是："+i1);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("输入有误，重新输入");
            }
        }
    }

}
class ArrayQueue{
    private int maxSize;
    private int front;//头部
    private int rear;//尾部
    private int[] arr;//存放数据
    //创造队列构造器
    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=-1;//指向队列第一个数据的前一个位置
        rear=-1;//指向队列最后一个数据
    }
    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void add(int n){
        //判断队列是否已满
        if(isFull()){
            System.out.println("队列已满，不能添加数据");
            return;
        }
        rear++;//尾部后移
        arr[rear]=n;
    }
    //获取队列数据
    public int get(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能获取数据");
        }
        front++;//头部后移
        return arr[front];
    }
    //显示队列所有数据
    public void show(){
        //判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空");
        }else {
            for (int i = front+1; i <= rear; i++) {
                System.out.printf("arr[%d]=%d\t",i,arr[i]);
            }
            System.out.println();
        }
    }
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}