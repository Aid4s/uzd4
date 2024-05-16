import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Iveskite 1 teksta:");
        String text1 = scanner.nextLine();

        String signature = generateDigitalSignature(text1);
        System.out.println("1 teksto parasas: " + signature);


        System.out.println("Iveskite 2 teksta");
        String text2 = scanner.nextLine();
        String signature2 = generateDigitalSignature(text2);

        System.out.println("Iveskite 3 teksta:");
        String text3 = scanner.nextLine();

        String signature3 = generateDigitalSignature(text3);
        System.out.println("3 teksto parasas: " + signature3);

        if (signature2.equals(signature3)) {
            System.out.println("Signature Verified!");
        } else {
            System.out.println("Signature Not Verified!");
        }

        scanner.close();
    }

    private static String generateDigitalSignature(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(text.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
