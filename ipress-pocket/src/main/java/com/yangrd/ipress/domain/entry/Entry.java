package com.yangrd.ipress.domain.entry;

import com.yangrd.ipress.infrastructure.mode.AbstractModeEntity;
import com.yangrd.ipress.infrastructure.mode.Mode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entry
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Getter
@Setter
@Accessors(chain = true)

@Entity
@Table(name = "p_entry")
@EntityListeners(AuditingEntityListener.class)
public class Entry extends AbstractModeEntity<Entry> {

    /**
     * 文件夹
     */
    private String parentMenuId;

    /**
     * 标题
     */
    private String title;

    /**
     * html内容
     */
    @Lob
    private String htmlContent;

    /**
     * markdown内容
     */
    @Lob
    private String mdContent;




}
