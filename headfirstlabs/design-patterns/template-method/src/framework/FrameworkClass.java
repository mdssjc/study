package framework;

public abstract class FrameworkClass {

    public final void templateMethod() {
        stepOne();
        stepTwo();
        stepThree();
        hook();
    }

    public final void stepOne() {
        System.out.println("STEP ONE - Framework");
    }

    public abstract void stepTwo();

    public abstract void stepThree();

    public void hook() {

    }
}
