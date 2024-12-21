package com.forlearn.pluginshow.executor.intercepted;

import com.forlearn.pluginshow.executor.executor1;

/**
 * @author yuank
 * @version 1.0.0
 * @date 2024/12/21 9:40:47
 */
public class executorImpl1 implements executor1 {

    @Override
    public void execute() {
        System.out.println("我是要被插件代理的 1号执行器");
    }
}