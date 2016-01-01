public class CHelloWorld {
    static {
        System.loadLibrary("CHelloWorld");
    }

    public native void printHelloWorld();
    public static native void printNative(String str);

    public static void main(String[] a) {
        if (a.length > 0) {
            printNative(a[0]);
        } else {
            new CHelloWorld().printHelloWorld();
        }
    }
}
