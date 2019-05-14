package com.yangrd.ipress.domain.menu;

import com.yangrd.ipress.infrastructure.mode.Mode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Menu
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Data
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)

@Entity
@Table(name = "p_menu")
public class Menu {

    @Id
    @Column(length = 100)
    private String id;

    private String pocketId;

    private String name;

    private Integer sort;

    @Enumerated(EnumType.STRING)
    private MenuType type;

    private String parentId;

    /**
     * 权限模型　chmod linux
     */
    private Mode mode;

    enum MenuType{
        /**
         * 菜单
         */
        MENU,
        /**
         * 文件
         */
        ENTRY;
    }
}
