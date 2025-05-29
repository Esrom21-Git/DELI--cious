package order.java;

public class SandwichSize {
    public static <BreadType> BreadType[] values() {
        return (BreadType[]) getBreadTypes();
    }

    private static BreadType[] getBreadTypes() {
        return null;
    }
}
