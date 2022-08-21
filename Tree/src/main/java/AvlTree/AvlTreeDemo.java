package AvlTree;

import org.junit.Test;

public class AvlTreeDemo {
    @Test
    public void Test1(){
//        int[] arr={4,3,6,5,7,8};
//        int[] arr={10,12,8,9,7,6};
        int[] arr={10,11,7,6,8,9};
        AvlTree avlTree = new AvlTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();
        System.out.println("树的高度："+avlTree.getRoot().height());
        System.out.println("左子树的高度："+avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度："+avlTree.getRoot().rightHeight());
        System.out.println(avlTree.getRoot());
    }
}
