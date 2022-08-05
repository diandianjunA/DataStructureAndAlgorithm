package Queue;

import java.util.Scanner;

/**
 * 数组实现环形队列
 */
public class ArrayCircleQueueDemo {
    public static void main(String[] args) {
        ArrayCircleQueue arrayCircleQueue = new ArrayCircleQueue(4);
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
                    arrayCircleQueue.show();
                    break;
                case 'e':
                    loop=false;
                    break;
                case 'a':
                    int i = scanner.nextInt();
                    arrayCircleQueue.add(i);
                    break;
                case 'g':
                    try {
                        int i1 = arrayCircleQueue.get();
                        System.out.println("取出的数据是："+i1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i1 = arrayCircleQueue.headQueue();
                        System.out.println("队列头数据是："+i1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("输入有误，重新输入");
            }
        }
    }
}
class ArrayCircleQueue{
    private int maxSize;
    private int front;//头部
    private int rear;//尾部
    private int[] arr;//存放数据
    //创造队列构造器
    public ArrayCircleQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=0;//指向队列第一个数据
        rear=0;//指向队列最后一个数据的后一个位置
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;//因为循环队列必须空出一个位置，所以是rear要加1，否则队空时也会满足该式子
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
        arr[rear]=n;
        rear=(rear+1)%maxSize;//尾部后移
    }
    //获取队列数据
    public int get(){
        //判断队列是否为空
        if(isEmpty()){
            
            throw new RuntimeException("队列为空，不能获取数据");
        }
        int i = arr[front];
        front=(front+1)%maxSize;//头部后移
        return i;
    }
    //显示队列所有数据
    public void show(){
        //判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空");
        }else {
            for (int i = front; i < front+size(); i++) {
                System.out.printf("arr[%d]=%d\t",i%maxSize,arr[i%maxSize]);
            }
            System.out.println();
        }
    }
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
    public int size(){
        return (rear-front+maxSize)%maxSize;
    }
}