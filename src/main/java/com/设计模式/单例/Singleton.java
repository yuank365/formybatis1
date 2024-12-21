package com.设计模式.单例;

/**
 * 不允许new方法放开权限——只能通过类的手段【静态】
 * PS1:通过类的话 说明其实可以反射强行绕开 查阅构造器也可以setAccessible(true)
 * ps2:工程意义不大 因为 spring提供功能直接让返回对象作为单例
 *
 *
 * @author yuank
 * @version 1.0.0
 * @date 2024/12/19 9:41:03
 */
//太饿了,随类加载上桌了(new)
class HungerSingleton{
    private static HungerSingleton instance = new HungerSingleton();
    public static HungerSingleton getInstance(){
        return instance;
    }
    private HungerSingleton(){} // 权限阻止了偷偷new的可能 要new只能通过静态类方法
}
//有人需要再上桌
class FullSingleton {
    private static FullSingleton instance;
    public static synchronized FullSingleton getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return new FullSingleton();}
    }
    private FullSingleton(){} // 关键在于权限,而不是构造的空
}

//把上桌和判断分开
class DoubleSingleton{
    private static DoubleSingleton instance;
    public static DoubleSingleton getInstance(){
        if (instance == null) {
            synchronized (DoubleSingleton.class) {
                if (instance == null) {
                    return new DoubleSingleton();
                }
            }
        }
        return instance;
    }
    private DoubleSingleton(){}
}
