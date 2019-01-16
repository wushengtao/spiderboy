package com.lunzi.spiderboy.enums;

import java.util.Objects;

/**
 * Created by lunzi on 2018/12/27 3:34 PM
 */
public enum ProtocolTypeEnum {
    HTTPS(1,"HTTPS"),
    HTTP(2,"HTTP");
    private Integer code;
    private String desc;

    ProtocolTypeEnum(Integer code, String desc) {
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
        ProtocolTypeEnum [] protocolTypeEnums=ProtocolTypeEnum.values();
        for(ProtocolTypeEnum protocolTypeEnum:protocolTypeEnums){
            if(Objects.equals(protocolTypeEnum.getDesc(),desc)){
                return protocolTypeEnum.getCode();
            }
        }
        return null;
    }
}
