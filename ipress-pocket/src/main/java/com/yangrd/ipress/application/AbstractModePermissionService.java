package com.yangrd.ipress.application;

import com.yangrd.ipress.domain.IPocketFactory;
import com.yangrd.ipress.infrastructure.SecurityUtils;
import com.yangrd.ipress.infrastructure.mode.AbstractModeEntity;
import com.yangrd.ipress.infrastructure.mode.ModePermissionValidate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * IPocketApplicationService
 *
 * @author yangrd
 * @date 2019/05/13
 */

public abstract class AbstractModePermissionService<T extends AbstractModeEntity<T>, C, F extends IPocketFactory<T, C>, D extends JpaRepository<T, String>> {

    F factory;

    D repository;

    /**
     * 保存
     *
     * @param command
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public T save(C command) {
        T entity = factory.created(command, SecurityUtils.getCurrentUsername());
        ModePermissionValidate.validate(entity.getMode(), ModePermissionValidate.Operation.WRITE);
        return repository.save(entity);
    }

    /**
     * 根据id更新
     *
     * @param id
     * @param command
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateById(String id, C command) {
        repository.findById(id).ifPresent(entity -> {
            ModePermissionValidate.validate(entity.getMode(), ModePermissionValidate.Operation.WRITE);
            BeanUtils.copyProperties(command, entity);
        });
    }

    @Autowired
    protected void setFactory(F factory) {
        this.factory = factory;
    }

    @Autowired
    protected void setRepository(D repository) {
        this.repository = repository;
    }
}
