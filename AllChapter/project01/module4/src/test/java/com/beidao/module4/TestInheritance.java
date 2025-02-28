package com.beidao.module4;


/**
 * 测试继承
 * @author beidao
 *
 */
public class TestInheritance {

    public static void main(String[] args) {

        A a = new A("张三");
        B b = new B("李四");
        C c = new C("王五");


		a.test();
        System.out.println(a.name);

		b.test();
        System.out.println(b.name);

		c.test();
        System.out.println(c.name);

	}
}


class A {
    String name;

    /**
     * 构造方法
     * @param name
     */
    /*
    带参数的构造方法不能继承
     */
    public A(String name) {
        this.name = name;
    }

    void test() {
		System.out.println("父类测试方法");
	}
}
class B extends A {

    B(String name) {
        // 调用父类的构造方法
        super(name);
    }


	void test() {
		System.out.println("子类B测试方法");
	}
}

class  C extends A {

    /**
     * 构造方法
     *
     * @param name
     */
    public C(String name) {
        super(name);
    }
}


