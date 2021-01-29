package com.blend.androiddesignpattern.e_abstract_factory.demo;

/**
 * 抽象工厂模式，为创建一组相关或是相互依赖的对象提供一个接口，而不需要指定他们的具体类。也可以理解成将不同的工厂模式集合到一起。
 * <p>
 * <p>
 * 对比抽象工厂，一个工厂确定后，就只能生产一类产品了。抽象工厂每个工厂可以创建不同的类。但是在定义时就已经定义好了一个抽象工厂
 * 可以生产的产品，这些产品都是具有一些相关性的。比如下面这个例子中，抽象的Car工厂可以生产抽象的轮胎，引擎，制动器，这些都是在
 * 工厂中定义好的，都是具有相关性的。
 * <p>
 * <p>
 * 在这个例子中，汽车工厂定义了两种不同的工厂生成轮胎，引擎，制动器的抽象接口，这两种不同的工厂生产不同的轮胎，引擎，制动器等。
 */
public class Client {

    public static void test() {
        CarFactory factoryQ3 = new Q3Factory();
        factoryQ3.creteTire().tire();
        factoryQ3.createEngine().engine();
        factoryQ3.createNrake().brake();
    }

}
