package ArrayBinaryTree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder(0);
    }
}
class ArrayBinaryTree{
    private int[] arr;//存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 完成顺序存储二叉树的前序遍历
     * @param index:数组的下标
     */
    public void preOrder(int index){
        //如果数组为空，或者arr.length=0
        if(arr==null||arr.length==0){
            System.out.println("数组为空");
            return;
        }
        System.out.println(arr[index]);
        //向左递归遍历
        if((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
        //向右递归遍历
        if ((index*2+2)<arr.length){
            preOrder(2*index+2);
        }
    }
}