package code.test1;

import java.io.*;


public class Demo02 {

    public static void main(String[] args) {

        File file = new File("D:\\桌面文件\\随写\\abc\\test.txt");

        try {
            OutputStream outputStream = getOutputStream(file);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

            BufferedWriter writer = new BufferedWriter(outputStreamWriter);

            writer.write("白日依山尽，");
            writer.newLine();
            writer.write("黄河入海流，");
            writer.newLine();
            writer.write("欲穷千里目，");
            writer.newLine();
            writer.write("更上一层楼。");

            writer.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }






    }

    private static OutputStream getOutputStream(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }
}
