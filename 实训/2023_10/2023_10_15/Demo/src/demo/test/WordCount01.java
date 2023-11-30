package demo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
统 计 其 中 每 个 单 词 出 现 的 次 数
并 将 结 果 存 储 在 一 个 `Map<String, Integer>` 中
其 中 键 为 单 词 ，值 为 出 现 的 次 数
 */
public class WordCount01 {

    public static void main(String[] args) {

        // 创建一个 Scanner 对象用于接收用户输入的文本
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一段文本：");
        String inputText = scanner.nextLine();

        // 调用 countWords 方法统计单词出现次数，并将结果存储在一个 Map 中
        Map<String, Integer> resultMap = countWords(inputText);

        // 输出统计结果
        System.out.println("单词及其出现次数如下：");
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }



    public static Map<String, Integer> countWords(String text) {
        // 创建一个 HashMap 用于存储单词及其出现次数
        Map<String, Integer> wordCountMap = new HashMap<>();

        // 将输入的文本按空格分割成单词数组
        String[] words = text.split(" ");

        // 遍历单词数组，统计每个单词出现的次数
        for (String word : words) {
            // 如果单词已经在 map 中，则将其对应的值加一；否则将其添加到 map 中，值为 1
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // 返回统计结果
        return wordCountMap;
    }

}
