package com.yangrd.ipress.application;

import com.yangrd.ipress.domain.entry.Entry;
import com.yangrd.ipress.domain.entry.EntryFactory;
import com.yangrd.ipress.domain.entry.EntryRepository;
import com.yangrd.ipress.domain.menu.MenuRepository;
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
public class EntryApplicationService extends AbstractModePermissionService<Entry, EntryCreatedCommand, EntryFactory, EntryRepository> {

    @Autowired
    private MenuApplicationService menuApplicationService;

    @Autowired
    private MenuRepository menuRepository;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public Entry save(EntryCreatedCommand command) {
        Entry entry = super.save(command);
        MenuCreatedCommand menuCommand = new MenuCreatedCommand()
                .setName(entry.getTitle()).
                        setParentId(command.getParentMenuId()).
                        setPocketId(command.getPocketId()).
                        setSort(command.getSort()).
                        setType(1).
                        setId(entry.getId());
        menuApplicationService.save(menuCommand);
        return entry;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateById(String id, EntryCreatedCommand command) {
        super.updateById(id, command);
        MenuCreatedCommand menuCommand = new MenuCreatedCommand()
                .setName(command.getTitle()).
                        setParentId(command.getParentMenuId()).
                        setSort(0).
                        setType(1).
                        setId(id);
        menuApplicationService.updateById(id, menuCommand);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(String id){
        repository.deleteById(id);
        menuRepository.deleteById(id);
    }
}
