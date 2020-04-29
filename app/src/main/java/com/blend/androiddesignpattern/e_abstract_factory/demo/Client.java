package com.blend.androiddesignpattern.e_abstract_factory.demo;

public class Client {

    public static void test() {
        CarFactory factoryQ3 = new Q3Factory();
        factoryQ3.creteTire().tire();
        factoryQ3.createEngine().engine();
        factoryQ3.createNrake().brake();
    }

}
