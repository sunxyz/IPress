package com.yangrd.ipress.infrastructure.command;

import lombok.Data;

/**
 * MenuCreatedCommand
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Data
public class MenuCreatedCommand {

    private String pocketId;

    private String name;

    private Integer sort;

    private String parentId;

    private Integer type;
}
