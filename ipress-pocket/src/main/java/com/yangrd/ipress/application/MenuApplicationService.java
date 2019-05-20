package com.yangrd.ipress.application;

import com.yangrd.ipress.application.dto.FolderFlat;
import com.yangrd.ipress.application.dto.MenuTree;
import com.yangrd.ipress.domain.menu.Menu;
import com.yangrd.ipress.domain.menu.MenuFactory;
import com.yangrd.ipress.domain.menu.MenuRepository;
import com.yangrd.ipress.domain.menu.MenuSpecification;
import com.yangrd.ipress.infrastructure.IDGenerator;
import com.yangrd.ipress.infrastructure.command.MenuCreatedCommand;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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
        return super.create(command);
    }

    public Set<MenuTree> listTree() {
        return buildMenuTree(repository.findAll());
    }


    public List<FolderFlat> listFolderFlat() {
        List<FolderFlat> list = new ArrayList<>();
        flat(listFolderTree(), list, 0);
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(String id){
        repository.deleteById(id);
    }

    private Set<MenuTree> listFolderTree() {
        return buildMenuTree(repository.findAll(MenuSpecification.toSpec(Menu.MenuType.FOLDER)));
    }

    private void flat(Set<MenuTree> trees, List<FolderFlat> list, Integer level) {
        for (MenuTree tree : trees) {
            FolderFlat folderFlat = new FolderFlat(tree.getId(), prefix(level) + tree.getName(), tree.getName(), tree.getSort(), tree.getParentId(), tree.getCreatedTime());
            list.add(folderFlat);
            int level1 = level;
            if (!tree.getChildren().isEmpty()) {
                flat(tree.getChildren(), list, ++level1);
            }
        }
    }

    private String prefix(Integer level) {
        String prefix = "";
        for (int i = 0; i < level; i++) {
            prefix += "-";
        }
        return prefix;
    }


    private Set<MenuTree> buildMenuTree(List<Menu> menus) {
        Set<MenuTree> menuTrees = mapSet(menus);
        Map<String, MenuTree> menuTreeMap = menuTrees.stream().collect(Collectors.toMap(MenuTree::getId, Function.identity()));
        menuTrees.forEach(menuTree -> {
            if (menuTree.presentParent()) {
                menuTreeMap.get(menuTree.getParentId()).addChildren(menuTree);
            }
        });
        return new TreeSet<>(menuTrees.stream().filter(MenuTree::isTopMenu).collect(Collectors.toSet()));
    }

    private Set<MenuTree> mapSet(List<Menu> menus) {
        return new TreeSet<>(menus.stream().map(menu -> {
            MenuTree menuTree = new MenuTree();
            menuTree.setType(menu.getType().ordinal());
            BeanUtils.copyProperties(menu, menuTree);
            return menuTree;
        }).collect(Collectors.toSet()));
    }
}
