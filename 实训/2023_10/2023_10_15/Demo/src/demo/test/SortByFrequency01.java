package demo.test;

import java.util.*;

/*
编 写 一 个 程 序 ， 接 受 一 个 字 符 串 ，
将 字 符 串 中 的 字 符 按 照 出 现 的 次 数 进 行 排 序 ，
并 将 排 序 后 的 结 果 存 储 在 一 个 `List<Character>` 集 合 中
 */
public class SortByFrequency01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String input = scanner.nextLine();


        // 创建一个Map来存储字符及其出现次数
        Map<Character,Integer> frequencyMap = new HashMap<>();

        // 遍历输入的字符串，统计每个字符出现的次数
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        //System.out.println(frequencyMap);

        // 创建一个List来存储排序后的字符
        List<Character> sortedList = new ArrayList<>();


        // 将字符添加到List中，按照出现次数排序
        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue())
                .forEachOrdered(x -> sortedList.add(x.getKey()));

        // 输出排序后的字符及其出现次数
        System.out.println("按照出现次数排序的字符及其次数：");
        for (int i = 0; i < sortedList.size(); i++) {
            char c = sortedList.get(i);
            int frequency = frequencyMap.get(c);
            System.out.println(c + " : " + frequency);
        }
    }

}
