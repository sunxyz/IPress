package com.yangrd.ipress.infrastructure.command;

import lombok.Data;

/**
 * PocketCreatedCommand
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Data
public class PocketCreatedCommand {

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 背景图
     */
    private String bg;
}
