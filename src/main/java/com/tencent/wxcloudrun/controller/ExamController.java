package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ExamListDto;
import com.tencent.wxcloudrun.dto.ExamResultDto;
import com.tencent.wxcloudrun.dto.ReviewListDto;
import com.tencent.wxcloudrun.model.Exam;
import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.service.ExamService;
import com.tencent.wxcloudrun.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {

    final ExamService examService;
    final Logger logger;

    public ExamController(@Autowired ExamService examService) {
        this.examService = examService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    /**
     * 根据book 获取Reviwe内容
     * @return API response json
     */
    @GetMapping(value = "/api/findExamByExamId")
    ApiResponse findExamByExamId(Integer examId, Integer userId, Integer familiar) {
        logger.info("/api/findReviewByBookId examId:" + examId + "userId:" + userId + ",familiar:" + familiar);
        List<Exam> result = examService.findExamByExamId(examId, userId, familiar);
        ExamListDto dto = new ExamListDto();
        dto.setExams(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }

    /**
     * 根据book 获取Reviwe内容
     * @return API response json
     */
    @GetMapping(value = "/api/findExamByExamResultId")
    ApiResponse findExamByExamResultId(Integer examId, Integer userId, Integer familiar, String content) {
        logger.info("/api/findReviewByBookId examId:" + examId + "userId:" + userId + ",familiar:" + familiar);
        logger.info("/api/findReviewByBookId content:" + content);
        ExamResultDto result = examService.findExamByExamResultId(examId, userId, familiar, content);
        return ApiResponse.ok(result);
    }

}
