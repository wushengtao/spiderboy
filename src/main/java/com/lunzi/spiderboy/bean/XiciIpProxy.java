package com.lunzi.spiderboy.bean;

import com.lunzi.spiderboy.enums.TimeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

/**
 * Created by lunzi on 2019/1/14 9:28 AM
 */
@Data
@ToString
@Slf4j
public class XiciIpProxy extends IpProxy{
    private Integer anonymousType;//匿名
    private Integer protocolType;//http,https
    private Double speed;//速度
    private Double connectTime;//连接时间
    private String surviveTime;//存活时间


    @Builder
    public XiciIpProxy(String ip, Integer port, Integer anonymousType, Integer protocolType, Double speed, Double connectTime, String surviveTime) {
        super(ip, port);
        this.anonymousType = anonymousType;
        this.protocolType = protocolType;
        this.speed = speed;
        this.connectTime = connectTime;
        this.surviveTime = surviveTime;
    }

    public Long convertSurviveTime(String surviveTime){
        log.info("存活时间转换成秒,surviveTime={}",surviveTime);
        //抓来的数据格式可能有问题，try一下
        //先获取其中的数字
        Pattern pattern = Pattern.compile("[^0-9]");
        String time=pattern.matcher(surviveTime).replaceAll("");
        try{
            for (TimeTypeEnum typeEnum:TimeTypeEnum.values()){
                if(surviveTime.contains(typeEnum.getDesc())){
                    Long num=Long.valueOf(time);
                    return num*typeEnum.getCode();
                }
            }
        }catch (Exception e){
            log.error("数据格式转换异常,e=",e);
            return -1L;
        }
        return -1L;
    }

    @Override
    public String toString() {
        return "XiciIpProxy{" +
                "ip"+super.getIp()+
                "port"+super.getPort()+
                "anonymousType=" + anonymousType +
                ", protocolType=" + protocolType +
                ", speed=" + speed +
                ", connectTime=" + connectTime +
                ", surviveTime='" + surviveTime + '\'' +
                '}';
    }
}
