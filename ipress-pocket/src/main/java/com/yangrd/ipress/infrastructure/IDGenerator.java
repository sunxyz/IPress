package com.yangrd.ipress.infrastructure;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

/**
 * IDGenerator
 *
 * @author yangrd
 * @date 2019/05/13
 */
public class IDGenerator {

    public static String genId(){
        Calendar cal = Calendar.getInstance();
        return DateFormatUtils.format(cal, "yyyyMMddHHmmss", TimeZone.getDefault())+UUID.randomUUID().toString().toLowerCase().substring(0,8);
    }
}
