package com.yangrd.ipress.application;

import com.yangrd.ipress.application.dto.MenuTree;
import com.yangrd.ipress.domain.menu.Menu;
import com.yangrd.ipress.domain.menu.MenuFactory;
import com.yangrd.ipress.domain.menu.MenuRepository;
import com.yangrd.ipress.infrastructure.command.MenuCreatedCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public List<MenuTree> listTree() {
        List<MenuTree> menuTrees = mapList(repository.findAll());
        Map<String, MenuTree> menuTreeMap = menuTrees.stream().collect(Collectors.toMap(MenuTree::getId, Function.identity()));
        menuTrees.forEach(menuTree -> {
            if (menuTree.presentParent()) {
                menuTreeMap.get(menuTree.getParentId()).addChildren(menuTree);
            }
        });
        return menuTrees.stream().filter(MenuTree::isTopMenu).collect(Collectors.toList());
    }

    private List<MenuTree> mapList(List<Menu> menus) {
        return menus.stream().map(menu -> {
            MenuTree menuTree = new MenuTree();
            BeanUtils.copyProperties(menu, menuTree);
            return menuTree;
        }).collect(Collectors.toList());
    }
}
