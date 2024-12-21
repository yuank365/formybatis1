package com.设计模式.装饰器;

/**
 * 给一个已有对象加功能
 * Component抽象 + ConcreteComponent类[]
 * Decorator继↑承抽象 实际上你不继承也不影响你进行装饰(包装)只是为了统一行为而已
 * 创建具体装饰器（ConcreteDecorator）类，继承抽象装饰器类，并在其中添加额外的功能。
 *
 * @author yuank
 * @version 1.0.0
 * @date 2024/12/19 9:24:00
 */
// 抽象组件-饮料
abstract class Beverage {

    abstract String getDescription();
    abstract double getCost();
}
interface Beverage1 {
    String getDescription();
    double getCost();
}
// 具体组件
class Coffee extends Beverage {
    @Override String getDescription() {return "Coffee";}
    @Override double getCost() {return 5.0;} // 基础价格
}

// 抽象装饰器！
/**关键点**/
abstract class BeverageDecorator extends Beverage {
        protected Beverage beverage;
    BeverageDecorator(Beverage beverage) {this.beverage = beverage;}
}
interface BeverageDecorator1 extends Beverage1 {}
/*******/

// 具体装饰器1
class Milk extends BeverageDecorator {
    Milk(Beverage beverage) {super(beverage);}

    @Override String getDescription() {return beverage.getDescription() + ", Milk";}
    @Override double getCost() {return beverage.getCost() + 1.0;} // 加奶的额外费用
}

// 具体装饰器2
class Sugar extends BeverageDecorator {
    Sugar(Beverage beverage) {super(beverage);}

    @Override String getDescription() {return beverage.getDescription() + ", Sugar";}
    @Override double getCost() {return beverage.getCost() + 0.5;} // 加糖的额外费用}
}


// 使用装饰器模式
class DecoratorDemo  {
    public static void main(String[] args) {
        // 基础饮料
        Beverage beverage = new Coffee();
        System.out.println(beverage.getDescription() + " - $" + beverage.getCost());
        // 添加牛奶
        beverage = new Milk(beverage);
        System.out.println(beverage.getDescription() + " - $" + beverage.getCost());
        // 添加糖
        beverage = new Sugar(beverage);
        System.out.println(beverage.getDescription() + " - $" + beverage.getCost());
    }
}
