//package com.tencent.wxcloudrun.tasks;
//
//
//import com.tencent.wxcloudrun.service.PicService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.time.LocalDateTime;
//
//@Configuration
//@EnableScheduling
//public class SimItemsTask {
//
//    @Autowired
//    private PicService picService;
//
//    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
//    //或直接指定时间间隔，例如：5秒
//    //@Scheduled(fixedRate=5000)
//    private void configureTasks() {
//        picService.findTopSimPic(1);
//        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
//    }
//
//
//}
