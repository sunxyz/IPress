package com.yangrd.ipress.domain.pocket;

import com.github.wenhao.jpa.Specifications;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

/**
 * PocketSpec
 *
 * @author yangrd
 * @date 2019/05/22
 */
public class PocketSpecification {

    public static Specification<Pocket> toSpec(String username){
        return Specifications.<Pocket>and().eq(Objects.nonNull(username),"mode.userName",username).build();
    }
}
