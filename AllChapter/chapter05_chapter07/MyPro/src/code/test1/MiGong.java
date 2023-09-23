package code.test1;

public class MiGong {

    public static void main(String[] args) {

        //思路
        //1.先创建出迷宫，用二维数组表示  int[][] map = new int[8][7];
        //2.先规定map数组的元素值：0表示可以走 1表示障碍物

        int[][] map = new int[8][7];

        //3.将最上面一行和最下面一行 全部设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //4.将最右边的一列和最左边的一列 全部设置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;



        //输出当前地图
        System.out.println("---当前地图情况---");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");//输出一行
            }
            System.out.println();
        }

        T t1 = new T();
        t1.findWay2(map,1,1);

        System.out.println("\n===找路的情况如下===");

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");//输出一行
            }
            System.out.println();
        }

    }
}

class T{

    //使用递归回溯的思想来解决老鼠出迷宫

    /*
    1.findWay方法就是专门来找出迷宫的路径
    2.如果找到，就返回true 否者false
    3，map 就是二维数组 即表示迷宫
    4.i,j就是老鼠位置初始位置(1,1)
    5.因为我们是递归找路 所以我先规定map数组的各个值的含义
      0表示可以走 1表示障碍物 2表示可以走 3表示走过且为死路
    6.当map[6][5] = 2就说明找到了出路就可以结束 否则就继续找
    7.先确定老鼠找路策略 下-右-上-左
     */

    public boolean findWay(int[][] map,int i, int j){

        if (map[6][5] == 2){
            //说明已经找到
            return true;
        }else {
            if (map[i][j] == 0){
                //当前这个位置0，说明表示开业一走
                //我们假定可以走通
                map[i][j] = 2;
                //使用找路策略，来确定该位置是否真的可以走通
                //下-右-上-左
                if (findWay(map,i + 1,j)){//先尝试下
                    return true;
                } else if (findWay(map,i,j+1)) {//右
                    return true;
                }else if (findWay(map,i-1,j)){//上
                    return true;
                } else if (findWay(map,i,j-1)) {
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }

            }else {
                //map[i][j] = 1,2,3
                return false;
            }
        }

    }


    //修改找路策略，看看路径是否有变化
    //下-右-上-左=>上-右-下-左
    public boolean findWay2(int[][] map,int i, int j){

        if (map[6][5] == 2){
            //说明已经找到
            return true;
        }else {
            if (map[i][j] == 0){
                //当前这个位置0，说明表示开业一走
                //我们假定可以走通
                map[i][j] = 2;
                //使用找路策略，来确定该位置是否真的可以走通
                //上-右-下-左
                if (findWay2(map,i - 1,j)){//先尝试上
                    return true;
                } else if (findWay2(map,i,j+1)) {//右
                    return true;
                }else if (findWay2(map,i + 1,j)){//下
                    return true;
                } else if (findWay2(map,i,j-1)) {
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }

            }else {
                //map[i][j] = 1,2,3
                return false;
            }
        }

    }
}
