package com.yangrd.ipress.domain.entry;

import com.yangrd.ipress.domain.IPocketFactory;
import com.yangrd.ipress.infrastructure.IDGenerator;
import com.yangrd.ipress.infrastructure.command.EntryCreatedCommand;
import org.springframework.stereotype.Component;

/**
 * EntryFactory
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Component
public class EntryFactory implements IPocketFactory<Entry, EntryCreatedCommand> {

    @Override
    public Entry created(EntryCreatedCommand command, String username) {
        return new Entry().
                setParentMenuId(command.getParentMenuId()).
                setId(IDGenerator.genId()).
                setSort(command.getSort()).
                setTitle(command.getTitle()).
                setHtmlContent(command.getHtmlContent()).
                setMdContent(command.getMdContent()).
                setMode(getMode(username));
    }
}
