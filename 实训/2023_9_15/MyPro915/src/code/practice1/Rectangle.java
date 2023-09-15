package code.practice1;

/**
 * 2.定义一个矩形类Rectangle：
 * 1)定义三个方法：getArea()求面积、getPer()求周长，
 *   showAll()分别在控制台输出长、宽、面积、周长。
 * 2)有2个属性：长length、宽width
 * 3)通过构造方法Rectangle(int width, int length)，
 *   分别给两个属性赋值
 */
public class Rectangle {

    //定义长、宽
    double length,width;

    Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    double getArea(){
        return length*width;
    }
    double getPer(){
        return 2*(length+width);
    }
    void showAll(){
        System.out.println("宽：" + width + "  长：" + length +
                "  面积：" + getArea() + "  周长：" + getPer());
    }
}
