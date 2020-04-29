package com.blend.androiddesignpattern.o_visitor.demo;

public class VisitorClient {

    public static void test() {
        BusinessReport report = new BusinessReport();
        System.out.println("======== 给CEO看的报表 ====== ");
        report.showReport(new CEOVisitor());

        System.out.println("\n======== 给CTO看的报表 ====== ");
        report.showReport(new CTOVisitor());
    }

}
