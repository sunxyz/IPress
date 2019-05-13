package com.yangrd.ipress.domain.pocket;

import com.yangrd.ipress.domain.IPocketFactory;
import com.yangrd.ipress.infrastructure.IDGenerator;
import com.yangrd.ipress.infrastructure.command.PocketCreatedCommand;
import org.springframework.stereotype.Component;

/**
 * PocketFactory
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Component
public class PocketFactory implements IPocketFactory<Pocket, PocketCreatedCommand> {

    @Override
    public Pocket created(PocketCreatedCommand command, String username) {
        return new Pocket().
                setId(IDGenerator.genId()).
                setName(command.getName()).
                setDescription(command.getDescription()).
                setBg(command.getBg()).
                setMode(getMode(username));
    }
}
