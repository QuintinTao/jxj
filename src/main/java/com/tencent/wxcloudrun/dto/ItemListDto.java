package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.Item;
import lombok.Data;

import java.util.List;
@Data
public class ItemListDto {


    private List<Item> items;

    private int count;
}
