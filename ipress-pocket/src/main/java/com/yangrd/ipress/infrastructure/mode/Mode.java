package com.yangrd.ipress.infrastructure.mode;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Mode
 *
 * @author yangrd
 * @date 2019/05/13
 */
@Data

@Embeddable
public class Mode {

    @Column(name = "mod_group_name")
    private String groupName;

    @Column(name = "mod_user_name")
    private String userName;

    @Column(name = "mod_group")
    private Integer group;

    @Column(name = "mod_user")
    private Integer user;

    @Column(name = "mod_other")
    private Integer other;

    public boolean hasRead(Integer x) {
        return hasOperation(x, Operation.READ);
    }


    public boolean hasWrite(Integer x) {
        return hasOperation(x, Operation.WRITE);
    }

    public boolean hasExcute(Integer x) {
        return hasOperation(x, Operation.EXCUTE);
    }

    private boolean hasOperation(Integer x, Operation operation) {
        if (Objects.nonNull(x)) {
            if (toBinaryBooleanArray(x)[operation.ordinal()]) {
                return true;
            }
        }
        return false;
    }

    private boolean[] toBinaryBooleanArray(int x) {
        boolean[] m = {false, false, false};
        String str = String.format("%3s", Integer.toBinaryString(5)).replace(" ", "0");
        for (int i = 0; i < 3; i++) {
            if (str.charAt(i) == '1') {
                m[i] = true;
            }
        }
        return m;
    }

}
