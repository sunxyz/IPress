package com.yangrd.ipress.domain.entry;

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
 * Entry
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Data
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)

@Entity
@Table(name = "p_entry")
@EntityListeners(AuditingEntityListener.class)
public class Entry {

    @Id
    @Column(length = 100)
    private String id;


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

    /**
     * 权限模型　chmod linux
     */
    private Mode mode;

    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedDate
    private LocalDateTime lastModifiedTime;
}
