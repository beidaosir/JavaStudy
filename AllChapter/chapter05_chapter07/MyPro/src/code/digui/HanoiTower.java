package code.digui;

public class HanoiTower {

    public static void main(String[] args) {

        Tower tower = new Tower();

        tower.move(3,'a','b','c');

    }
}

class Tower{
    //方法
    //num 表示层数  a,b,c分别表示A、B、C塔
    public void move(int num,char a,char b,char c){
        //如果只有一层
        if (num == 1){
            //直接从A 移动到 C
            System.out.println(a + "->" + c);
        }else {
            //如果多层 看成两个 最下面的 和 上面所有层(n-1)
            // 1.先移动上面所有盘到b 借助 c
            move(num-1,a,c,b);//这一步又去调用move 回到上面执行 如此嵌套
            // 此时b形成n-1层小汉诺塔 然后回溯

            // 2.上面移动到b之后开始执行这个 把最下面的这个盘移动到 c
            System.out.println(a + "->" + c);

            // 3.再把b 上面的所有盘(n-1)个 移动到 c 借助a
            move(num-1,b,a,c);//这一步又去调用move 回到上面执行

        }
    }
}
