package code.test4;

/*
在类上声明泛型
在该类中都可以使用
 */
public class MyList<E> {

    Object[] elements;
    int size;//维护元素个数

    public MyList(){
        elements = new Object[10];
    }

    public void add(E element){
        elements[size++] = element;
    }

    public E get(int index){
        return (E)elements[index];
    }


}
