package com.beidao.module6.controller;


import com.beidao.module6.dto.Play;
import com.beidao.module6.dto.Video;
import com.beidao.module6.service.VideoService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
public class VideoController {


    /**
     * 路径参数
     * 1.RequestMapping("/video/{id}")
     * @PathVariable("id") String id 路径参数  @PathVariable表示参数要从路径中获取
     * @return
     */

    @RequestMapping("/video/{bv}")
    @ResponseBody
    public Video t(@PathVariable String bv)  {

        return videoService1.find(bv);

   /*     if (bv.equals("1")){

            List<Play> playList =List.of(
                    new Play("P1","二分查找_演示", LocalTime.parse("00:05:46"),"1_1.mp4"),
                    new Play("P2","二分查找_实现", LocalTime.parse("00:06:47"),"1_2.mp4")
            );

            return new Video("1","面试专题-基础篇", LocalDateTime.now(),"1.png","祝你面试顺利，拿满offer!",
                    List.of("Java","面试","计算机","数据结构"),playList,"自制","科技->计算机科学与技术");

        }


        if (bv.equals("2")){
            List<Play> playList = List.of(
                    new Play("P1","java中的线程状态演示1", LocalTime.parse("00:09:45"),"2_1.mp4"),
                    new Play("P2","java中的线程状态演示2", LocalTime.parse("00:07:05"),"2_2.mp4"),
                    new Play("P3","java中的线程状态演示3", LocalTime.parse("00:05:01"),"2_3.mp4")

            );
            return new Video("2","面试专题-并发篇", LocalDateTime.now(),"2.png","祝你面试顺利，拿满offer!",
                    List.of("Java","面试","计算机","数据结构"),playList,"自制","科技->计算机科学与技术");
        }


        return null;*/

    }


    @Autowired
    private VideoService1 videoService1;


/*

    @RequestMapping("/video/1")
    @ResponseBody
    public Video t1(){

        List<Play> playList = List.of(
                new Play("P1","二分查找_演示", LocalTime.parse("00:05:46"),"1_1.mp4"),
                new Play("P2","二分查找_实现", LocalTime.parse("00:06:47"),"1_2.mp4")
        );


        return new Video("1","面试专题-基础篇", LocalDateTime.now(),"1.png","祝你面试顺利，拿满offer!",
                List.of("Java","面试","计算机","数据结构"),playList,"自制","科技->计算机科学与技术");

    }

    @RequestMapping("/video/2")
    @ResponseBody
    public Video t2(){

        List<Play> playList = List.of(
                new Play("P1","java中的线程状态演示1", LocalTime.parse("00:09:45"),"2_1.mp4"),
                new Play("P2","java中的线程状态演示2", LocalTime.parse("00:07:05"),"2_2.mp4"),
                new Play("P3","java中的线程状态演示3", LocalTime.parse("00:05:01"),"2_3.mp4")

        );


        return new Video("2","面试专题-并发篇", LocalDateTime.now(),"2.png","祝你面试顺利，拿满offer!",
                List.of("Java","面试","计算机","数据结构"),playList,"自制","科技->计算机科学与技术");
    }
*/

}
