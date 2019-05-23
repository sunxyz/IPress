package com.yangrd.ipress.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * MenuTree
 *
 * @author yangrd
 * @date 2019/05/14
 */
@Data
@EqualsAndHashCode(of = "id")
public class MenuTree implements Comparable<MenuTree>{

    private String name;

    private String id;

    private Set<MenuTree> children = new TreeSet<>();

    @JsonIgnore
    private Integer type;

    @JsonIgnore
    private Integer sort;

    @JsonIgnore
    private String parentId;

    @JsonIgnore
    private LocalDateTime createdTime;


    public Set<MenuTree> getChildren() {
        return type.intValue()==0?children:null;
    }

    public void addChildren(MenuTree children){
       this.children.add(children);
    }

    public boolean presentParent(){
        return Objects.nonNull(parentId);
    }

    public boolean isTopMenu(){
        return !presentParent();
    }

    @Override
    public int compareTo(MenuTree o) {
        if(this.sort.equals(o.sort)){
            return this.createdTime.compareTo(o.createdTime);
        }
        return this.sort.compareTo(o.sort);
    }
}
