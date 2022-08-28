package Kruskal;

import org.junit.Test;

import java.util.Arrays;

public class Kruskal {
    private int edgeNum;//边的个数
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    private static final int INF=Integer.MAX_VALUE;
    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F','G'};
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        Kruskal kruskal = new Kruskal(vertex, matrix);
        kruskal.print();
        Edge[] edge = kruskal.getEdge();
        kruskal.sortEdge(edge);
        for (Edge e:edge) {
            System.out.println(e);
        }
        System.out.println("============");
        for (Edge edge1 : kruskal.kruskal()) {
            System.out.println(edge1);
        }

    }
    public Kruskal(char[] vertex,int[][] matrix){
        int vertexNum=vertex.length;//顶点个数
        //初始化顶点
        this.vertex=new char[vertexNum];
        for (int i = 0; i < vertex.length; i++) {
            this.vertex[i]=vertex[i];
        }
        //初始化边
        this.matrix=new int[vertexNum][vertexNum];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                this.matrix[i][j]=matrix[i][j];
            }
        }
        //统计边
        for (int i = 0; i < vertexNum; i++) {
            for (int j = i+1; j < vertexNum; j++) {
                if(this.matrix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }
    public void print(){
        System.out.println("邻接矩阵为：");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%12d",matrix[i][j]);
            }
            System.out.println();
        }
    }
    //对边进行排序
    private void sortEdge(Edge[] edges){
        for (int i = 1; i < edges.length; i++) {
            for (int j = 0; j < edges.length - i; j++) {
                if(edges[j].weight>edges[j+1].weight){
                    Edge temp=edges[j];
                    edges[j]=edges[j+1];
                    edges[j+1]=temp;
                }
            }
        }
    }
    private int getPosition(char ch){
        for (int i = 0; i < vertex.length; i++) {
            if(ch==vertex[i]){
                return i;
            }
        }
        return -1;
    }
    private Edge[] getEdge(){
        int index=0;
        Edge[] edges = new Edge[edgeNum];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                if(matrix[i][j]!=INF){
                    edges[index++]=new Edge(vertex[i],vertex[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点，用于判断两个顶点的终点是否相同
     * @param ends 记录各顶点终点的数组
     * @param i 表示传入顶点对应的下标
     * @return 返回下标为i的顶点对应的终点的下标
     */
    private int getEnd(int[] ends,int i){
        while(ends[i]!=0){
            i=ends[i];
        }
        return i;
    }
    public Edge[] kruskal(){
        int index = 0;//表示最后结果数组的索引
        int[] ends=new int[edgeNum];//用于保存已有最小生成树的每个顶点在最小生成树中的终点
        //创建结果数组,保存最后的最小生成树的边
        Edge[] result=new Edge[vertex.length-1];
        //总边数
        Edge[] edge = getEdge();
        sortEdge(edge);
        //遍历数组
        for (int i = 0; i < edge.length; i++) {
            //获取到第i条边的第一个顶点
            int p1=getPosition(edge[i].start);
            int p2=getPosition(edge[i].end);
            //获取p1和p2在已有的最小生成树中的终点
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            //判断是否构成回路
            if(m!=n){
                //没构成回路
                ends[m]=n;
                result[index++]=edge[i];
            }
        }
        return result;
    }
}
//创建表示边的类
class Edge{
    char start;
    char end;
    int weight;//权值

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}