// T = O(1)
// S = O(n) n as the number of longUrl
public class Codec {
    Map<String, String> map = new HashMap<>(); // tinyURL, origin
    String letters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            sb.append(letters.charAt(r.nextInt(letters.length())));
        }
        String shortUrl = "https://tinyurl.com/"+sb.toString();
        while(map.containsKey(shortUrl)) encode(longUrl);
        map.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));