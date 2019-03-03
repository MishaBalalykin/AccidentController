import java.io.*;
import java.util.Base64;

public class ByteConverter {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\ASUS\\Downloads\\byteConverter\\file\\textOutput.txt";
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String strLine = "";
            strLine = br.readLine();
            System.out.println(strLine.length());
            decoder(strLine.trim(), "C:\\Users\\ASUS\\Downloads\\byteConverter\\file\\decoderimage.jpeg");
        } catch (IOException e) {
            System.out.println("Ошибка");
        }


        System.out.println("DONE!");

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


