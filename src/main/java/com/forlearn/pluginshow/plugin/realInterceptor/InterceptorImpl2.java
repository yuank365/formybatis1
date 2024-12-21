package com.forlearn.pluginshow.plugin.realInterceptor;

import com.forlearn.pluginshow.plugin.Interceptor;

/**
 * @author yuank
 * @version 1.0.0
 * @date 2024/12/21 9:57:49
 */
public class InterceptorImpl2 implements Interceptor {
    @Override
    public void addChain(InterceptorChain chain) {
        chain.getInterceptors().add(this);
    }
}