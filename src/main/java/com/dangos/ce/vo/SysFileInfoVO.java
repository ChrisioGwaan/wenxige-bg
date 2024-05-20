package com.dangos.ce.vo;

import lombok.Data;

@Data
public class SysFileInfoVO {

    private Long id;

    private String fileName;

    private String bucketName;

    private String path;

    private String type;

    private Long size;

    private String url;

}
