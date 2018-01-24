package flysall.strings;

public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
        // Old way:
        System.out.println("Row 1: [" + x + " " + y + "]");
        // New way:
        System.out.format("Row 1: [%d %f]\n", x, y);
        // Or:
        System.out.printf("Row 1: [%d %f]\n", x, y);
    }
}
