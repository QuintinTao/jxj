package com.tencent.wxcloudrun.model;

import lombok.Data;

public class Pic {

    private Integer id;

    private Integer cid;

    private Integer material;

    private Integer colorSys;

    private Integer season;

    private String picUrl;

    private String title;

    private String materialStr;

    private String colorSysStr;

    private String seasonStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMaterial() {
        return material;
    }
    // 1 纱  2棉  3 麻 4毛  5涤 6 皮
    public void setMaterial(Integer material) {
        this.material = material;
        switch (material){
            case 1: this.setMaterialStr("纱");
            break;
            case 2: this.setMaterialStr("棉");
            break;
            case 3: this.setMaterialStr("麻");
            break;
            case 4: this.setMaterialStr("毛");
            break;
            case 5: this.setMaterialStr("涤");
            break;
            case 6: this.setMaterialStr("皮");
            break;
        }
    }

    public Integer getColorSys() {
        return colorSys;
    }

    public void setColorSys(Integer colorSys) {
        this.colorSys = colorSys;
        switch (colorSys){
            case 1: this.setColorSysStr("冷色");
                break;
            case 2: this.setColorSysStr("中色");
                break;
            case 3: this.setColorSysStr("暖色");
                break;
        }
    }

    public Integer getSeason() {
        return season;
    }
    //1:  summer  2: spring 3: autumn 4: winter
    public void setSeason(Integer season) {
        this.season = season;
        switch (season){
            case 1: this.setSeasonStr("夏季");
                break;
            case 2: this.setSeasonStr("秋季");
                break;
            case 3: this.setSeasonStr("春季");
                break;
            case 4: this.setSeasonStr("冬季");
                break;
        }
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaterialStr() {
        return materialStr;
    }

    public void setMaterialStr(String materialStr) {
        this.materialStr = materialStr;
    }

    public String getColorSysStr() {
        return colorSysStr;
    }

    public void setColorSysStr(String colorSysStr) {
        this.colorSysStr = colorSysStr;
    }

    public String getSeasonStr() {
        return seasonStr;
    }

    public void setSeasonStr(String seasonStr) {
        this.seasonStr = seasonStr;
    }

}
