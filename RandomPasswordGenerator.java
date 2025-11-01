import java.util.*;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("===== Random Password Generator =====");

        // Step 1: Ask for password length
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        // Step 2: Ask what to include in the password
        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLower = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUpper = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("y");

        // Step 3: Define character sets
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+<>?/";

        // Step 4: Build character pool based on user choices
        String characterPool = "";
        if (includeLower) characterPool += lowerCase;
        if (includeUpper) characterPool += upperCase;
        if (includeNumbers) characterPool += numbers;
        if (includeSpecial) characterPool += specialChars;

        // Step 5: Validate that at least one type is selected
        if (characterPool.isEmpty()) {
            System.out.println("You must select at least one character type!");
            return;
        }

        // Step 6: Generate password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        // Step 7: Display result
        System.out.println("\nGenerated Password: " + password.toString());

        scanner.close();
    }
}
