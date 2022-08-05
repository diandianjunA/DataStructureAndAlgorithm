package SingleList;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Stack;

public class SingleListDemo {
    public static void main(String[] args) {
        //创建节点
        Hero hero1 = new Hero(1, "宋江", "及时雨");
        Hero hero2 = new Hero(2, "卢俊义", "玉麒麟");
        Hero hero3 = new Hero(3, "吴用", "智多星");
        Hero hero4 = new Hero(4, "林冲", "豹子头");
        //创建链表
        SingleLinkedList<Hero> heroSingleLinkedList = new SingleLinkedList<>();
        heroSingleLinkedList.add(hero1);
        heroSingleLinkedList.add(hero2);
        heroSingleLinkedList.add(hero3);
        heroSingleLinkedList.add(hero4);
    }
    //查询单链表中的有效节点个数
    public static int getLength(Node head){
        Node temp=head;
        int length=0;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    //查询单链表中倒数第k个节点
    public static <T> Node<T> getLastIndexNode(Node<T> head, int index){
        if(head.next==null){
            return null;
        }
        int length = getLength(head);
        if(index<=0||index>length){
            return null;
        }
        Node<T> temp=head.next;
        for (int i = 0; i < length-index; i++) {
            temp=temp.next;
        }
        return temp;
    }
    //单链表翻转
    public static void reverseList(Node head){
        //如果链表为空，或者只有一个节点，就不需要翻转
        if(head.next==null||head.next.next==null){
            return;
        }
        Node reverseHead=new Node<>();
        Node cur=head.next;
        Node next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        head.next=reverseHead.next;
    }
    //反向遍历链表
    public static <T> void showReverseList(Node<T> head){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node<T> temp=head.next;
        Stack<Node<T>> stack=new Stack<>();
        while (temp!=null){
            stack.add(temp);
            temp=temp.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().Data);
        }
    }
}
//单链表类
class SingleLinkedList<T>{
    //头结点,不存放具体数据
    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public SingleLinkedList() {
        head=new Node<>();
    }

    //添加节点到单向链表
    public void add(T data){
        Node<T> newNode=new Node<>(data);
        Node<T> lastNode = getLastNode();
        lastNode.next=newNode;
    }
    //添加节点，按照比较顺序
    public void addByOrder(T data) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Node<T> temp=head;
        Node<T> newNode=new Node<>(data);
        while (temp.next!=null){
            T tempData=(T)temp.next.Data;
            int res = compareData(tempData, data);
            if(res >0){
                break;
            }else if(res<0){
                temp=temp.next;
            }else{
                System.out.println("编号重复，无法添加");
                return;
            }
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    //找到尾节点
    public Node<T> getLastNode(){
        Node<T> temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
    //显示链表
    public void showTheList(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        Node<T> temp=head.next;
        while(temp!=null){
            System.out.println(temp.Data);
            temp=temp.next;
        }
    }
    public int compareData(T data1,T data2) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = data1.getClass();
        Method compareTo = clazz.getDeclaredMethod("compareTo",clazz);
        compareTo.setAccessible(true);
        Object resultObj = compareTo.invoke(data1, data2);
        Integer result=(Integer) resultObj;
        return result;
    }
    //根据编号修改节点信息
    public void update(T data) throws NoSuchFieldException, IllegalAccessException {
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        int nodeId = getNodeId(data);
        Node<T> node = findNodeById(nodeId);
        if(node==null){
            System.out.println("无此节点");
            return;
        }
        node.Data=data;
    }
    //根据编号找到节点
    public Node<T> findNodeById(int id) throws NoSuchFieldException, IllegalAccessException {
        Node<T> temp=head.next;
        while (temp!=null){
            int result = getNodeId(temp.Data);
            if(result==id){
                break;
            }else{
                temp=temp.next;
            }
        }
        return temp;
    }
    public int getNodeId(T data) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = data.getClass();
        Field rank = clazz.getDeclaredField("rank");
        Object resultObj = rank.get(data);
        Integer result=(Integer) resultObj;
        return result;
    }
    //删除节点
    public void deleteNodeById(int id) throws NoSuchFieldException, IllegalAccessException {
        Node<T> temp=head;
        while (temp.next!=null){
            int nodeId = getNodeId((T) temp.next.Data);
            if(nodeId==id){
                break;
            }else{
                temp=temp.next;
            }
        }
        if(temp.next==null){
            System.out.println("无此节点");
            return;
        }
        temp.next=temp.next.next;
    }
}
//节点类
class Node<T>{
    public T Data;
    public Node next;

    public Node() {

    }

    public Node(T data) {
        Data = data;
    }
}
//演示所用数据类
class Hero implements Comparable<Hero>{
    public int rank;
    public String name;
    public String nickname;

    public Hero(int rank, String name, String nickname) {
        this.rank = rank;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "SingleList.Hero{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }


    @Override
    public int compareTo(Hero o) {
        return this.rank-o.rank;
    }
}