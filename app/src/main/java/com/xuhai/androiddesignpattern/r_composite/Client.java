package com.xuhai.androiddesignpattern.r_composite;

public class Client {

    public static void test() {

        Dir diskC = new Folder("C");
        diskC.addDir(new File("A.txt"));

        Dir dirA = new Folder("DirA");
        dirA.addDir(new File("dirA.text"));
        diskC.addDir(dirA);

        Dir dirB = new Folder("DirB");
        dirB.addDir(new File("dirB.text"));
        dirB.addDir(new File("dirBB.txt"));
        diskC.addDir(dirB);

        Dir dirC = new Folder("DirC");
        dirC.addDir(new File("dirC.text"));
        diskC.addDir(dirC);

        diskC.print();

    }
}
