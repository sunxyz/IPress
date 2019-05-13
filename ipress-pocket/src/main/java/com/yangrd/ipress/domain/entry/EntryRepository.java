package com.yangrd.ipress.domain.entry;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EntryRepository
 *
 * @author yangrd
 * @date 2019/05/13
 */
public interface EntryRepository extends JpaRepository<Entry,String> {
}
