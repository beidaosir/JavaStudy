package cn.neusoft.test1;

import java.util.Arrays;

public class Demo04 {

    public static void main(String[] args) {
        /*4．解析一个邮箱地址是否合法，如果合法则打印出用户名部分和该邮箱所属的网站域名，
        如果邮箱地址不合法则显示不合法的原因
            5.1　提示：邮箱地址不合法的因素：
            5.1.1 邮箱地址中不包含@或.　
            5.1.2 邮箱地址中含有多了@或.　
            5.1.3 邮箱地址中.出现在@的前面
            5.1.4 用户名里有其他字符
            5.2 实现步骤：
            5.2.1 创建一个类，类名：mailtest　*/

        /*
        先用正则测试一下：
           编写一个验证规则   验证某个字符串是否符合这个规则
         */
        String email = "zhangsan1234@163.com";

        //正则表达式  用于验证邮箱
//        String regex = "^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$";

        //字符串.matches(正则表达式)   判断该字符串是否匹配正则的要求
//        boolean matches = email.matches(regex);
//        System.out.println(matches);

        //拆分字符串   根据@或者.
        String[] split = email.split("(@|\\.)");

        System.out.println(Arrays.toString(split));

        if (split.length<3){
            System.out.println("邮箱地址中不包含@或.　");
        }else if(split.length>3){
            System.out.println("邮箱地址中含有多了@或.　");
        }else{

            //找.的下标和@的下标  对比即可

            int index1 = email.indexOf('@');
            int index2 = email.indexOf('.');

            if (index1==-1 || index2==-1){
                System.out.println("没有.或者@");
                return;
            }

            if (index1>index2){
                System.out.println("@在.的后面");
                return;
            }

            String username = split[0]; //用户名   字母或者数字组成   大写字母  'A'~'Z'  小写  'a'~'z'  数字 '0'~'9'

            for (int i = 0; i < username.length(); i++) {
                char c = username.charAt(i);
                //判断用户名的字符在不在大写字母  'A'~'Z'  小写  'a'~'z'  数字 '0'~'9'里面
                //判断某个字符不在该区间  错误
                if(  !(c>='A' && c<='Z')  &&  !(c>='a' && c<='z')  && !(c>='0' && c<='9') ){
                    System.out.println("用户名里有其他字符");
                    return;
                }

            }
            System.out.println("合格："+split[0]+"    "+split[2]);

        }

    }

}
