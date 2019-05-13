package com.yangrd.ipress.infrastructure.mode;

/**
 * ModeHelper
 *
 * @author yangrd
 * @date 2019/05/13
 */
public class ModeHelper {

    public static Mode createMode(String username){
        Mode mode = new Mode();
        mode.setGroupName(username);
        mode.setUserName(username);
        mode.setGroup(7);
        mode.setUser(7);
        mode.setOther(7);
        return mode;
    }

}
