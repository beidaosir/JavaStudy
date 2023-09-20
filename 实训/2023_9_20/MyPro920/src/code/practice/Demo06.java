package cn.neusoft.test1;

public class Demo06 {

    public static void main(String[] args) {
        //．有一个字符串，其中包含英文字符和数字字符，请统计和打印出各个字符的个数。

        String str = "dsaju67327dsjjdksa7832ghdsgaj21681";

        //把不重复的字符串联进来  方便判断哪些字符已经统计过了
        String newStr = "";

        //拿到字符串中每一个字符
        for (int i = 0; i < str.length(); i++) {

            //当前字符
            char current = str.charAt(i);

            //判断newStr中有没有当前字符 有的话后面就不需要再统计了
            int index = newStr.indexOf(current);
            if (index!=-1){
                continue;
            }

            newStr += current;
            System.out.println(newStr);

            int number = 0;
            //循环查找当前字符出现的次数
            for (int j = 0; j < str.length(); j++) {
                if(current == str.charAt(j)){
                    number++;
                }
            }

            System.out.println(current+"出现了"+number+"次");

        }

    }

}
