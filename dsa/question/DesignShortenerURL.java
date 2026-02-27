package dsa.question;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class DesignShortenerURL {
    // Base62 characters
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();

    // In-memory storage (Real system mein Database use hoga)
    private HashMap<String, String> shortToLong  = new HashMap<>();
    private HashMap<String, String> longToShort  = new HashMap<>();
    //agar yeh 1 hai to ek URL shortCode return karegae iskaliye iss thoda bada rakhte hai
    //private long counter = 1; // Starting point for IDs
   // private long counter = 100000000L; // Starting point for IDs
    // 2. AtomicLong initialize karein (10 Crore se start kar rahe hain)
    private AtomicLong counter = new AtomicLong(1000000L);

    // ID ko Short String mein convert karne ka function
    public String encode(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
           int charAtVal= (int)num % BASE;
            System.out.println("charAtVal  "+charAtVal);
           char charVal= ALPHABET.charAt(charAtVal);
            System.out.println("charVal  "+charVal);
            sb.append(charVal);
            num /= BASE;
            System.out.println("num  "+num);
        }
        System.out.println("sb.reverse().toString()  "+sb);
        return sb.reverse().toString();
    }

    // Shorten URL
    public String shortenURL(String longUrl) {

        // return existing short URL if already present
        if (longToShort.containsKey(longUrl)) {
            return  "http://tiny.url/" +longToShort.get(longUrl);
        }
// counter++ ki jagah yeh likhein:
        long counterId = counter.getAndIncrement();
        //String shortCode = encode(counter++);
        String shortCode = encode(counterId);
        shortToLong.put(shortCode, longUrl);
        longToShort.put(longUrl, shortCode);

        return  "http://tiny.url/" +shortCode;
    }

    // Original URL wapas pane ka method
    // Get original URL
    public String getOriginalURL(String shortUrl) {
        String key = shortUrl.replace("http://tiny.url/", "");
        return shortToLong.getOrDefault(key, "URL not found");
    }
    public static void main(String[] args) {
        DesignShortenerURL svc = new DesignShortenerURL();
        String shortUrl = svc.shortenURL("https://www.google.com/search?q=java+system+design");

        System.out.println("Short URL: " + shortUrl);
        System.out.println("Original URL: " + svc.getOriginalURL(shortUrl));
    }
}
