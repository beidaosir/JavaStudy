package code.test1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo02 {

    public static void main(String[] args) {

        Reader reader;

        try {
            reader = new FileReader("D:\\桌面文件\\随写\\英语.md");

            int c = 0;
            while ((c = reader.read()) != -1 ) {
                System.out.print((char) c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
