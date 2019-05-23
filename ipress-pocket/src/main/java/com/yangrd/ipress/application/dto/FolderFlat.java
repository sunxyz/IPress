package com.yangrd.ipress.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * MenuFlat
 *
 * @author yangrd
 * @date 2019/05/18
 */
@Value
public class FolderFlat implements Comparable<FolderFlat> {

    private String id;

    private String levelName;

    private String name;

    private Integer sort;

    private String parentId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createdTime;


    @Override
    public int compareTo(FolderFlat o) {
        if(this.sort.equals(o.sort)){
            return this.createdTime.compareTo(o.createdTime);
        }
        return this.sort.compareTo(o.sort);
    }
}
