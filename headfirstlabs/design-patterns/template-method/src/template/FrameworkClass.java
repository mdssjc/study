package template;

public abstract class FrameworkClass {

    public final void templateMethod() {
        stepOne();
        stepTwo();
        stepThree();
    }

    public abstract void stepThree();

    public abstract void stepTwo();

    public void stepOne() {
        System.out.println("STEP ONE - Framework");
    }
}
