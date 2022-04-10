package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamMapper {

    List<Exam> findExamByExamId(Exam exam);
}
