package com.设计模式.适配器;

/**
 * 接口有功能但和客户需要的接口对不上,一个存在的接口去套用一个旧接口
 * @author yuank
 * @version 1.0.0
 * @date 2024/12/14 13:30:55
 */
//old
interface target {
    void specificRequest();
}
class Targeter implements target {
    public void specificRequest() {
        System.out.println("Adapte 的 specificRequest 方法被调用");
    }
}


//客户端要的接口-期望的、调用的
interface forClient {
    void specificRequestAdapter();
}
class Adapter implements forClient {
    /**包裹目标接口**/
    private target targeter;

    public Adapter(Targeter targeter) {
        this.targeter = targeter;
    }
    @Override
    public void specificRequestAdapter() {
        // 调用 Adapte 的方法，适配 forClient 接口
        targeter.specificRequest();
    }
}


class AdapterDemo {
    public static void main(String[] args) {
        forClient forclient = new Adapter(new Targeter()); // 使用适配器
        forclient.specificRequestAdapter(); // 调用目标方法
    }
}