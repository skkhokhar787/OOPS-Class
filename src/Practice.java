import java.util.*;
import java.io.*;
class Phone {
    String brandName;
    String model;
    String ram;
    String storage;
    String camera;
    int price;

    public Phone(String brandName, String model, String ram, String storage, String camera, int price) {
        this.brandName = brandName;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.camera = camera;
        this.price = price;
    }

    public void displaySpecs() {
        System.out.println(brandName + " " + model);
        System.out.println("Ram: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("Camera: " + camera);
        System.out.println("Price: " + price + " RS");
    }
}

public class Practice {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Map<String, Phone> phoneCatalog = new HashMap<>();

        // Read phone from phone.txt
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\DESKTOP-QBATOU\\IdeaProjects\\oops class\\src\\phone.txt"));
        String line;

        while ((line = reader.readLine()) != null) {
            String [] parts = line.split(",");
            if (parts.length == 6) {
                String key = (parts[0] + " " + parts[1]).toLowerCase();
                Phone phone = new Phone(parts[0], parts[1], parts[2], parts[3], parts[4], Integer.parseInt(parts[5]));
                phoneCatalog.put(key, phone);

            }
        }
        reader.close();

        // User input
        System.out.print("Enter Brand name: ");
        String brand = sc.nextLine();
        System.out.print("Enter Model: ");
        String model = sc.nextLine();

        // Normalize and lookup
        String key = (brand + " " + model).toLowerCase();
        Phone foundPhone = phoneCatalog.get(key);

        if (foundPhone != null) {
            foundPhone.displaySpecs();
        } else {
            System.out.println("Sorry, specs for this phone are not available.");
        }
    }
}