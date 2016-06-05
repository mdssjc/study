package application;

import framework.FrameworkClass;

public class ApplicationClassB extends FrameworkClass {

    @Override
    public void stepTwo() {
        System.out.println("STEP TWO - Application B");
    }

    @Override
    public void stepThree() {
        System.out.println("STEP THREE - Application B");
    }

    @Override
    public void hook() {
        System.out.println("HOOK - Application B");
    }
}
