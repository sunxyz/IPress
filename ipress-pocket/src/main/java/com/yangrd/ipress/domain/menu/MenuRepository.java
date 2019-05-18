package com.yangrd.ipress.domain.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * MenuRepository
 *
 * @author yangrd
 * @date 2019/05/13
 */
public interface MenuRepository extends JpaRepository<Menu,String>, JpaSpecificationExecutor<Menu> {
}
