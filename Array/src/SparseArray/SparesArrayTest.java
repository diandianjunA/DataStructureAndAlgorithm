package SparseArray;

/**
 * 稀疏数组
 */
public class SparesArrayTest {
    public static void main(String[] args) {
        //初始棋盘，1表示白子，2表示黑子
        int[][] chessArray=new int[11][11];
        chessArray[1][2]=1;
        chessArray[2][3]=2;
        //输出原始棋盘
        System.out.println("输出原始棋盘");
        for (int[] row:chessArray) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.printf("\n");
        }
        System.out.println();
        //转为稀疏数组
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;//记录非0数据的个数
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if(chessArray[i][j]!=0){
                    sum++;
                }
            }
        }
        //2.创建稀疏数组
        int[][] sparseArray=new int[sum+1][3];
        //给稀疏数组赋值
        sparseArray[0][0]=chessArray.length;
        sparseArray[0][1]=chessArray[0].length;
        sparseArray[0][2]=sum;
        //遍历二维数组，将非0值放入
        int count=0;//计数器
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if(chessArray[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=chessArray[i][j];
                }
            }
        }
        //输出稀疏数组形式
        System.out.println("输出稀疏数组");
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.printf("%d\t",sparseArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        //将稀疏数组还原为二维数组
        int[][] chessArray2=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        //输出还原后的数组
        System.out.println("输出还原后的棋盘");
        for (int i = 0; i < chessArray2.length; i++) {
            for (int j = 0; j < chessArray2[i].length; j++) {
                System.out.printf("%d\t",chessArray2[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
