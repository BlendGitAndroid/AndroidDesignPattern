package com.blend.androiddesignpattern.t_decorator;

/**
 * 装饰模式：也称为包装模式，使用一种对客户端透明的方式来动态的扩展对象的功能。
 * 在这个例子中：
 * Person：抽象组件。是原始对象。
 * SinglePerson：组件具体实现类，也是装饰的具体兑现。
 * Decorator：抽象装饰者。这个类就是为了装饰组件对象，其内部一定要有一个指向组件对象的引用。
 * RShoes：装饰者的具体实现类。
 * 这里的装饰者模式,和Context和ContextImpl的是有别的的。就看怎么理解了。
 */
public class DecoratorMain {

    public static void main(String[] args) {
        SinglePerson person = new SinglePerson("Blend");
        RShoes rShoes = new RShoes(person);
        rShoes.show();
    }

}
