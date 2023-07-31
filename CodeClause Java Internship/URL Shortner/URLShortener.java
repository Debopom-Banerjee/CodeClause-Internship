import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URLShortener {

    private static final int SHORT_CODE_LENGTH = 6;
    private static final String BASE_URL = "https://short.url/";

    private Map<String, String> shortToOriginalMap;
    private Map<String, String> originalToShortMap;

    public URLShortener() {
        this.shortToOriginalMap = new HashMap<>();
        this.originalToShortMap = new HashMap<>();
    }

    public String shortenURL(String originalURL) {
        if (originalToShortMap.containsKey(originalURL)) {
            return BASE_URL + originalToShortMap.get(originalURL);
        }

        String shortCode = generateShortCode();
        while (shortToOriginalMap.containsKey(shortCode)) {
            shortCode = generateShortCode();
        }

        shortToOriginalMap.put(shortCode, originalURL);
        originalToShortMap.put(originalURL, shortCode);

        return BASE_URL + shortCode;
    }

    private String generateShortCode() {
        StringBuilder shortCode = new StringBuilder();
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
            int randomIndex = (int) (Math.random() * charSet.length());
            shortCode.append(charSet.charAt(randomIndex));
        }

        return shortCode.toString();
    }

    public String getOriginalURL(String shortURL) {
        String shortCode = shortURL.substring(BASE_URL.length());
        return shortToOriginalMap.getOrDefault(shortCode, "URL not found.");
    }

    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the original URL (or 'exit' to quit):");
            String originalURL = scanner.nextLine();

            if (originalURL.equalsIgnoreCase("exit")) {
                break;
            }

            String shortURL = urlShortener.shortenURL(originalURL);
            System.out.println("Shortened URL: " + shortURL);
        }

        System.out.println("Thank you for using the URL shortener!");
        scanner.close();
    }
}
