package ThreadedBinaryTree;
import BinaryTree.*;
import org.junit.Test;

public class ThreadedBinaryTree {
    @Test
    public void ThreadedBinaryTreeTest(){
        Tree tree = new Tree();
        Node hero1 = new Node(new Hero(1, "宋江", "及时雨"));
        Node hero2 = new Node(new Hero(3, "吴用", "智多星"));
        Node hero3 = new Node(new Hero(6, "卢俊义", "玉麒麟"));
        Node hero4 = new Node(new Hero(8, "林冲", "豹子头"));
        Node hero5 = new Node(new Hero(10, "关胜", "大刀"));
        Node hero6 = new Node(new Hero(14, "熊嘉晟", "点点君"));

        tree.setRoot(hero1);
        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero2.setLeft(hero4);
        hero2.setRight(hero5);
        hero3.setLeft(hero6);
        //测试线索化
        tree.threadedNodes(hero1);
        Node left = hero5.getLeft();
        System.out.println(left.Data);
        Node right = hero5.getRight();
        System.out.println(right.Data);
        //测试线索化遍历
        System.out.println("线索化遍历");
        tree.threadedList();
    }
    @Test
    public void preThreadedTest(){
        Tree tree = new Tree();
        Node hero1 = new Node(new Hero(1, "宋江", "及时雨"));
        Node hero2 = new Node(new Hero(3, "吴用", "智多星"));
        Node hero3 = new Node(new Hero(6, "卢俊义", "玉麒麟"));
        Node hero4 = new Node(new Hero(8, "林冲", "豹子头"));
        Node hero5 = new Node(new Hero(10, "关胜", "大刀"));
        Node hero6 = new Node(new Hero(14, "熊嘉晟", "点点君"));

        tree.setRoot(hero1);
        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero2.setLeft(hero4);
        hero2.setRight(hero5);
        hero3.setLeft(hero6);
        tree.threadedNodesPre(hero1);
        tree.threadedListPre();
    }
    @Test
    public void postThreadedTest(){
        Tree tree = new Tree();
        Node hero1 = new Node(new Hero(1, "宋江", "及时雨"));
        Node hero2 = new Node(new Hero(3, "吴用", "智多星"));
        Node hero3 = new Node(new Hero(6, "卢俊义", "玉麒麟"));
        Node hero4 = new Node(new Hero(8, "林冲", "豹子头"));
        Node hero5 = new Node(new Hero(10, "关胜", "大刀"));
        Node hero6 = new Node(new Hero(14, "熊嘉晟", "点点君"));

        tree.setRoot(hero1);
        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero2.setLeft(hero4);
        hero2.setRight(hero5);
        hero3.setLeft(hero6);
        tree.threadedNodesPost(hero1);
        tree.threadedListPost();
    }
}