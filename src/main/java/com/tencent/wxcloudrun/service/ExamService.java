package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.ExamResultDto;
import com.tencent.wxcloudrun.model.Exam;

import java.util.List;

public interface ExamService {

    List<Exam> findExamByExamId(Integer examId, Integer userId, Integer familiar);


    ExamResultDto findExamByExamResultId(Integer examId, Integer userId, Integer familiar, String content);
}
