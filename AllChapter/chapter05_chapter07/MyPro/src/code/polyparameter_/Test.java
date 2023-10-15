package code.polyparameter_;

public class Test {
    public static void main(String[] args) {

        Worker tom = new Worker("Tom", 3000);
        Manager jack = new Manager("Jack", 5000, 30000);
        Test test = new Test();
        test.showEmpAnnual(tom);
        test.showEmpAnnual(jack);

        test.testWork(tom);
        test.testWork(jack);
    }

    //实现获取员工对象的年工资 在main中调用该方法【employee.getAnnual()】
    public void showEmpAnnual(Employee employee){
        System.out.println(employee.getAnnual());//动态绑定机制
    }

    public void testWork(Employee employee){
        if (employee instanceof Worker){
            ((Worker) employee).work();//向下转型

        } else if (employee instanceof Manager) {
            ((Manager) employee).manage();//向下转型
        }else {
            System.out.println("不做处理...");
        }

    }
}
