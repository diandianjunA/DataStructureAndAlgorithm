package AvlTree;


public class AvlTree {
    private Node root;
    public void add(Node node){
        if(root==null){
            root=node;
        }else{
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrder(){
        if(root!=null){
            root.infixOrder();
        }else{
            System.out.println("当前树为空");
        }
    }
    //查找要删除的节点
    public Node search(int value){
        if(root==null){
            return null;
        }else{
            return root.search(value);
        }
    }
    //查找父节点
    public Node searchParent(int value){
        if (root==null){
            return null;
        }else {
            if(root.value==value){
                return null;
            }else{
                return root.searchParent(value);
            }
        }
    }
    //删除节点
    public void deleteNode(int value){
        if (root==null){
            return;
        }
        Node targetNode = search(value);
        if(targetNode==null){
            return;
        }
        Node parent = searchParent(value);
        //如果要删除的节点是叶子结点
        if(targetNode.left==null&&targetNode.right==null){
            if(parent==null){
                root=null;
                return;
            }
            if(parent.left==targetNode){
                parent.left=null;
            }else if(parent.right==targetNode){
                parent.right=null;
            }
        }else if(targetNode.left!=null&&targetNode.right!=null){//删除有两棵子树的节点
            int minValue = delRightTreeMin(targetNode.right);
            targetNode.value=minValue;
        }else{//删除有一棵子树的节点
            if(targetNode.left!=null){
                if(parent==null){
                    root=targetNode.left;
                    return;
                }
                if(parent.left==targetNode){
                    parent.left=targetNode.left;
                }else if(parent.right==targetNode){
                    parent.right=targetNode.left;
                }
            }else{
                if(parent==null){
                    root=targetNode.right;
                    return;
                }
                if(parent.left==targetNode){
                    parent.left=targetNode.right;
                }else if(parent.right==targetNode){
                    parent.right=targetNode.right;
                }
            }
        }
    }
    //找到以当前节点为根节点的最小节点
    public int delRightTreeMin(Node node){
        Node target = node;
        while(target.left!=null){
            target=target.left;
        }
        deleteNode(target.value);
        return target.value;
    }

    public Node getRoot() {
        return root;
    }

}
