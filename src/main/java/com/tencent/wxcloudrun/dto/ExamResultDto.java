package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.Exam;
import lombok.Data;

import java.util.List;

@Data
public class ExamResultDto {


    private List<Exam> exams;

    private int count;

    private int score;

    private int totalScore;

}
