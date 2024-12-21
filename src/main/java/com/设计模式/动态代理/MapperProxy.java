package com.设计模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author yuank
 * @version 1.0.0
 * @date 2024/12/19 19:50:18
 */
class MapperProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return "代理成功";
    }
}