package com.forlearn.pluginshow.plugin;

import com.forlearn.pluginshow.plugin.realInterceptor.InterceptorChain;

/**
 * @author yuank
 * @version 1.0.0
 * @date 2024/12/21 9:52:28
 */
public interface Interceptor {

    public void addChain(InterceptorChain chain);


}
