package HashTable;

import org.junit.Test;

import java.util.Scanner;

public class HashTableDemo {
    @Test
    public void hashTableTest1(){
        EmpHashTable empHashTable = new EmpHashTable(7);
        //写个菜单
        String key="";
        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);
        while(!isExit){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");
            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    empHashTable.add(emp);
                    break;
                case "list":
                    empHashTable.list();
                    break;
                case "find":
                    System.out.println("请输入id");
                    int i = scanner.nextInt();
                    empHashTable.findEmpById(i);
                    break;
                case "exit":
                    scanner.close();
                    isExit=true;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
    }
}
//哈希表
class EmpHashTable{
    private EmpLinkedList[] empLinkedLists;
    private int size;//表示链表的个数
    //构造器
    public EmpHashTable(int size){
        this.size=size;
        empLinkedLists=new EmpLinkedList[size];
        //将数组中的每个链表初始化,一定不要忘记
        for (int i = 0; i < size; i++) {
            empLinkedLists[i]=new EmpLinkedList();
        }
    }
    //添加雇员
    public void add(Emp emp){
        //根据员工的id，得到该员工应该加到哪个链表中
        int empLinkedListNo = hashFun(emp.id);
        //将emp加入到对应链表中
        empLinkedLists[empLinkedListNo].add(emp);

    }
    //编写散列函数，使用取魔法
    public int hashFun(int id){
        return id%size;
    }
    //遍历hashTable
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }
    public void findEmpById(int id){
        Emp empById = empLinkedLists[hashFun(id)].getEmpById(id);
        if(empById!=null){
            System.out.println("在第"+(hashFun(id)+1)+"条链表找到"+empById);
        }
    }
}
//哈希表所用链表
class EmpLinkedList{
    //头指针，指向第一个雇员
    private Node<Emp> head;
    //添加员工到链表
    //假定添加雇员时，id是自增的
    //直接将该雇员加到链表最后即可
    public void add(Emp emp){
        //如果添加第一个雇员
        if(head==null){
            head=new Node<>(emp);
            return;
        }
        Node<Emp> curEmp=head;
        while(curEmp.next!=null){
            curEmp=curEmp.next;
        }
        curEmp.next=new Node<>(emp);
    }
    //遍历链表雇员信息
    public void list(int number){
        if(head==null){
            System.out.println("第"+(number+1)+"条链表为空");
            return;
        }
        Node<Emp> curEmp=head;
        System.out.println("第"+(number+1)+"条链表的信息为:");
        while(curEmp!=null){
            System.out.println(curEmp.data);
            curEmp=curEmp.next;
        }
    }
    //根据id查找雇员
    public Emp getEmpById(int id){
        if(head==null){
            System.out.println("未找到");
            return null;
        }
        Node<Emp> temp=head;
        while(temp!=null){
            if(temp.data.id==id){
                return temp.data;
            }
            temp=temp.next;
        }
        System.out.println("未找到");
        return null;
    }
}
//链表所用节点
class Node<Emp>{
    Emp data;
    Node<Emp> next;

    public Node() {
    }

    public Node(Emp data) {
        this.data = data;
    }
}
//链表节点所用数据类
class Emp{
    public int id;
    public String name;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}