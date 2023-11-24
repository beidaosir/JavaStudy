package code.test5;

public class Car extends Vehicle{
    private int loader;

    public Car(String brand, String color,int loader) {
        super(brand, color);// 调用父类构造方法初始化brand和color属性
        this.loader = loader;
    }

    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }

    @Override
    public void run() {
        System.out.println("这是一辆载人数为 " + loader + " 的" + getColor() + getBrand() + "车");
    }
}
