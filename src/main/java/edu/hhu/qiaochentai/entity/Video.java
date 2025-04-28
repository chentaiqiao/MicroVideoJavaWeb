package edu.hhu.qiaochentai.entity;

import lombok.Data;

@Data
public class Video {
    private Integer id;
    private String name;
    private String author;
    private String type;
    private String createTime;
    private Integer timeLength;
    private String videoPath;
    private String coverPath;
    private String description;
}
