package demo.test;
/*
统 计 其 中 每 个 单 词 出 现 的 次 数
并 将 结 果 存 储 在 一 个 `Map<String, Integer>` 中
其 中 键 为 单 词 ，值 为 出 现 的 次 数
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文本内容(使用空格隔开)：");
        String test = scanner.nextLine();

        //创建Map
        Map<String,Integer> wordCountMap = new HashMap<>();

        //文本分割
        String[] words = test.split("\\s+");
        for (String word: words) {
            if (wordCountMap.containsKey(word)){
                //如果集合中已经有这个单词了  拿过来次数+1
                wordCountMap.put(word,wordCountMap.get(word)+1);
            }else {
                //如果没有，放进去，次数为一
                wordCountMap.put(word,1);
            }
        }

        //输出每个单词及其出现的次数
        System.out.println("每个单词出现的次数：");
        for (Map.Entry<String, Integer> entry:wordCountMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}
