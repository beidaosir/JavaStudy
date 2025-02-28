package com.beidao.module4;

public class TestPhone {

    public static void main(String[] args) {
        Phone phone1 = new Phone("iphone1", "512g", "6.1寸", "白色", 9999);
        Phone phone2 = new Phone("iphone2", "215g", "6.7寸", "black", 8888);
        Phone phone3 = new Phone("iphone3", "300g", "6.7寸", "red", 7890);


        System.out.println(phone1.brand);
        System.out.println(phone1.price);
        System.out.println(phone1.color);
        System.out.println(phone1.size);
        System.out.println(phone1.memory);





    }

}
