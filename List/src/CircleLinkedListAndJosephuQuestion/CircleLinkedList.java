package CircleLinkedListAndJosephuQuestion;

public class CircleLinkedList {
    private Node first;
    //添加小孩的节点
    public void add(int num){
        if(num<1){
            System.out.println("num is not correct");
            return;
        }
        Node curNode = null;
        for (int i = 1; i <= num; i++) {
            Node node=new Node(i);
            if(i==1){
                first=node;
                first.setNext(first);
                curNode=first;
            }else{
                curNode.setNext(node);
                node.setNext(first);
                curNode=node;
            }
        }
    }
    //遍历当前环形链表
    public void list(){
        Node curNode=first;
        if(curNode==null){
            System.out.println("The list is empty");
            return;
        }
        while(curNode.getNext()!=first){
            System.out.println("This is "+curNode.getNumber());
            curNode=curNode.getNext();
        }
        System.out.println("This is "+curNode.getNumber());
    }

    /**
     *
     * @param startNo:从几号小孩开始数
     * @param step:数几次淘汰一个小孩
     * @param num:总共几个小孩
     */
    public void counting(int startNo,int step,int num){
        if(num<1||startNo<1||startNo>num||step<1){
            System.out.println("输入数值有误");
            return;
        }
        this.add(num);
        Node helper=first;
        while (helper.getNext().getNumber()!=startNo){
            helper=helper.getNext();
        }
        first=helper.getNext();
        while (num!=1){
            for (int i = 0; i < step-1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            first=first.getNext();
            System.out.println(helper.getNext().getNumber()+" out");
            delete(helper.getNext().getNumber());
            num--;
            helper.setNext(first);
        }
        System.out.println(first.getNumber()+" win");
    }
    //删除某一节点
    public void delete(int number){
        Node temp=first;
        while(temp.getNext()!=first){
            if(temp.getNext().getNumber()==number){
                break;
            }
            temp=temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
    }
}
class Node{
    private int number;
    private Node next;

    public Node(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}