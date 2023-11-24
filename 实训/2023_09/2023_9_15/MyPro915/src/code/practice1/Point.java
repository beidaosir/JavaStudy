package code.practice1;

import org.w3c.dom.ls.LSOutput;

/**
 * 1.定义一个点类Point，包含2个成员变量x、y分别表示x和y坐标，
 * 2个构造器Point()和Point(int x0,int y0),
 * 以及一个movePoint（int dx,int dy）方法实现点的位置移动。
 * 编写一个程序，创建两个Point对象p1、p2，
 * 分别调研movePoint方法后，打印p1和p2的坐标。
 */
public class Point {

    int x;
    int y;

    Point(){

    }
    Point(int x0, int y0){
        x = x0;
        y = y0;
    }

    void showPoint(){
        System.out.println("x坐标：" + x + "  y坐标：" + y);
    }

    /**
     * 点移动的方法
     * dx x轴偏移量
     * dy y轴偏移量
     */
    void movePoint(int dx,int dy){

        if ((dx < 0 && Math.abs(dx) > x )|| (dy < 0 && Math.abs(dy) > y)){
            System.out.println("不可以哦，这样就移到外太空了！");
            return;//结束该方法
        }
        x += dx;
        y += dy;
    }

}
