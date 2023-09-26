package code.test2;

import java.io.Serializable;

/**
 * 要将Food类型的对象写入到文件中，需要对其进行序列化
 * Food类实现接口Serializable
 */
public class Food implements Serializable{

    private Integer number;
    private String name;
    private Double price;

    public Food() {
    }

    public Food(Integer number, String name, Double price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
