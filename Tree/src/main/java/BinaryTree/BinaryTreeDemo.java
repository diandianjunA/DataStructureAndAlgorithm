package BinaryTree;

import org.junit.Test;

public class BinaryTreeDemo {
    @Test
    public void TreeTest(){
        Tree tree = new Tree();
        Node hero1 = new Node(new Hero(1, "宋江", "及时雨"));
        Node hero2 = new Node(new Hero(2, "吴用", "智多星"));
        Node hero3 = new Node(new Hero(3, "卢俊义", "玉麒麟"));
        Node hero4 = new Node(new Hero(4, "林冲", "豹子头"));
        Node hero5 = new Node(new Hero(5, "关胜", "大刀"));
        //手动创建二叉树（后续再使用递归方式创建二叉树）
        tree.setRoot(hero1);
        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero3.setRight(hero4);
        hero3.setLeft(hero5);

        //测试前序遍历
        System.out.println("前序遍历");
        tree.preOrder();
        //测试中序遍历
        System.out.println("中序遍历");
        tree.infixOrder();
        //后序遍历
        System.out.println("后序遍历");
        tree.postOrder();
    }
    @Test
    public void TreeTest2(){
        Tree tree = new Tree();
        Node hero1 = new Node(new Hero(1, "宋江", "及时雨"));
        Node hero2 = new Node(new Hero(2, "吴用", "智多星"));
        Node hero3 = new Node(new Hero(3, "卢俊义", "玉麒麟"));
        Node hero4 = new Node(new Hero(4, "林冲", "豹子头"));
        Node hero5 = new Node(new Hero(5, "关胜", "大刀"));
        //手动创建二叉树（后续再使用递归方式创建二叉树）
        tree.setRoot(hero1);
        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero3.setRight(hero4);
        hero3.setLeft(hero5);
//        //前序查找
//        Node node = tree.preSearch(5);
//        if(node!=null){
//            System.out.println(node.Data);
//        }else{
//            System.out.println("没有找到");
//        }
//        //中序查找
//        Node node = tree.infixSearch(5);
//        if(node!=null){
//            System.out.println(node.Data);
//        }else{
//            System.out.println("没有找到");
//        }
        //后序查找
        Node node = tree.postSearch(5);
        if(node!=null){
            System.out.println(node.Data);
        }else{
            System.out.println("没有找到");
        }
    }
    @Test
    public void TreeDeleteTest(){
        Tree tree = new Tree();
        Node hero1 = new Node(new Hero(1, "宋江", "及时雨"));
        Node hero2 = new Node(new Hero(2, "吴用", "智多星"));
        Node hero3 = new Node(new Hero(3, "卢俊义", "玉麒麟"));
        Node hero4 = new Node(new Hero(4, "林冲", "豹子头"));
        Node hero5 = new Node(new Hero(5, "关胜", "大刀"));
        //手动创建二叉树（后续再使用递归方式创建二叉树）
        tree.setRoot(hero1);
        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero3.setRight(hero4);
        hero3.setLeft(hero5);
        System.out.println("删除前，前序遍历");
        tree.preOrder();
        tree.delete(3);
        System.out.println("删除后，前序遍历");
        tree.preOrder();
    }
}

