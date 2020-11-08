package primitivetypes;

public class PrimitiveTypesMain {
    public static void main(String[] args) {
        PrimitiveTypes primitiveTypes = new PrimitiveTypes();

        for (int i = 0; i < 16; i++) {
            System.out.println(primitiveTypes.toBinaryString(i));
            System.out.println(Integer.toBinaryString(i));
        }

        System.out.println(new Integer(1) + new Integer(2));

    }
}
