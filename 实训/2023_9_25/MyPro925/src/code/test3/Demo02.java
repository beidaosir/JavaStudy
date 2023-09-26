package code.test3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Demo02 {

    public static void main(String[] args) {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("对象流.txt"));

            ArrayList<Student>studentArrayList = (ArrayList<Student>) objectInputStream.readObject();
            for (Student student:
                 studentArrayList) {
                System.out.println(student.getNumber()+"\t"+student.getName()+"\t"+ student.getScore());
            }


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
