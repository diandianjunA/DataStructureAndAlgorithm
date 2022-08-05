package DoubleLinkedList;

import org.testng.annotations.Test;

import java.lang.reflect.Field;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {
    //创建节点
    Hero hero1 = new Hero(1, "宋江", "及时雨");
    Hero hero2 = new Hero(2, "卢俊义", "玉麒麟");
    Hero hero3 = new Hero(3, "吴用", "智多星");
    Hero hero4 = new Hero(4, "林冲", "豹子头");
    DoubleLinkedList<Hero> doubleLinkedList = new DoubleLinkedList<Hero>();

    public DoubleLinkedListDemo() {
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
    }

    //改用单元测试的方法来测试链表的功能
    @Test
    public void DoubleLinkedShowTest(){
        System.out.println("双向链表的测试");
        DoubleLinkedListDemo doubleLinkedListDemo = new DoubleLinkedListDemo();
        doubleLinkedListDemo.doubleLinkedList.showTheList();
    }
    @Test
    public void DoubleLinkedUpdateTest() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("双向链表的测试");
        DoubleLinkedListDemo doubleLinkedListDemo = new DoubleLinkedListDemo();
        hero4.name="公孙胜";
        hero4.nickname="入云龙";
        doubleLinkedListDemo.doubleLinkedList.update(hero4);
        doubleLinkedListDemo.doubleLinkedList.showTheList();
    }
    @Test
    public void DoubleLinkedDeleteTest() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("双向链表的测试");
        DoubleLinkedListDemo doubleLinkedListDemo = new DoubleLinkedListDemo();
        doubleLinkedListDemo.doubleLinkedList.deleteNodeById(4);
        doubleLinkedListDemo.doubleLinkedList.showTheList();
    }
}
//双向链表类
class DoubleLinkedList<T>{
    T data;
    Node<T> head=new Node<T>();

    public Node<T> getHead() {
        return head;
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
    //找到尾节点
    public Node<T> getLastNode(){
        Node<T> temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
    //添加节点到双向链表
    public void add(T data){
        Node<T> newNode=new Node<>(data);
        Node<T> lastNode = getLastNode();
        lastNode.next=newNode;
        newNode.pre=lastNode;
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
        Node<T> temp=head.next;
        while (temp!=null){
            int nodeId = getNodeId((T) temp.Data);
            if(nodeId==id){
                break;
            }else{
                temp=temp.next;
            }
        }
        if(temp==null){
            System.out.println("无此节点");
            return;
        }
        temp.pre.next=temp.next;
        if(temp.next!=null){
            temp.next.pre=temp.pre;
        }
    }
}
//节点类
class Node<T>{
    public T Data;
    Node<T> pre;//指向前一个节点
    Node<T> next;//指向后一个节点

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