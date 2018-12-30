package com.lunzi.spiderboy.parse;

import java.io.IOException;

/**
 * 解析html
 * Created by lunzi on 2018/12/21 7:41 PM
 */
public interface Parse {
    /**
     * 自定义规则解析html
     * @return object
     */
    public Object parse(String html) throws IOException;
}
