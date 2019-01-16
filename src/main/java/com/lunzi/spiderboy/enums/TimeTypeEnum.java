package com.lunzi.spiderboy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by lunzi on 2019/1/14 1:44 PM
 */
@AllArgsConstructor
public enum  TimeTypeEnum {
    SECOND(1,"秒"),
    MINUTE(60,"分钟"),
    HOUR(3600,"小时"),
    DAY(86400,"天"),
    WEEK(604800,"周"),
    MONTH(2592000,"月"),
    YEAR(31536000,"年");

    @Getter
    private Integer code;
    @Getter
    private String desc;

}
