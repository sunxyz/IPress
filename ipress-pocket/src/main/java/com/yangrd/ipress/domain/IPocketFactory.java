package com.yangrd.ipress.domain;

import com.yangrd.ipress.infrastructure.mode.Mode;
import com.yangrd.ipress.infrastructure.mode.ModeHelper;

/**
 * IPocketFactory
 *
 * @author yangrd
 * @date 2019/05/13
 */
public interface IPocketFactory<T,C> {

    /**
     *　创建对象
     * @param command
     * @param username
     * @return
     */
    T created(C command, String username);


    /**
     * 获取模型
     * @param username
     * @return
     */
    default Mode getMode(String username){
        return ModeHelper.createMode(username);
    }
}
