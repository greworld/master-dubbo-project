package com.softwore.zgd.partol.controller.annotations;

import java.lang.annotation.*;

/**
 * @author 风骚的GRE
 * @Descriptions 自定义注解：用于登录
 * @date 2018/2/4.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Anonymous {
}

