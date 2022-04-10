package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Exam;

import java.util.List;

public interface ExamService {

    List<Exam> findExamByExamId(Integer examId, Integer userId, Integer familiar);
}
