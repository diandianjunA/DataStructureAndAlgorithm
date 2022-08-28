package Prim;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data={'A','B','C','D','E','F','G'};
        int vertex=data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};
        Graph graph = new Graph(vertex);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph,data,weight);
        minTree.showGraph(graph);
        //测试普利姆算法
        minTree.prim(graph,1);
    }
}
class MinTree{
    public void createGraph(Graph graph,char[] data,int[][] weight){
        for (int i=0;i<data.length;i++){
            graph.data[i]=data[i];
            for (int j = 0; j < weight[i].length; j++) {
                graph.weight[i][j]=weight[i][j];
            }
        }
    }
    public void showGraph(Graph graph){
        for (int[] link:graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }
    //

    /**
     * 普利姆算法，得到最小生成树
     * @param graph 原来的连通图
     * @param v 从哪个点开始生成
     */
    public void prim(Graph graph,int v){
        //标记顶点是否被访问过，默认都是0
        int[] visited = new int[graph.vertex];
        visited[v]=1;
        //记录两个顶点的下标
        int h1=-1;
        int h2=-1;
        int minWeight=10000;
        //找到n-1条边
        for (int i = 1; i < graph.vertex; i++) {
            //遍历每一次生成的子图和哪个节点的距离最近
            for (int j = 0; j < graph.vertex; j++) {//j表示被访问过的节点
                if (visited[j]!=1){
                    continue;
                }
                for (int k = 0; k < graph.vertex; k++) {//k表示未被访问过的节点
                    if(visited[k]==0&&graph.weight[j][k]<minWeight){
                        //替换minWeight
                        minWeight=graph.weight[j][k];
                        h1=j;
                        h2=k;
                    }
                }
            }
            //退出该for循环时，表示找到了一条最短的边
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+"> 权值："+minWeight);
            //将当前节点标记为已访问
            visited[h2]=1;
            //重置minWeight
            minWeight=10000;
        }
    }
}

class Graph{
    int vertex;//表示节点个数
    char[] data;//存放节点数据
    int[][] weight;//存放邻接矩阵

    public Graph(int vertex) {
        this.vertex = vertex;
        data=new char[vertex];
        weight=new int[vertex][vertex];
    }

}