import java.util.*;

class Phone1 {
    String brandName, model, ram, storage, camera;
    int price;

    public Phone1(String brandName, String model, String ram, String storage, String camera, int price) {
        this.brandName = brandName;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.camera = camera;
        this.price = price;
    }

    public void displaySpecs() {
        System.out.println("\n🔍 Phone Details:");
        System.out.println("Brand   : " + brandName);
        System.out.println("Model   : " + model);
        System.out.println("RAM     : " + ram);
        System.out.println("Storage : " + storage);
        System.out.println("Camera  : " + camera);
        System.out.println("Price   : " + price + " RS");
    }
}

public class Practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Phone1>> phoneCatalog = new HashMap<>();

        // 🧠 Preloading phones grouped by brand
        phoneCatalog.put("samsung", List.of(
                new Phone1("Samsung", "Galaxy S25 Ultra", "12GB", "256GB", "200MP", 400000),
                new Phone1("Samsung", "Galaxy A15", "6GB", "128GB", "50MP", 59000),
                new Phone1("Samsung", "Galaxy Z Fold 6", "12GB", "256GB", "72MP", 519000),
                new Phone1("Samsung", "Galaxy Z Flip 6", "12GB", "512GB", "72MP", 329500)
        ));

        phoneCatalog.put("xiaomi", List.of(
                new Phone1("Xiaomi", "15 Ultra", "12GB", "256GB", "200MP", 400000),
                new Phone1("Xiaomi", "Redmi Note 14 pro", "8GB/12GB", "256GB/512GB", "200MP", 66600),
                new Phone1("Xiaomi", "Poco F7 Ultra", "16GB", "512GB", "132MP", 257000),
                new Phone1("Xiaomi", "Mix Flip", "12GB", "512GB", "100MP", 325000)
        ));

        phoneCatalog.put("oppo", List.of(
                new Phone1("Oppo", "A3x", "4GB", "64GB", "15MP", 25600),
                new Phone1("Oppo", "Find N5", "12GB/16GB", "256GB/512GB/1TB", "50MP", 400000),
                new Phone1("Oppo", "Reno 13 Pro", "12GB", "512GB", "50MP", 220000),
                new Phone1("Oppo", "A5i Pro", "8GB", "128GB", "50MP", 50000)
        ));

        phoneCatalog.put("vivo", List.of(
                new Phone1("Vivo", "X100 Pro", "16GB", "512GB", "50MP", 350000),
                new Phone1("Vivo", "X200 Pro", "16GB", "512GB", "200MP", 33000),
                new Phone1("Vivo", "Y300", "8GB", "128GB","50MP",80000),
                new Phone1("Vivo", "X Fold 3", "12GB", "256GB", "100MP",385000)
        ));

        phoneCatalog.put("nothing", List.of(
                new Phone1("Nothing", "Phone 2", "12GB", "512GB", "50MP", 320000),
                new Phone1("Nothing", "Phone 2a", "12GB", "256GB","100MP", 144900),
                new Phone1("Nothing", "CMF Phone1", "8GB", "128GB", "50MP", 85000),
                new Phone1("Nothing","Phone 3", "12GB", "256GB","100MP", 152000)
        ));

        phoneCatalog.put("apple", List.of(
                new Phone1("Apple", "iPhone 15 Pro", "8GB", "256GB", "48MP", 530000),
                new Phone1("Apple", "iphone 11 pro", "4GB", "64GB/256GB/512GB", "12MP", 207800),
                new Phone1("Apple", "iphone 13 Pro Max", "6GB", "128GB/256GB/512GB", "12MP", 374000),
                new Phone1("Apple", "iphone 16", "8GB", "128GB", "48MP", 380500)
        ));

        // 🧭 User input
        System.out.print("Enter a phone brand: ");
        String brandInput = sc.nextLine().toLowerCase();

        List<Phone1> brandPhones = phoneCatalog.get(brandInput);

        if (brandPhones != null && !brandPhones.isEmpty()) {
            System.out.println("\n📱 Available models:");
            for (int i = 0; i < brandPhones.size(); i++) {
                System.out.println((i + 1) + ". " + brandPhones.get(i).model);
            }

            System.out.print("\nSelect a model by number (1–" + brandPhones.size() + "): ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            if (choice >= 1 && choice <= brandPhones.size()) {
                Phone1 selectedPhone = brandPhones.get(choice - 1);
                selectedPhone.displaySpecs();
            } else {
                System.out.println("Invalid model number selected.");
            }

        } else {
            System.out.println("Sorry, no models available for this brand.");
        }
    }
}