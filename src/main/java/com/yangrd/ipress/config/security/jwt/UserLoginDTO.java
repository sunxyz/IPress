package com.yangrd.ipress.config.security.jwt;

import lombok.Data;

/**
 * UserLoginDTO
 *
 * @author yangrd
 * @date 2019/04/24
 */
@Data
public class UserLoginDTO {

    private String username;

    private String password;
}
