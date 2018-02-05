package com.softwore.zgd.partol.framework.common.utils;

import java.nio.charset.Charset;

/**
 * @author 风骚的GRE
 * @Descriptions 字符集工具类
 * @date 2018/2/4.
 */
public class CharsetUtil {
    protected CharsetUtil() {
		/* 保护 */
    }

    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");
    public static final Charset UTF_16 = Charset.forName("UTF-16");

}
