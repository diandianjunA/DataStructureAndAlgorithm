package BinarySortTree;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    //添加节点
    public void add(Node node){
        if(node==null){
            return;
        }
        if(node.value<this.value){
            if(this.left==null){
                this.left=node;
            }else{
                this.left.add(node);
            }
        }else{
            if(this.right==null){
                this.right=node;
            }else{
                this.right.add(node);
            }
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //查找要删除的节点
    public Node search(int value){
        if (value==this.value){
            return this;
        } else if (value < this.value) {
            //向左子树递归查找
            if(this.left!=null){
                return this.left.search(value);
            }else{
                return null;
            }
        }else{
            //向右子树递归查找
            if(this.right!=null){
                return this.right.search(value);
            }else{
                return null;
            }
        }
    }
    //查找要删除节点的父节点
    public Node searchParent(int value){
        if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else{
            //如果要查找的值比当前节点的值小，并且当前节点的左子节点不为空
            if (value<this.value&&this.left!=null){
                //向左子树递归查找
                return this.left.searchParent(value);
            }else if(value>=this.value&&this.right!=null){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
    }
}
