package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.ShareLog;
import lombok.Data;

import java.util.List;

@Data
public class ShareLogListDto {


    private List<ShareLog> logs;

    private int count;
}
