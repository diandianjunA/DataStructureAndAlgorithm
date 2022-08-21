package HuffumanTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HuffumanTreeDemo {
    public static void main(String[] args) {
        int arr[]={13,7,8,3,29,6,1};
        Node huffumanTree = createHuffumanTree(arr);
        if(huffumanTree!=null){
            huffumanTree.preOrder();
        }else{
            System.out.println("空树");
        }
    }
    //创建赫夫曼树
    public static Node createHuffumanTree(int[] arr){
        //遍历arr数组，将arr的每个元素构成一个node，再将node放入ArrayList中
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }
        while(nodes.size()!=1){
            //排序从小到大
            Collections.sort(nodes);
            //取出根节点权值最小的二叉树
            Node left=nodes.get(0);
            //取出根节点权值第二小的二叉树
            Node right = nodes.get(1);
            //构建一棵新的二叉树
            Node parent=new Node(left.value+ right.value);
            parent.left=left;
            parent.right=right;
            //从ArrayList中删除left和right
            nodes.remove(left);
            nodes.remove(right);
            //将parent加入
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
//节点类
class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this.value);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}