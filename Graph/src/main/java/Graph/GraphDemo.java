package Graph;

import org.junit.Test;

public class GraphDemo {
    @Test
    public void graphTest(){
        int n=5;
        String[] vertexValue={"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String value :vertexValue) {
            graph.insertVertex(value);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.showGraph();
        graph.dfs();
        System.out.println();
        graph.bfs();
    }
    @Test
    public void graphTest2(){
        int n=8;
        String[] vertex={"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(n);
        for (String value :vertex) {
            graph.insertVertex(value);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.insertEdge(3,7,1);
        graph.insertEdge(4,7,1);
        graph.insertEdge(2,5,1);
        graph.insertEdge(2,6,1);
        graph.insertEdge(5,6,1);
        graph.showGraph();
        graph.dfs();
        System.out.println();
        graph.bfs();
    }
}
