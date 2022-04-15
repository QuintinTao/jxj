package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ExamMapper;
import com.tencent.wxcloudrun.model.Exam;
import com.tencent.wxcloudrun.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ExamServiceImpl implements ExamService {

    public static final String sb = "_";

    final ExamMapper examMapper;

    public ExamServiceImpl(@Autowired ExamMapper examMapper) {
        this.examMapper = examMapper;
    }
    @Override
    public List<Exam> findExamByExamId(Integer examId, Integer userId, Integer familiar) {
        if(familiar == null) familiar = 0;
        int replaceIndex = 0;
        Exam exam = new com.tencent.wxcloudrun.model.Exam();
        exam.setExamId(examId);
        exam.setUserId(userId);
        List<Exam> exams = examMapper.findExamByExamId(exam);
        if(familiar == 2){//熟悉 2/替换
            replaceIndex = 3;
        } else if(familiar == 1){ //模糊 4替换1
            replaceIndex = 5;
        } else { //不清楚，就不替换了
            return exams;
        }
        for (Exam examBean:
                exams) {
            examBean.setContent(extractContent(examBean.getContent(), replaceIndex));
        }
        return exams;
    }


    @Override
    public List<Exam> findExamByExamResultId(Integer examId, Integer userId, Integer familiar, String content) {
        if(familiar == null) familiar = 0;
        int replaceIndex = 0;
        Exam exam = new com.tencent.wxcloudrun.model.Exam();
        exam.setExamId(examId);
        exam.setUserId(userId);
        List<Exam> exams = examMapper.findExamByExamId(exam);
        if(familiar == 2){//熟悉 2/替换
            replaceIndex = 3;
        } else if(familiar == 1){ //模糊 4替换1
            replaceIndex = 5;
        } else { //不清楚，就不替换了
            return exams;
        }
        for (Exam examBean:
                exams) {
            examBean.setContent(getResult(examBean.getContent(), replaceIndex));
        }
        return exams;
    }

    private String extractContent(String str, int replaceIndex){
        if(str != null) {
            int i = replaceIndex;
            while (i < str.length()){
                String target = str.substring(i, i + 1);
                if(target.equals("，")|| target.equals("。")){
                    if(i + 2 < str.length()){
                        str = str.replace(str.substring(i + 1, i + 2), sb);
                    } else {
                        break;
                    }

                } else {
                    str = str.replace(target, sb);
                }
                i = i + replaceIndex;
            }
        }
        System.out.println("final---" + str);
        return str;
    }

    private String getResult(String str, int replaceIndex){
        String result = "";
        if(str != null) {
            int i = replaceIndex;
            while (i < str.length()){
                String target = str.substring(i, i + 1);
                if(target.equals("，")|| target.equals("。")){
                    if(i + 2 < str.length()){
                        result += str.substring(i + 1, i + 2) + ",";
                    } else {
                        break;
                    }

                } else {
                    result += target + ",";
                }
                i = i + replaceIndex;
            }
        }
        System.out.println("final str---" + str);
        System.out.println("final result---" + result);
        return result;
    }

//    public static void main(String[] args) {
//        ExamServiceImpl ex = new ExamServiceImpl();
//        ex.getResult("避之有时，恬淡虚无，真气从之，精神内守，病安从来", 2);
//        ex.extractContent("避之有时，恬淡虚无，真气从之，精神内守，病安从来", 2);
//    }
}
