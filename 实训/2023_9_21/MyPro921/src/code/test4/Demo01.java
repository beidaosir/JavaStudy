package code.test4;


public class Demo01 {

    public static void main(String[] args) {

        MyList<Student> myList = new MyList<>();
        myList.add(new Student("张三", 20));
        myList.add(new Student("李四", 20));
        myList.add(new Student("王五", 20));
        myList.add(new Student("赵六", 20));

        Student student = myList.get(2);
        System.out.println(student.getName().charAt(0));


    }
}
