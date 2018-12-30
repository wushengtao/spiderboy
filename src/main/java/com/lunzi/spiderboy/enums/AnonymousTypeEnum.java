package com.lunzi.spiderboy.enums;

import java.util.Objects;

/**
 * Created by lunzi on 2018/12/25 11:25 AM
 */
public enum  AnonymousTypeEnum{
    ANONYMOUS(1,"高匿"),
    Transparency(2,"透明");
    private Integer code;
    private String desc;

    AnonymousTypeEnum(Integer code, String desc) {
        this.code=code;
        this.desc=desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static  Integer getCodeByDesc(String desc){
        AnonymousTypeEnum [] anonymousTypeEnums=AnonymousTypeEnum.values();
        for(AnonymousTypeEnum anonymousTypeEnum:anonymousTypeEnums){
            if(Objects.equals(anonymousTypeEnum.getDesc(),desc)){
                return anonymousTypeEnum.getCode();
            }
        }
        return null;
    }
}
