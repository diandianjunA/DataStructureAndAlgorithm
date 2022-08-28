package Floyd;

import java.util.Arrays;

public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;//表示不可连接
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        Graph graph = new Graph(vertex, matrix, vertex.length);
        graph.floyd();
        graph.show();
    }
}

class Graph {
    char[] vertex;//存放顶点
    int[][] distance;//保存任意两点的距离
    int[][] pre;//保存到目标顶点的中间顶点的下标

    public Graph(char[] vertex, int[][] distance, int length) {
        this.vertex = vertex;
        this.distance = distance;
        this.pre = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public void show() {
        System.out.println("pre数组");
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre[i].length; j++) {
                System.out.print(vertex[pre[i][j]] + " ");
            }
            System.out.println();
        }
        System.out.println("distance数组");
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
    //弗洛伊德算法
    public void floyd(){
        int len;
        //中间顶点的遍历
        for (int k = 0; k < distance.length; k++) {
            //起始顶点遍历
            for (int i = 0; i < distance.length; i++) {
                //终点遍历
                for (int j = 0; j < distance.length; j++) {
                    //ik距离+kj距离，有点类似动态规划
                    len=distance[i][k]+distance[k][j];
                    if(len<distance[i][j]){//如果新的距离小于原有最短距离，就修改一下
                        distance[i][j]=len;
                        pre[i][j]=k;//更新中间顶点
                    }
                }
            }
        }
    }
}