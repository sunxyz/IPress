package com.yangrd.ipress.domain.pocket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * PocketRepository
 *
 * @author yangrd
 * @date 2019/05/13
 */
public interface PocketRepository extends JpaRepository<Pocket, String>, JpaSpecificationExecutor<Pocket> {
}
