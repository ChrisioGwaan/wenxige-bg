package com.dangos.ce.vo;

import lombok.Data;

import java.time.Year;

@Data
public class BrandPageVO {

    private String id;

    private String brandName;

    private Year originYear;

    private String comment;

    private String createTime;

    private String modifiedTime;

    private String isLock;

}
