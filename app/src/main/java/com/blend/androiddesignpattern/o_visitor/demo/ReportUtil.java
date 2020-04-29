package com.blend.androiddesignpattern.o_visitor.demo;

public class ReportUtil {

    public void visit(Staff staff) {
        if (staff instanceof Manager) {
            Manager manager = (Manager) staff;
            System.out.println("经理：" + manager.name + "，KPI：" + manager.kpi + "，新产品数量：" + manager.getProducts());
        } else {
            Engineer engineer = (Engineer) staff;
            System.out.println("工程师：" + engineer.name + "，KPI：" + engineer.kpi);
        }
    }

}
