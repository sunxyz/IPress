package com.yangrd.ipress.infrastructure.mode;

import com.yangrd.ipress.ex.ModePermissionException;
import com.yangrd.ipress.infrastructure.SecurityUtils;

/**
 * ModePermissionValidate
 *
 * @author yangrd
 * @date 2019/05/22
 */
public class ModePermissionValidate {

    public enum Operation {
        /**
         * 读
         */
        READ,
        /**
         * 写
         */
        WRITE,
        /**
         * 执行
         */
        EXCUTE
    }

    public static void validate(Mode mode, Operation operation) {
        if (mode.getUserName().equals(SecurityUtils.getCurrentUsername())) {
            switch (operation) {
                case READ:
                    if (mode.hasRead(mode.getUser())) {
                        return;
                    }
                case WRITE:
                    if (mode.hasWrite(mode.getUser())) {
                        return;
                    }
                case EXCUTE:
                    if (mode.hasExcute(mode.getUser())) {
                        return;
                    }
                default:
                    throw new ModePermissionException();
            }
        } else {
            throw new ModePermissionException();
        }
    }
}
