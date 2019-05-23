package com.yangrd.ipress.infrastructure.mode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * AbstractModeEntity
 *
 * @author yangrd
 * @date 2019/05/22
 */
@EqualsAndHashCode(of = "id")
@Getter
@MappedSuperclass
public abstract class AbstractModeEntity<T> {
    @Id
    @Column(length = 100)
    private String id;

    /**
     * 权限模型　chmod linux
     */
    private Mode mode;

    @CreatedDate
    private LocalDateTime createdTime;


    @LastModifiedDate
    private LocalDateTime lastModifiedTime;

    public T setId(String id) {
        this.id = id;
        return (T)this;
    }


    public T setMode(Mode mode) {
        this.mode = mode;
        return (T)this;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

}
