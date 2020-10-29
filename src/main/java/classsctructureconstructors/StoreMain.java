package classsctructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store firstStore = new Store("Alma");
        Store secondStore = new Store("Körte");

        firstStore.store(100);
        secondStore.store(200);

        System.out.println("Stock 1: " + firstStore.getStock() + " " + firstStore.getProduct());
        System.out.println("Stock 2: " + secondStore.getStock() + " " + secondStore.getProduct());
        // Dispatch 40 alma and 60 körte
        System.out.println("Dispatch 40 alma and 60 körte");
        firstStore.dispatch(40);
        secondStore.dispatch(60);

        System.out.println("Stock 1: " + firstStore.getStock() + " " + firstStore.getProduct());
        System.out.println("Stock 2: " + secondStore.getStock() + " " + secondStore.getProduct());

        // Store 60 alma and 80 körte
        System.out.println("Store 60 alma and 80 körte");
        firstStore.store(60);
        secondStore.store(80);

        System.out.println("Stock 1: " + firstStore.getStock() + " " + firstStore.getProduct());
        System.out.println("Stock 2: " + secondStore.getStock() + " " + secondStore.getProduct());

    }
}
