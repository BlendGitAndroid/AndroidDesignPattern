package com.xuhai.androiddesignpattern.d_factory.demo;

public class AudiTest {

    public static void test() {
        AudiFactory factory = new AudiCarFactory();

        AudiCar q3 = factory.createAudiCar(AudiQ3.class);
        q3.drive();
        q3.selfNavigation();

        AudiCar q5 = factory.createAudiCar(AudiQ5.class);
        q5.drive();
        q5.selfNavigation();

        AudiCar q7 = factory.createAudiCar(AudiQ7.class);
        q7.drive();
        q7.selfNavigation();
    }

}
