package com.yangrd.ipress.application;

import com.yangrd.ipress.domain.pocket.Pocket;
import com.yangrd.ipress.domain.pocket.PocketFactory;
import com.yangrd.ipress.domain.pocket.PocketRepository;
import com.yangrd.ipress.infrastructure.command.PocketCreatedCommand;
import org.springframework.stereotype.Service;

/**
 * PocketApplicationService
 *
 * @author yangrd
 * @date 2019/05/13
 */

@Service
public class PocketApplicationService extends AbstractPocketApplicationService<Pocket,PocketCreatedCommand,PocketFactory,PocketRepository>{

}
