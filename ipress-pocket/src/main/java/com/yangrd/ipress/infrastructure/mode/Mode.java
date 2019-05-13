package com.yangrd.ipress.infrastructure.mode;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Mode
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Data

@Embeddable
public class Mode {

    private String groupName;

    private String userName;

    private Integer group;

    private Integer user;

    private Integer other;

    public boolean hasRead(Integer x){
        if(Objects.nonNull(x)){
            if(x>3){
                return true;
            }
        }
        return false;
    }

    public boolean hasWrite(Integer x){
        if(Objects.nonNull(x)){
            if(x>1){
                return true;
            }
        }
        return false;
    }

    public boolean hasExcute(Integer x){
        if(Objects.nonNull(x)){
            if(x>0){
                return true;
            }
        }
        return false;
    }

}
