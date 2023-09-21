package code.test2;

import java.util.Comparator;

public class StudentComparetor implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int nameResult = o1.getName().compareTo(o2.getName());
        return nameResult==0?o1.getAge() - o2.getAge():nameResult;
    }
}
