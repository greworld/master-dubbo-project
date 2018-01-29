package com.greworld.framework.velocity.directive;

import org.apache.velocity.runtime.directive.Parse;

/**
 * @author 风骚的GRE
 * @Description TODO
 * @date 2018/1/29.
 */
public class ExtendsDirective extends Parse {
    @Override
    public String getName() {
        return "extends";
    }
}
