package com.yangrd.ipress.application;

import com.yangrd.ipress.domain.IPocketFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

/**
 * IPocketApplicationService
 *
 * @author yangrd
 * @date 2019/05/13
 */

public class AbstractPocketApplicationService<T, C, F extends IPocketFactory<T, C>, D extends JpaRepository<T, String>> {

    @Autowired
    private F factory;

    @Autowired
    private D repository;

    @Transactional(rollbackFor = Exception.class)
    public void create(C command) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        T entity = factory.created(command, username);
        repository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(String id, C command){
        repository.findById(id).ifPresent(entity->{
            BeanUtils.copyProperties(command,entity);
        });
    }

}
