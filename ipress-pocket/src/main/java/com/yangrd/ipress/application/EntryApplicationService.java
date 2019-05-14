package com.yangrd.ipress.application;

import com.yangrd.ipress.domain.entry.Entry;
import com.yangrd.ipress.domain.entry.EntryFactory;
import com.yangrd.ipress.domain.entry.EntryRepository;
import com.yangrd.ipress.infrastructure.command.EntryCreatedCommand;
import com.yangrd.ipress.infrastructure.command.MenuCreatedCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * EntryApplicationService
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Service
public class EntryApplicationService extends AbstractPocketApplicationService<Entry, EntryCreatedCommand, EntryFactory, EntryRepository> {

    @Autowired
    private MenuApplicationService menuApplicationService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Entry create(EntryCreatedCommand command) {
        Entry entry = super.create(command);
        MenuCreatedCommand menuCommand = new MenuCreatedCommand()
                .setName(entry.getTitle()).
                        setParentId(command.getParentMenuId()).
                        setSort(0).
                        setType(1).
                        setId(entry.getId());
        menuApplicationService.create(menuCommand);
        return entry;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(String id, EntryCreatedCommand command) {
        super.update(id, command);
        MenuCreatedCommand menuCommand = new MenuCreatedCommand()
                .setName(command.getTitle()).
                        setParentId(command.getParentMenuId()).
                        setSort(0).
                        setType(1).
                        setId(id);
        menuApplicationService.update(id, menuCommand);
    }
}
