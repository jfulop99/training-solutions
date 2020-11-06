package introconstructors;

public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Trattoria", 12);
        restaurant.menuGenerator();
        System.out.println(restaurant.getName());
        System.out.println(restaurant.getCapacity());
        for (String mennuItem:restaurant.getMenu()) {
            System.out.println(mennuItem);
        }
    }
}
