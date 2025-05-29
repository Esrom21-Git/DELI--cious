// Main Application Class
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DeliApp {
    private static String[] args;
    private Scanner scanner;
    private Order currentOrder;

    public DeliApp() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to DELI-cious!");

        while (true) {
            showHomeScreen();
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    startNewOrder();
                    break;
                case 0:
                    System.out.println("Thank you for using DELI-cious! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showHomeScreen() {
        System.out.println("\n=== DELI-cious Home ===");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Please choose an option: ");
    }

    private void startNewOrder() {
        currentOrder = new Order();
        showOrderScreen();
    }

    private void showOrderScreen() {
        while (true) {
            System.out.println("\n=== Order Screen ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Please choose an option: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    return;
                case 0:
                    System.out.println("Order cancelled.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addSandwich() {
        System.out.println("\n=== Add Sandwich ===");

        // Select bread
        System.out.println("Select your bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.print("Choose bread: ");
        BreadType bread = BreadType.values()[getIntInput() - 1];

        // Select size
        System.out.println("\nSandwich size:");
        System.out.println("1) 4\"");
        System.out.println("2) 8\"");
        System.out.println("3) 12\"");
        System.out.print("Choose size: ");
        SandwichSize size = SandwichSize.values()[getIntInput() - 1];

        Sandwich sandwich = new Sandwich(bread, size);

        // Add meats
        addMeats(sandwich);

        // Add cheese
        addCheese(sandwich);

        // Add regular toppings
        addRegularToppings(sandwich);

        // Add sauces
        addSauces(sandwich);

        // Toasted option
        System.out.print("\nWould you like the sandwich toasted? (y/n): ");
        String toasted = scanner.nextLine().toLowerCase();
        sandwich.setToasted(toasted.equals("y") || toasted.equals("yes"));

        currentOrder.addItem(sandwich);
        System.out.println("Sandwich added to order!");
    }

    private void addMeats(Sandwich sandwich) {
        System.out.println("\n=== Add Meats ===");
        MeatType[] meats = MeatType.values();

        while (true) {
            System.out.println("Available meats:");
            for (int i = 0; i < meats.length; i++) {
                System.out.println((i + 1) + ") " + meats[i].getDisplayName());
            }
            System.out.println("0) Done adding meats");
            System.out.print("Choose meat (0 to finish): ");

            int choice = getIntInput();
            if (choice == 0) break;

            if (choice > 0 && choice <= meats.length) {
                MeatType meat = meats[choice - 1];
                System.out.print("Extra meat? (y/n): ");
                boolean extra = scanner.nextLine().toLowerCase().startsWith("y");
                sandwich.addMeat(meat, extra);
                System.out.println(meat.getDisplayName() + (extra ? " (extra)" : "") + " added!");
            }
        }
    }

    private void addCheese(Sandwich sandwich) {
        System.out.println("\n=== Add Cheese ===");
        CheeseType[] cheeses = CheeseType.values();

        while (true) {
            System.out.println("Available cheeses:");
            for (int i = 0; i < cheeses.length; i++) {
                System.out.println((i + 1) + ") " + cheeses[i].getDisplayName());
            }
            System.out.println("0) Done adding cheese");
            System.out.print("Choose cheese (0 to finish): ");

            int choice = getIntInput();
            if (choice == 0) break;

            if (choice > 0 && choice <= cheeses.length) {
                CheeseType cheese = cheeses[choice - 1];
                System.out.print("Extra cheese? (y/n): ");
                boolean extra = scanner.nextLine().toLowerCase().startsWith("y");
                sandwich.addCheese(cheese, extra);
                System.out.println(cheese.getDisplayName() + (extra ? " (extra)" : "") + " added!");
            }
        }
    }

    private void addRegularToppings(Sandwich sandwich) {
        System.out.println("\n=== Add Regular Toppings ===");
        RegularTopping[] toppings = RegularTopping.values();

        while (true) {
            System.out.println("Available toppings:");
            for (int i = 0; i < toppings.length; i++) {
                System.out.println((i + 1) + ") " + toppings[i].getDisplayName());
            }
            System.out.println("0) Done adding toppings");
            System.out.print("Choose topping (0 to finish): ");

            int choice = getIntInput();
            if (choice == 0) break;

            if (choice > 0 && choice <= toppings.length) {
                sandwich.addRegularTopping(toppings[choice - 1]);
                System.out.println(toppings[choice - 1].getDisplayName() + " added!");
            }
        }
    }

    private void addSauces(Sandwich sandwich) {
        System.out.println("\n=== Add Sauces ===");
        SauceType[] sauces = SauceType.values();

        while (true) {
            System.out.println("Available sauces:");
            for (int i = 0; i < sauces.length; i++) {
                System.out.println((i + 1) + ") " + sauces[i].getDisplayName());
            }
            System.out.println("0) Done adding sauces");
            System.out.print("Choose sauce (0 to finish): ");

            int choice = getIntInput();
            if (choice == 0) break;

            if (choice > 0 && choice <= sauces.length) {
                sandwich.addSauce(sauces[choice - 1]);
                System.out.println(sauces[choice - 1].getDisplayName() + " added!");
            }
        }
    }

    private void addDrink() {
        System.out.println("\n=== Add Drink ===");
        System.out.println("Select drink size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.print("Choose size: ");
        DrinkSize size = DrinkSize.values()[getIntInput() - 1];

        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);
        currentOrder.addItem(drink);
        System.out.println("Drink added to order!");
    }

    private void addChips() {
        System.out.println("\n=== Add Chips ===");
        System.out.print("Enter chip type: ");
        String type = scanner.nextLine();

        Chips chips = new Chips(type);
        currentOrder.addItem(chips);
        System.out.println("Chips added to order!");
    }

    private void checkout() {
        if (currentOrder.getItems().isEmpty()) {
            System.out.println("Your order is empty!");
            return;
        }

        System.out.println("\n=== Order Summary ===");
        System.out.println(currentOrder.getOrderDetails());
        System.out.printf("Total: $%.2f%n", currentOrder.getTotalCost());

        System.out.print("\nConfirm order? (y/n): ");
        String confirm = scanner.nextLine().toLowerCase();

        if (confirm.equals("y") || confirm.equals("yes")) {
            saveReceipt();
            System.out.println("Order confirmed! Receipt saved. Thank you!");
        } else {
            System.out.println("Order cancelled.");
        }
    }

    private void saveReceipt() {
        try {
            File receiptsDir = new File("receipts");
            if (!receiptsDir.exists()) {
                receiptsDir.mkdirs();
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String fileName = "receipts/" + timestamp + ".txt";

            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                writer.println("DELI-cious Receipt");
                writer.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                writer.println("=====================================");
                writer.println(currentOrder.getOrderDetails());
                writer.printf("Total: $%.2f%n", currentOrder.getTotalCost());
                writer.println("=====================================");
                writer.println("Thank you for your business!");
            }

            System.out.println("Receipt saved as: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }

    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public static void main(String[] args) {
        DeliApp.args = args;
        new DeliApp().run();
    }
}

// Base interface for orderable items
interface OrderItem {
    double getPrice();
    String getDescription();
}

// Order class to manage the current order
class Order {
    private List<OrderItem> items;
    private LocalDateTime orderTime;

    public Order() {
        items = new ArrayList<>();
        orderTime = LocalDateTime.now();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalCost() {
        return items.stream().mapToDouble(OrderItem::getPrice).sum();
    }

    public String getOrderDetails() {
        StringBuilder sb = new StringBuilder();
        for (int i = items.size() - 1; i >= 0; i--) { // Show newest first
            OrderItem item = items.get(i);
            sb.append(item.getDescription()).append(" - $")
                    .append(String.format("%.2f", item.getPrice())).append("\n");
        }
        return sb.toString();
    }
}

// Sandwich class
class Sandwich implements OrderItem {
    private BreadType bread;
    private SandwichSize size;
    private List<MeatTopping> meats;
    private List<CheeseTopping> cheeses;
    private List<RegularTopping> regularToppings;
    private List<SauceType> sauces;
    private boolean toasted;

    public Sandwich(BreadType bread, SandwichSize size) {
        this.bread = bread;
        this.size = size;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.toasted = false;
    }

    public void addMeat(MeatType meat, boolean extra) {
        meats.add(new MeatTopping(meat, extra));
    }

    public void addCheese(CheeseType cheese, boolean extra) {
        cheeses.add(new CheeseTopping(cheese, extra));
    }

    public void addRegularTopping(RegularTopping topping) {
        regularToppings.add(topping);
    }

    public void addSauce(SauceType sauce) {
        sauces.add(sauce);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
        double price = size.getBasePrice();

        // Add meat prices
        for (MeatTopping meat : meats) {
            price += meat.getPrice(size);
        }

        // Add cheese prices
        for (CheeseTopping cheese : cheeses) {
            price += cheese.getPrice(size);
        }

        return price;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(size.getDisplayName()).append(" ")
                .append(bread.getDisplayName()).append(" Sandwich");

        if (!meats.isEmpty()) {
            sb.append("\n  Meats: ");
            for (MeatTopping meat : meats) {
                sb.append(meat.getDescription()).append(", ");
            }
            sb.setLength(sb.length() - 2); // Remove last comma
        }

        if (!cheeses.isEmpty()) {
            sb.append("\n  Cheeses: ");
            for (CheeseTopping cheese : cheeses) {
                sb.append(cheese.getDescription()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        if (!regularToppings.isEmpty()) {
            sb.append("\n  Toppings: ");
            for (RegularTopping topping : regularToppings) {
                sb.append(topping.getDisplayName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        if (!sauces.isEmpty()) {
            sb.append("\n  Sauces: ");
            for (SauceType sauce : sauces) {
                sb.append(sauce.getDisplayName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }

        if (toasted) {
            sb.append("\n  (Toasted)");
        }

        return sb.toString();
    }
}

// Drink class
class Drink implements OrderItem {
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        return size.getPrice();
    }

    @Override
    public String getDescription() {
        return size.getDisplayName() + " " + flavor + " Drink";
    }
}

// Chips class
class Chips implements OrderItem {
    private String type;
    private static final double PRICE = 1.50;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public String getDescription() {
        return type + " Chips";
    }
}

// Enums and supporting classes
enum BreadType {
    WHITE("White"), WHEAT("Wheat"), RYE("Rye"), WRAP("Wrap");

    private String displayName;

    BreadType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

enum SandwichSize {
    FOUR_INCH("4\"", 5.50), EIGHT_INCH("8\"", 7.00), TWELVE_INCH("12\"", 8.50);

    private String displayName;
    private double basePrice;

    SandwichSize(String displayName, double basePrice) {
        this.displayName = displayName;
        this.basePrice = basePrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getBasePrice() {
        return basePrice;
    }
}

enum MeatType {
    STEAK("Steak"), HAM("Ham"), SALAMI("Salami"),
    ROAST_BEEF("Roast Beef"), CHICKEN("Chicken"), BACON("Bacon");

    private String displayName;

    MeatType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

enum CheeseType {
    AMERICAN("American"), PROVOLONE("Provolone"),
    CHEDDAR("Cheddar"), SWISS("Swiss");

    private String displayName;

    CheeseType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

enum RegularTopping {
    LETTUCE("Lettuce"), PEPPERS("Peppers"), ONIONS("Onions"),
    TOMATOES("Tomatoes"), JALAPENOS("Jalapeños"), CUCUMBERS("Cucumbers"),
    PICKLES("Pickles"), GUACAMOLE("Guacamole"), MUSHROOMS("Mushrooms");

    private String displayName;

    RegularTopping(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

enum SauceType {
    MAYO("Mayo"), MUSTARD("Mustard"), KETCHUP("Ketchup"),
    RANCH("Ranch"), THOUSAND_ISLANDS("Thousand Islands"), VINAIGRETTE("Vinaigrette");

    private String displayName;

    SauceType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

enum DrinkSize {
    SMALL("Small", 2.00), MEDIUM("Medium", 2.50), LARGE("Large", 3.00);

    private String displayName;
    private double price;

    DrinkSize(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }
}

// Topping classes for premium items
class MeatTopping {
    private MeatType meatType;
    private boolean extra;

    public MeatTopping(MeatType meatType, boolean extra) {
        this.meatType = meatType;
        this.extra = extra;
    }

    public double getPrice(SandwichSize size) {
        double basePrice = 0;
        double extraPrice = 0;

        switch (size) {
            case FOUR_INCH:
                basePrice = 1.00;
                extraPrice = 0.50;
                break;
            case EIGHT_INCH:
                basePrice = 2.00;
                extraPrice = 1.00;
                break;
            case TWELVE_INCH:
                basePrice = 3.00;
                extraPrice = 1.50;
                break;
        }

        return basePrice + (extra ? extraPrice : 0);
    }

    public String getDescription() {
        return meatType.getDisplayName() + (extra ? " (extra)" : "");
    }
}

class CheeseTopping {
    private CheeseType cheeseType;
    private boolean extra;

    public CheeseTopping(CheeseType cheeseType, boolean extra) {
        this.cheeseType = cheeseType;
        this.extra = extra;
    }

    public double getPrice(SandwichSize size) {
        double basePrice = 0;
        double extraPrice = 0;

        switch (size) {
            case FOUR_INCH:
                basePrice = 0.75;
                extraPrice = 0.30;
                break;
            case EIGHT_INCH:
                basePrice = 1.50;
                extraPrice = 0.60;
                break;
            case TWELVE_INCH:
                basePrice = 2.25;
                extraPrice = 0.90;
                break;
        }

        return basePrice + (extra ? extraPrice : 0);
    }

    public String getDescription() {
        return cheeseType.getDisplayName() + (extra ? " (extra)" : "");
    }
}