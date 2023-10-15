package code.override;

public class OverrideExercise {

    public static void main(String[] args) {
        Person person = new Person("jack", 10);
        System.out.println(person.say());

        Student student = new Student("tom",19,123456,59.5);
        System.out.println(student.say());
    }
}

