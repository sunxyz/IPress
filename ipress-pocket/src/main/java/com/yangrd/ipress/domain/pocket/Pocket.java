package com.yangrd.ipress.domain.pocket;

import com.yangrd.ipress.infrastructure.mode.AbstractModeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * Pocket
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Getter
@Setter
@Accessors(chain = true)

@Entity
@Table(name = "p_pocket")
@EntityListeners(AuditingEntityListener.class)
public class Pocket extends AbstractModeEntity<Pocket> {

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
