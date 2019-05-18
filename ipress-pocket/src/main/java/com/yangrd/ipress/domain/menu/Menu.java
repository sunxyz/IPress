package com.yangrd.ipress.domain.menu;

import com.yangrd.ipress.infrastructure.mode.Mode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

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
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    /**
     * 权限模型　chmod linux
     */
    private Mode mode;

    public enum MenuType{
        /**
         * 菜单
         */
        FOLDER,
        /**
         * 文件
         */
        ENTRY;
    }
}
