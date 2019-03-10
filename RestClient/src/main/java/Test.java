import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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
            "    {\"mediaProof\": \"" + encoder("C:\\Users\\ASUS\\Downloads\\PROJECT\\AccidentController\\RestClient\\file\\11.jpeg") + "\"},\n" +
            "    {\"mediaProof\": \"" + encoder("C:\\Users\\ASUS\\Downloads\\PROJECT\\AccidentController\\RestClient\\file\\video.mp4") + "\"}\n" +
            "  ],\n" +
            "  \"accidentAddress\": \"NovomytyshynsyProspect\",\n" +
            "  \"accidentDate\": \"1545405321000\"\n" +
            "}";

    public static void main(String[] args) throws ClientProtocolException, IOException {
        String filePathTemplate = "C:\\Users\\ASUS\\Downloads\\PROJECT\\AccidentController\\RestClient\\file\\decoded\\decodedMedia";
        doPost(createAccident);
        int i = 0;
        for (String resultString : pars(doGet())) {
            String filePath = filePathTemplate + i + ".txt";
            i++;
            decoder(resultString, filePath);
        }
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

    public static String doGet() {
        String line = "";

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:8080//get-accident-by-address/NovomytyshynsyProspect");
        HttpResponse response = null;
        try {
            response = client.execute(request);
            BufferedReader rd = null;
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            line = rd.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static List<String> pars(String line){
        List<String> resultList = new ArrayList();
        String[] splitedString = {};
        String[] splitedString2 = {};

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("C:\\Users\\ASUS\\Downloads\\PROJECT\\AccidentController\\RestClient\\filetextOutput.txt", true));
            writer.append(line);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        splitedString = line.split("mediaProof\":\"");
        int i = 1;
        while(i < splitedString.length){
            splitedString2 = splitedString[i].split("\"}");
            resultList.add(splitedString2[0]);
            i++;
        }
       // System.out.println(splitedString2[0]);
        return resultList;
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

    public static void decoder(String base64Image, String pathFile) {
        try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
            // Converting a Base64 String into Image byte array
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
    }
}