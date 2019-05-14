package com.yangrd.ipress.infrastructure.mode;

import lombok.Data;

import javax.persistence.Column;
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

    @Column(name = "mod_group_name")
    private String groupName;

    @Column(name = "mod_user_name")
    private String userName;

    @Column(name = "mod_group")
    private Integer group;

    @Column(name = "mod_user")
    private Integer user;

    @Column(name = "mod_other")
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
