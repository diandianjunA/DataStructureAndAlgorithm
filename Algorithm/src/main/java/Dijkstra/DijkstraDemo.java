package Dijkstra;

import java.util.Arrays;

public class DijkstraDemo {
    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F','G'};
        int[][] matrix=new int[vertex.length][vertex.length];
        final int N=65535;//表示不可连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        Graph graph = new Graph(vertex, matrix);
        graph.show();
        graph.dsj(6);
        graph.showDijkstra();
    }
}
class Graph{
    private char[] vertex;//顶点数组
    private int[][] weight;//邻接矩阵
    VisitedVertex visitedVertex;

    public Graph(char[] vertex, int[][] weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    public void show(){
        for (int[] link:weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 迪杰斯特拉算法
     * @param index 出发顶点的下边
     */
    public void dsj(int index){
        visitedVertex = new VisitedVertex(vertex.length, index);
        update(index);//更新index顶点到周围顶点的距离和前驱顶点
        for (int i = 1; i < vertex.length; i++) {
            index=visitedVertex.updateArr();
            update(index);
        }
    }

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
    private void update(int index){
        int len;
        for (int i = 0; i < weight[index].length; i++) {
            //len=出发顶点到index顶点的距离+index到i顶点距离的和
            len=visitedVertex.getDis(index)+weight[index][i];
            //如果j没有被访问过，并且len小于出发顶点到j顶点的距离，就需要更新
            if (!visitedVertex.in(i)&&len<visitedVertex.getDis(i)){
                visitedVertex.update(i,index);
                visitedVertex.updateDis(i,len);
            }
        }
    }
    public void showDijkstra(){
        visitedVertex.show();
    }
}
class VisitedVertex{
    private int[] already_arr;
    private int[] pre_visited;
    private int[] distance;

    /**
     * 构造器
     * @param length 顶点个数
     * @param index 出发顶点的下标
     */
    public VisitedVertex(int length,int index) {
        this.already_arr=new int[length];
        this.pre_visited=new int[length];
        this.distance=new int[length];
        //初始化distance
        Arrays.fill(distance,65535);
        already_arr[index]=1;
        this.distance[index]=0;
    }

    /**
     * 判断index顶点是否访问过
     * @param index 顶点下标
     * @return
     */
    public boolean in(int index){
        return already_arr[index]==1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     * @param index 目标顶点
     * @param len 距离
     */
    public void updateDis(int index,int len){
        distance[index]=len;
    }

    /**
     * 更新顶点的前驱为index下标对应的顶点
     * @param pre
     * @param index
     */
    public void update(int pre,int index){
        pre_visited[pre]=index;
    }
    public int getDis(int index){
        return distance[index];
    }
    //找到路径最短的下一个节点
    public int updateArr(){
        int min=65535,index=0;
        for (int i = 0; i < already_arr.length; i++) {
            if(already_arr[i]==0&&distance[i]<min){
                min=distance[i];
                index=i;
            }
        }
        already_arr[index]=1;
        return index;
    }
    public void show(){
        System.out.println("===================");
        for (int i = 0; i < already_arr.length; i++) {
            System.out.print(already_arr[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < pre_visited.length; i++) {
            System.out.print(pre_visited[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i]+" ");
        }
        System.out.println();
        char[] vertex={'A','B','C','D','E','F','G'};
        int count=0;
        for (int i:distance) {
            if(i!=65535){
                System.out.print(vertex[count]+"("+i+")");
            }else{
                System.out.print("N");
            }
            count++;
        }
        System.out.println();
    }
}