package BinaryTree;

//节点类
public class Node {
    public Hero Data;
    Node left;//指向左边节点
    Node right;//指向右边节点
    Node parent;//指向父节点

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    //说明，如果leftType==0表示指向左子树，如果等于1则表示指向前驱节点
    //如果rightType==0表示指向右子树，如果等于1则表示指向后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node() {
        Data = new Hero();
    }

    public Node(Hero data) {
        Data = data;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(Data);
        if (left != null) {
            left.preOrder();
        }
        if (right != null) {
            right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (left != null) {
            left.infixOrder();
        }
        System.out.println(Data);
        if (right != null) {
            right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (left != null) {
            left.postOrder();
        }
        if (right != null) {
            right.postOrder();
        }
        System.out.println(Data);
    }

    public void setLeft(Node left) {
        this.left = left;
        left.parent=this;
    }

    public void setRight(Node right) {
        this.right = right;
        right.parent=this;
    }

    //前序查找
    public Node preSearch(int rank) {
        System.out.println("前序遍历查找~");
        if (this.Data.rank == rank) {
            return this;
        }
        Node temp = null;
        if (this.left != null) {
            temp = this.left.preSearch(rank);
        }
        if (temp != null) {
            return temp;
        }
        if (this.right != null) {
            temp = this.right.preSearch(rank);
        }
        return temp;
    }

    //中序查找
    public Node infixSearch(int rank) {
        Node temp = null;
        if (this.left != null) {
            temp = this.left.infixSearch(rank);
        }
        if (temp != null) {
            return temp;
        }
        System.out.println("中序遍历查找~");
        if (this.Data.rank == rank) {
            return this;
        }
        if (this.right != null) {
            temp = this.right.infixSearch(rank);
        }
        return temp;
    }

    //后序查找
    public Node postSearch(int rank) {
        Node temp = null;
        if (this.left != null) {
            temp = this.left.postSearch(rank);
        }
        if (temp != null) {
            return temp;
        }
        if (this.right != null) {
            temp = this.right.postSearch(rank);
        }
        if (temp != null) {
            return temp;
        }
        System.out.println("后序遍历查找~");
        if (this.Data.rank == rank) {
            return this;
        }
        return null;
    }

    //递归删除节点
    public boolean delete(int rank) {
        if (this.left != null && this.left.Data.rank == rank) {
            this.left = null;
            return true;
        }
        if (this.right != null && this.right.Data.rank == rank) {
            this.right = null;
            return true;
        }
        boolean isDeleteSuccessfully = false;
        if (this.left != null) {
            isDeleteSuccessfully = this.left.delete(rank);
        }
        if (isDeleteSuccessfully) {
            return true;
        }
        if (this.right != null) {
            isDeleteSuccessfully = this.right.delete(rank);
        }
        return isDeleteSuccessfully;
    }
}
