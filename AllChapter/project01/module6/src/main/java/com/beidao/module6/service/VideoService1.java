package com.beidao.module6.service;

import com.beidao.module6.dto.Play;
import com.beidao.module6.dto.Video;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * 从文件中获取视频数据
 */

@Service
public class VideoService1 {



    //调用一次
    public VideoService1(){

    }

    @PostConstruct // 初始化方法  创建对象之后只会调用一次
    public void init(){
        try {
            List<String> data = Files.readAllLines(Path.of("data","p.csv"));
            //String line 就是读到的文件中的每一行数据
            for (String line : data) {
                String[] s = line.split(",");
                //找到视频编号
                    String[] tags = s[7].split("_");
                    /*//获取选集
                    List<Play> list = getPlayList(bv);*/
                    new Video(s[0],s[3], LocalDateTime.parse(s[6]),s[4],s[5], Arrays.asList(tags), getPlayList(s[0]),s[1],s[2]);
                    map.put(s[0],new Video(s[0],s[3], LocalDateTime.parse(s[6]),s[4],s[5], Arrays.asList(tags), getPlayList(s[0]),s[1],s[2]));

            }
        } catch (IOException e) {//把编译异常转换为运行时异常   运行时异常上层不需要强制try-catch
            // RuntimeException 运行时异常
            throw new RuntimeException(e);
        }
    }



    //视频编号作为key，video对象作为value   全局
    Map<String,Video> map = new HashMap<>();

    //调用多次
    //查询方法——根据视频编号查询video对象
    public Video find(String bv){//bv为视频编号

        /*
        List,Map???
         */

        return map.get(bv);

       /* try {
            List<String> data = Files.readAllLines(Path.of("data","p.csv"));

            //String line 就是读到的文件中的每一行数据
            for (String line : data) {
                String[] s = line.split(",");
                if (s[0].equals(bv)) {//找到视频编号
                    String[] tags = s[7].split("_");
                    //获取选集
                    //List<Play> list = getPlayList(bv);
                    return new Video(s[0],s[3], LocalDateTime.parse(s[6]),s[4],s[5], Arrays.asList(tags), getPlayList(bv),s[1],s[2]);
                }
            }
            return null;//没找到就返回null
        } catch (IOException e) {//把编译异常转换为运行时异常   运行时异常上层不需要强制try-catch
            // RuntimeException 运行时异常
            throw new RuntimeException(e);
        }*/

    }

    //查询方法——根据视频编号查询video对象
    private List<Play> getPlayList(String bv)  {
        try {
            //读取选集文件
            List<String> vdata = Files.readAllLines(Path.of("data", "v" +"_"+ bv +".csv"));

            List<Play> list = new ArrayList<>();

            for (String vline : vdata) {
                String[] ss = vline.split(",");
                list.add(new Play(ss[0],ss[1], LocalTime.parse(ss[3]),ss[2]));
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


   /* //查询方法——根据视频编号查询video对象
    public Video find(String bv) throws IOException {//bv为视频编号

        List<String> data = Files.readAllLines(Path.of("data","p.csv"));

        //String line 就是读到的文件中的每一行数据
        for (String line : data) {
            String[] s = line.split(",");
            if (s[0].equals(bv)) {//找到视频编号
                String[] tags = s[7].split("_");
                return new Video(s[0],s[3], LocalDateTime.parse(s[6]),s[4],s[5], Arrays.asList(tags),List.of(),s[1],s[2]);
            }
        }
        return null;//没找到就返回null

    }
*/
}
