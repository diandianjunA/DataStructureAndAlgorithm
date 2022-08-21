package BinaryTree;

//二叉树类
public class Tree {
    private Node root;
    //为了实现线索化，需要创建指向当前节点的前驱节点的节点
    private Node pre = null;

    public Tree() {

    }

    public Tree(Node root) {
        this.root = root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    //前序遍历

    //对二叉树进行中序线索化
    public void threadedNodes(Node node) {
        if (node == null) {
            return;
        }
        //1.先线索化左子树
        if(node.getLeftType()!=1){
            threadedNodes(node.left);
        }
        //2.线索化当前节点
        //先处理当前节点的前驱节点
        if (node.left == null) {
            //让左指针指向前驱节点
            node.left = pre;
            //修改左指针的类型
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre != null && pre.right == null) {
            //让前驱节点的右指针指向该节点，相当于是为该节点的前驱节点设置后继节点
            pre.right = node;
            pre.setRightType(1);
        }
        //每处理一个节点，就让该节点作为下一个节点的前驱节点
        pre = node;
        //3.线索化右子树
        if(node.getRightType()!=1){
            threadedNodes(node.right);
        }
    }
    //前序线索化
    public void threadedNodesPre(Node node) {
        if (node == null) {
            return;
        }
        //1.线索化当前节点
        //处理左节点
        if(pre!=null&&node.left==null){
            node.left=pre;
            node.setLeftType(1);
        }
        //处理右节点
        if(pre!=null&&pre.right==null){
            pre.right=node;
            pre.setRightType(1);
        }
        //每处理一个节点，就让该节点作为下一个节点的前驱节点
        pre = node;
        //2.先线索化左子树
        if(node.getLeftType()!=1){
            threadedNodesPre(node.left);
        }
        //3.线索化右子树
        if(node.getRightType()!=1){
            threadedNodesPre(node.right);
        }
    }
    //后序线索化
    public void threadedNodesPost(Node node) {
        if (node == null) {
            return;
        }
        //1.先线索化左子树
        if(node.getLeftType()!=1){
            threadedNodesPost(node.left);
        }
        //2.线索化右子树
        if(node.getRightType()!=1){
            threadedNodesPost(node.right);
        }
        //3.线索化当前节点
        //先处理当前节点的前驱节点
        if (node.left == null) {
            //让左指针指向前驱节点
            node.left = pre;
            //修改左指针的类型
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre != null && pre.right == null) {
            //让前驱节点的右指针指向该节点，相当于是为该节点的前驱节点设置后继节点
            pre.right = node;
            pre.setRightType(1);
        }
        //每处理一个节点，就让该节点作为下一个节点的前驱节点
        pre = node;
    }

    //中序遍历线索化二叉树
    public void threadedList(){
        //存储当前遍历的节点
        Node node=root;
        while(node!=null){
            //循环找到leftType=1的节点，第一个找到的就是最先输出的节点
            while (node.getLeftType()==0){
                node=node.left;
            }
            System.out.println(node.Data);
            //如果当前节点的右指针指向的是后继节点，则一直输出
            while (node.getRightType()==1){
                node=node.right;
                System.out.println(node.Data);
            }
            //这段比较重要，如果右指针不是后继节点
            //说明在右子树那边有比右节点排名更前的节点，让node指向右节点
            //再重新进入循环，通过上面那个循环，去找到这棵子树排名最靠前的那个节点
            //再靠着后继节点不断遍历
            node=node.right;
        }
    }
    //前序线索化遍历
    public void threadedListPre(){
        //存储当前遍历的节点
        Node node=root;
        while(node!=null){
            System.out.println(node.Data);
            //循环找到leftType=1的节点，第一个找到的就是最先输出的节点
            while (node.left!=null&&node.getLeftType()!=1){
                node=node.left;
                System.out.println(node.Data);
            }
            //如果当前节点的右指针指向的是后继节点，则一直输出
            while (node.right!=null&&node.getRightType()==1){
                node=node.right;
                System.out.println(node.Data);
            }
            //这段比较重要，如果右指针不是后继节点
            //说明在右子树那边有比右节点排名更前的节点，让node指向右节点
            //再重新进入循环，通过上面那个循环，去找到这棵子树排名最靠前的那个节点
            //再靠着后继节点不断遍历
            node=node.right;
        }
    }
    //后序线索化遍历
    public void threadedListPost(){
        //存储当前遍历的节点
        Node node=root;
        pre=null;
        //循环找到leftType=1的节点，第一个找到的就是最先输出的节点
        while (node!=null&&node.getLeftType()==0){
            node=node.left;
        }
        System.out.println(node.Data);
        while(node!=null){
            if(node.getRightType()==1){//如果右节点就是后继节点，就一直遍历
                pre=node;
                node=node.right;
                System.out.println(node.Data);
            }else if(node.right==pre){
                //如果不是，就看它是左子树回调还是右子树回调，如果它的右子节点就是它的前驱节点，则是右子树回调
                //如果到了root就退出，如果没有，就往上一级回调，去完成中间节点的遍历
                if(node==root){
                    return;
                }
                pre=node;
                node=node.parent;
            }else{
                //如果是左子树回调，就说明左边遍历完成，右边还没遍历，直接调它的右子节点即可
                node=node.right;
                //循环找到leftType=1的节点，第一个找到的就是最先输出的节点
                while (node!=null&&node.getLeftType()==0){
                    node=node.left;
                    System.out.println(node.Data);
                }
            }
        }
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public Node preSearch(int rank) {
        if (root == null) {
            return null;
        }
        return root.preSearch(rank);
    }

    //中序查找
    public Node infixSearch(int rank) {
        if (root == null) {
            return null;
        }
        return root.infixSearch(rank);
    }

    //后序查找
    public Node postSearch(int rank) {
        if (root == null) {
            return null;
        }
        return root.postSearch(rank);
    }

    //删除节点
    public boolean delete(int rank) {
        if (root == null) {
            return false;
        } else if (root.Data.rank == rank) {
            root = null;
            return true;
        } else {
            if (root.delete(rank)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
