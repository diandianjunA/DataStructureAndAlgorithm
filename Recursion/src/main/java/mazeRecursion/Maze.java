package mazeRecursion;

public class Maze {
    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        int[][] maze = new int[8][7];
        //使用1表示墙
        //把上下都置为1
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        //把左右都置为1
        for (int i = 0; i < 8; i++) {
            maze[i][0]=1;
            maze[i][6]=1;
        }
        //设置地图中的障碍物
        maze[3][1]=1;
        maze[3][2]=1;
        maze[6][4]=1;
        //显示地图
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
        //使用递归回溯给小球找路
        setWay(maze,1,1);
        System.out.println();
        //输出新地图
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
    /**
     * 使用递归回溯来给小球找路
     * 终点约定为map[6][5]
     * 约定map[x][y]为0表示该点没有走过，为1时表示墙，为2时表示通路，为3表示该点已走过，但走不通
     * 走迷宫的策略为：下->右->上->左，走不通就回溯
     * @param map:迷宫地图，递归每层函数都共享
     * @param i:起点的横坐标
     * @param j:起点的纵坐标
     * @return：如果找到了通路，就返回true，否则返回false
     */
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][5]==2){//通路已找到
            return true;
        }else{
            if(map[i][j]==0){
                //按照策略下->右->上->左 来走
                map[i][j]=2;
                if(setWay(map,i+1,j)){//尝试向下走
                    return true;
                }else if(setWay(map,i,j+1)){//向下走不通，向右走
                    return true;
                }else if (setWay(map, i-1, j)){//上面都不行，向上走
                    return true;
                }else if(setWay(map,i,j-1)){//都不行，向左走
                    return true;
                }else{
                    //说明该点走不通，是死路
                    map[i][j]=3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
