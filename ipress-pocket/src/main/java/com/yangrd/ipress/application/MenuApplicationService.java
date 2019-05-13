package com.yangrd.ipress.application;

import com.yangrd.ipress.domain.menu.Menu;
import com.yangrd.ipress.domain.menu.MenuFactory;
import com.yangrd.ipress.domain.menu.MenuRepository;
import com.yangrd.ipress.infrastructure.command.MenuCreatedCommand;
import org.springframework.stereotype.Service;

/**
 * MenuApplicationService
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Service
public class MenuApplicationService extends AbstractPocketApplicationService<Menu, MenuCreatedCommand, MenuFactory, MenuRepository> {

    @Override
    public Menu create(MenuCreatedCommand command) {
        command.setType(0);
        return super.create(command);
    }
}
