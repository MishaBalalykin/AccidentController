import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.util.Base64;

public class Test {
    static String createAccident = "{\n" +
            "  \"creator\": {\n" +
            "    \"name\": \"misha\",\n" +
            "    \"phoneNumber\": \"+79260113914\"\n" +
            "  },\n" +
            "  \"textProof\": {\n" +
            "    \"proof\": \"proof\"\n" +
            "  },\n" +
            "  \"mediaProofs\": [\n" +
            "    {\"mediaProof\": \"" + encoder("C:\\Users\\ASUS\\Downloads\\byteConverter\\file\\11.jpeg") + "\"}\n" +
            "  ],\n" +
            "  \"accidentAddress\": \"Novomytyshynsy\",\n" +
            "  \"accidentDate\": \"1545405321000\"\n" +
            "}";

    public static void main(String[] args) throws ClientProtocolException, IOException {
        doPost(createAccident);
        doGet();
    }

    public static void doPost(String request) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://localhost:8080/create-accident");

        post.setEntity(new StringEntity(request));
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void doGet() {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:8080//get-accident-by-address/Novomytyshynsy");
        HttpResponse response = null;
        try {
            response = client.execute(request);
            BufferedReader rd = null;
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ASUS\\Downloads\\byteConverter\\file\\textOutput.txt", true));
                writer.append(line);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String encoder(String imagePath) {
        String base64Image = "";
        File file = new File(imagePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a Image file from file system
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return base64Image;
    }
}