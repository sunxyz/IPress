package com.yangrd.ipress.domain.pocket;

import com.yangrd.ipress.infrastructure.mode.Mode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Pocket
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Data
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)

@Entity
@Table(name = "p_pocket")
@EntityListeners(AuditingEntityListener.class)
public class Pocket {

    @Id
    @Column(length = 100)
    private String id;

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

    /**
     * 权限模型　chmod linux
     */
    private Mode mode;

    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime lastModifiedTime;

}
