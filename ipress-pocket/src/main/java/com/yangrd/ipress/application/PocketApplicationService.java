package com.yangrd.ipress.application;

import com.yangrd.ipress.domain.pocket.Pocket;
import com.yangrd.ipress.domain.pocket.PocketFactory;
import com.yangrd.ipress.domain.pocket.PocketRepository;
import com.yangrd.ipress.domain.pocket.PocketSpecification;
import com.yangrd.ipress.infrastructure.SecurityUtils;
import com.yangrd.ipress.infrastructure.command.PocketCreatedCommand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PocketApplicationService
 *
 * @author yangrd
 * @date 2019/05/13
 */

@Service
public class PocketApplicationService extends AbstractModePermissionService<Pocket,PocketCreatedCommand,PocketFactory,PocketRepository> {

    /**
     * 获取当前用户的的pocket
     * @return
     */
    public List<Pocket> listPocketByCurrentUsername(){
        return repository.findAll(PocketSpecification.toSpec(SecurityUtils.getCurrentUsername()));
    }

}
