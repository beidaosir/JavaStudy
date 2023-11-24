package code.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 *    Throwable
 *      -- Error  错误
 *      -- Exception
 *          -- 运行时异常  RuntimeException
 *             编译时无需处理  运行时报错需要检查代码
 *
 *          -- 非运行时异常   编译异常
 *             需要处理
 *                甩锅式  方法上声明  方法的参数列表后面 throws 异常类
 *                背锅式  try catch finally[可以没有]
 *
 *
 *  异常到底从哪儿来？
 *  public Date parse(String source) throws ParseException
 *     {
 *         ParsePosition pos = new ParsePosition(0);
 *         Date result = parse(source, pos);
 *         if (pos.index == 0)
 *             //真正发生异常的地方
 *             throw new ParseException("Unparseable date: \"" + source + "\"" ,
 *                 pos.errorIndex);
 *         return result;
 *     }
 *
 *  方法里面   throw 异常对象   风险本身
 *  方法上声明   throws 异常类型  风险提示
 *
 */
public class Demo01 {

    /*
    甩锅式  在所在的方法上声明异常   throws 异常类型(必须是可能发生的异常类或者它的父类)
          下一个调用该方法的代码还是需要需要处理
     */
    public static void main(String[] args)/* throws ParseException */{

        /*
        常见的异常
         */
//        String str = null;
//        str.charAt(0); //NullPointerException

//        int[] nums = {1,2,3};
//        System.out.println(nums[4]); //ArrayIndexOutOfBoundsException

//        String str = "123";
//        System.out.println(str.charAt(4)); //StringIndexOutOfBoundsException

//        int i = 10/0; //ArithmeticException  数学异常

        /*
        运行时异常
         */
//        Pet p = new Dog();
//        Cat cat = (Cat) p; // ClassCastException  类型转换异常


        String dateStr = "2023-09-20";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        /*
        背锅式： 自己处理
        try{
           存在异常风险的代码
        }catch(异常类 ){
           捕捉到相应的异常会执行
        }catch(异常类){
           捕捉到相应的异常会执行
        }...
        finally{
           最终一定会执行  return也无法截断
           一般会做类似于关闭资源 写日志...
        }
         */
        try {
            //如果没有错误 只执行try块的内容
            simpleDateFormat.parse(dateStr);

            int i = 10/2; //ArithmeticException

            String str = "null";
            str.charAt(1); //NullPointerException

            return;

        } catch (ParseException e) {
            //如果出现ParseException 就执行catch块中的内容
            e.printStackTrace();
            System.out.println("日期解析异常");
        } catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("数学异常");
        } catch (Exception e){
            System.out.println("亲，出现了一点点小小的问题，请稍等");
        } finally {
            //最终一定会执行   return也无法截断
            System.out.println("finally块");
        }

    }

}

class Pet{

}

class Cat extends Pet{

}

class Dog extends Pet{

}
