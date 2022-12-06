import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtility {
    
    public static void writeToFile(String fileName, String text) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));) {
            bufferedWriter.write(text);
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("Done");
        }

    }


    public static String read(String fileName) throws Exception {
        try (InputStream inputStream = new FileInputStream(fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(inputStreamReader);
        ) {

            String line = null;
            String result = "";
            while ((line = reader.readLine()) != null) {
                result += line;


            }
            return result;
        }

    }

    public static void writeBytes(String FileName, byte[] data) throws Exception {
        FileOutputStream outputStream = new FileOutputStream(new File(FileName));
//        byte[] contentByte=content.getBytes();
        outputStream.write(data);
        outputStream.flush();
        outputStream.close();
        System.out.println("Done");

    }

    public static byte[] readBytes(String fileName) throws Exception {
        FileInputStream inputStream = new FileInputStream(new File(fileName));
        byte[] byteArray = new byte[(int) new File(fileName).length()];
        inputStream.read(byteArray);
        return byteArray;


    }

    public static void writeFileByNio(String fileName, byte[] data) throws Exception {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, data);
    }

    public static byte[] readFileByNio(String fileName) throws Exception {
        Path filePath = Paths.get(fileName);
        byte[] byteArray = Files.readAllBytes(filePath);
        return byteArray;

    }

    public static Object readObject(String fileName) throws Exception {
        Object obj = null;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();


    }

    public static void writeObjToFile(Serializable object, String fileName) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutput obj = new ObjectOutputStream(fileOutputStream);
        obj.writeObject(object);
        System.out.println("Done");
    }
}
