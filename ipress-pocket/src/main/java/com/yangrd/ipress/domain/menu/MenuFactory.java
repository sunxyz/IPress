package com.yangrd.ipress.domain.menu;

import com.yangrd.ipress.domain.IPocketFactory;
import com.yangrd.ipress.infrastructure.command.MenuCreatedCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * MenuFactory
 *
 * @author yangrd
 * @date 2019/05/13
 */
@AllArgsConstructor

@Component
public class MenuFactory implements IPocketFactory<Menu, MenuCreatedCommand> {

    @Override
    public Menu created(MenuCreatedCommand command, String username) {
        if (command.getType() < 0 && command.getType() >= Menu.MenuType.values().length) {
            throw new IndexOutOfBoundsException("");
        }
        Menu.MenuType menuType = Stream.of(Menu.MenuType.values()).filter(type ->
                type.ordinal() == command.getType()
        ).findFirst().orElse(null);
        return new Menu().
                setId(command.getId()).
                setPocketId(command.getPocketId()).
                setName(command.getName()).
                setSort(command.getSort()).
                setParentId(command.getParentId()).
                setType(menuType).
                setMode(getMode(username));
    }
}
