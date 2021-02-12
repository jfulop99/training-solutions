package xtest;

public class C extends B {

    public C(int a) {
        super(a);
    }

    public C() {
        super();
    }

    @Override
    public int getFive() {

        return super.getFive();
    }
}
