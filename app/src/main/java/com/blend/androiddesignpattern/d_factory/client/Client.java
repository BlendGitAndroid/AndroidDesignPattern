package com.blend.androiddesignpattern.d_factory.client;

import com.blend.androiddesignpattern.d_factory.factory.ConcreteFactory;
import com.blend.androiddesignpattern.d_factory.factory.Factory;
import com.blend.androiddesignpattern.d_factory.product.ConcreteProductA;
import com.blend.androiddesignpattern.d_factory.product.Product;

/**
 * 任何需要生成复杂对象的地方都可以用工厂模式，能直接new的无需使用工厂模式。
 * 那么这个复杂怎么理解呢？
 * 我是这么理解的，当一个类不知道它所需要的具体对象的类，只需要知道所对应的工厂。
 * 当一个类需要通过其子类来指定创建对象时。
 * 将创建对象的任务委托给多个工厂子类中的某一个，客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时可通过动态生成，
 * 就像例子中第二种使用反射实现。
 * <p>
 * 定义一个用于创建对象的接口，让子类决定实例化哪个类，这样的一个工厂就能批量生成一种产品对象，省去了复杂对象的创建过程。
 * 但是如果产品是多种多样的，即一个接口需要有多种不同的对象实例，那么就得创建不同的工厂来生成对象，为了简便，可以使用反射
 * 来动态实现。
 * <p>
 * 缺点：
 * 使用工厂模式，编写新的产品时，就要编写一个新的产品类，还要引入抽象层，增加了类结构的复杂度。
 * <p>
 * <p>
 * <p>
 * 简单工厂模式就是工厂类是写死的，要是增加新的产品，就得修改工厂类，违背了开闭原则。
 * 而工厂模式工厂类是抽象的，生成某个具体的产品就新建具体的工厂，不会违背开闭原则。
 */
public class Client {
    public static void test() {
        Factory factory = new ConcreteFactory();
        Product p = factory.createProduct();
        p.method();

        Product pClass = factory.createProduct(ConcreteProductA.class);
        pClass.method();

    }
}
