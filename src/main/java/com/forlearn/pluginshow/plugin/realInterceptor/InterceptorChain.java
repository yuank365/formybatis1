package com.forlearn.pluginshow.plugin.realInterceptor;

import com.forlearn.pluginshow.plugin.Interceptor;
import lombok.Data;

import java.util.List;

/**
 * @author yuank
 * @version 1.0.0
 * @date 2024/12/21 9:51:52
 */
@Data
public class InterceptorChain {
    //所有的拦截器
    private List<Interceptor> interceptors;

    //提供一个打包方法


}