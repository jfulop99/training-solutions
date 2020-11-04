package week02;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean areTheyEqual(Product product){
        return name.equals(product.getName()) && (Math.abs(code.length() - product.code.length()) < 2);
    }

    public static void main(String[] args) {
        Product prduct1 = new Product("Bicikli", "12345678");
        Product prduct2 = new Product("Kerékpár", "8765432");


        System.out.println(prduct1.areTheyEqual(prduct2));
        prduct2.setName("Bicikli");
        System.out.println(prduct1.areTheyEqual(prduct2));
    }
}
