package com.yangrd.ipress.infrastructure;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * SecurityUtils
 *
 * @author yangrd
 * @date 2019/05/22
 */
public class SecurityUtils {

    public static String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
