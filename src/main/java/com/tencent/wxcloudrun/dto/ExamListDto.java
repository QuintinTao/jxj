package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.Exam;
import lombok.Data;

import java.util.List;

@Data
public class ExamListDto {


    private List<Exam> exams;

    private int count;
}
