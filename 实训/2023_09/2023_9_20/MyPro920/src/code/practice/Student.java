package cn.neusoft.test1;

public class Student {

    private int number;
    private String name;

    public Student() {
    }

    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        //如果是同一个对象 直接返回true
        if(this == obj){
            return true;
        }
        //看类型  obj不是Student类型没有比较的必要性
        if(obj instanceof Student){
            //强转成本身的Student类型
            Student otherStu = (Student)obj;
            //开始比较
            //比较name属性
            boolean nameEquals = this.name.equals(otherStu.name);
            //比较number属性
//            boolean numberEquals = this.number == otherStu.number;

            //name比较返回true再比较number，name比较返回false结果就是false
            return nameEquals?this.number == otherStu.number:nameEquals;
        }
        return false;
    }
}
