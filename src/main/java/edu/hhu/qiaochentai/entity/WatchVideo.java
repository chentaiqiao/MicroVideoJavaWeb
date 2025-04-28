package edu.hhu.qiaochentai.entity;
import lombok.Data;

@Data
public class WatchVideo {
    private Integer id;
    private Integer user_id;
    private Integer video_id ;
    private String user_name;
    private String video_name;

}
