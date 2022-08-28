package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//表示邻接矩阵
    private int numOfEdge;//表示边的条数
    private boolean[] isVisited;//Z记录某个节点是否被访问

    public Graph(int n) {
        //初始化矩阵
        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        numOfEdge=0;
        isVisited=new boolean[n];
    }
    //插入顶点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 第一个点的下标
     * @param v2 第二个点的下标
     * @param weight 边的权值
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdge++;
    }
    //返回节点个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //返回边的个数
    public int getNumOfEdge(){
        return numOfEdge;
    }
    //返回节点i对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2之间边的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //显示图对应的邻接矩阵
    public void showGraph(){
        for (int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }
    //得到第一个邻接节点的下标
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2){
        for (int i=v2+1;i<vertexList.size();i++){
            if (edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }
    //深度优先遍历
    private void dfs(int i){
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i]=true;
        //获取i最近的邻接节点
        int w = getFirstNeighbor(i);
        while (w!=-1){
            if(!isVisited[w]){
                dfs(w);
            }else{
                w=getNextNeighbor(i,w);
            }
        }
    }
    public void dfs(){
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i]=false;
        }
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i]){
                dfs(i);
            }
        }
    }
    //广度优先遍历
    private void bfs(int i){
       int u;//表示队列头结点对应的下标
       int w;//表示邻接节点的下标
       //队列,节点访问顺序
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i)+"=>");
        isVisited[i]=true;
        //将该节点加入队列
        queue.addLast(i);
        while(!queue.isEmpty()){
            u = (Integer) queue.removeFirst();
            w=getFirstNeighbor(u);
            while(w!=-1){
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"=>");
                    isVisited[w]=true;
                    //入队列
                    queue.addLast(w);
                }
                w=getNextNeighbor(u,w);
            }
        }
    }
    public void bfs(){
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i]=false;
        }
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i]){
                bfs(i);
            }
        }
    }
}
