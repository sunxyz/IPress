package com.yangrd.ipress.infrastructure.command;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * MenuCreatedCommand
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Data
@Accessors(chain = true)
public class MenuCreatedCommand {

    private String id;

    private String pocketId;

    private String name;

    private Integer sort;

    private String parentId;

    private Integer type;
}
