package KnightAlgorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HorseChess {
    private static int X;//棋盘的列
    private static int Y;//棋盘的行
    private static boolean visited[][];//标记棋盘上某位置是否被访问过
    private static boolean finished;//看棋盘所有位置是否被全部访问
    public static void main(String[] args) {
        X=8;
        Y=8;
        Point point = new Point(0, 0);
        int[][] chessBoard=new int[Y][X];
        visited=new boolean[Y][X];
        long start = System.currentTimeMillis();
        travelChessBoard(chessBoard,point,1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        for (int[] row:chessBoard) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * 骑士周游问题算法
     * @param chessBoard 棋盘
     * @param point 马儿当前位置的坐标
     * @param step 当前步骤是第几步
     */
    public static void travelChessBoard(int[][] chessBoard,Point point,int step){
        chessBoard[point.y][point.x]=step;
        visited[point.y][point.x]=true;
        //获取当前位置可以走的下一步的位置的集合
        ArrayList<Point> result = next(point);
        //对result进行非递减排序
        sort(result);
        for (Point p : result) {
            //判断该点是否已访问过
            if(!visited[p.y][p.x]){
                travelChessBoard(chessBoard,p,step+1);
            }
        }
        //这里之所以需要两个条件是因为要判断骑士是真的没有完成才回溯的还是已经完成了才回溯的（这两种情况step都会小于X*Y）
        if(step<X*Y&&!finished){
            chessBoard[point.y][point.x]=0;
            visited[point.y][point.x]=false;
        }else{
            finished=true;
        }
    }

    /**
     * 根据当前位置，计算马儿还能走哪些位置
     * @param curPoint 当前坐标
     * @return 马儿下一步能走的位置的集合
     */
    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> result = new ArrayList<>();
        Point p1 = new Point();
        if((p1.x=curPoint.x-2)>=0&&(p1.y= curPoint.y-1)>=0){
            result.add(new Point(p1));
        }
        if((p1.x=curPoint.x-1)>=0&&(p1.y= curPoint.y-2)>=0){
            result.add(new Point(p1));
        }
        if((p1.x=curPoint.x+2)<X&&(p1.y= curPoint.y-1)>=0){
            result.add(new Point(p1));
        }
        if((p1.x=curPoint.x+1)<X&&(p1.y= curPoint.y-2)>=0){
            result.add(new Point(p1));
        }
        if((p1.x=curPoint.x-2)>=0&&(p1.y= curPoint.y+1)<Y){
            result.add(new Point(p1));
        }
        if((p1.x=curPoint.x-1)>=0&&(p1.y= curPoint.y+2)<Y){
            result.add(new Point(p1));
        }
        if((p1.x=curPoint.x+2)<X&&(p1.y= curPoint.y+1)<Y){
            result.add(new Point(p1));
        }
        if((p1.x=curPoint.x+1)<X&&(p1.y= curPoint.y+2)<Y){
            result.add(new Point(p1));
        }
        return result;
    }
    //根据当前这一步的所有下一步的选择位置进行非递减排序
    public static void sort(ArrayList<Point> result){
        result.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取到o1下一步的所有位置
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if(count1<count2){
                    return -1;
                } else if (count1==count2) {
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }
}
