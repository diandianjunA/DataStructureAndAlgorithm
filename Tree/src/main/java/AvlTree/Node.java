package AvlTree;

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
        //当添加完一个节点后，如果右子树的高度-左子树的高度>1，则进行左旋转
        if(rightHeight()-leftHeight()>1){
            if(right!=null&&right.leftHeight()>right.rightHeight()){
                //先对当前节点的右子节点进行右旋转
                right.rightRotate();
                leftRotate();
            }else{
                leftRotate();
            }
            return;
        }
        if (leftHeight()-rightHeight()>1){
            //如果它的左子树的右子树高度大于左子树，则先对左子节点进行一次左旋转
            if(left!=null&&left.rightHeight()>left.leftHeight()){
                //先对当前节点的左节点进行左旋转
                left.leftRotate();
                //再对当前节点进行右旋转
                rightRotate();
            }else{
                rightRotate();
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
    //以该节点为根节点的树的高度
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }
    //返回左子树的高度
    public int leftHeight(){
        if (left==null){
            return 0;
        }
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight(){
        if (right==null){
            return 0;
        }
        return right.height();
    }
    //左旋转
    public void leftRotate(){
        //创建新节点，值等于当前节点的值
        Node newNode = new Node(value);
        //把新节点的左子树设置为当前节点的左子树
        newNode.left=left;
        //把新节点的右子树设置为当前节点右子节点的左子树
        newNode.right=right.left;
        //把当前节点的值修改为右子节点的值
        value=right.value;
        //把当前节点的右子树设置成右子节点的右子树
        right=right.right;
        //把当前节点的左子节点设置为新节点
        left=newNode;
    }
    //右旋转
    public void rightRotate(){
        //创建新节点，值等于当前节点的值
        Node newNode = new Node(value);
        //把新节点的右子树设置为当前节点的右子树
        newNode.right=right;
        //把新节点的左子树设置为当前节点左子节点的右子树
        newNode.left=left.right;
        //把当前节点的值修改为左子节点的值
        value=left.value;
        //把当前节点的左子树设置成左子节点的左子树
        left=left.left;
        //把当前节点的右子节点设置为新节点
        right=newNode;
    }
}
