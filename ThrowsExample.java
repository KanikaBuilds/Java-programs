import java.io.*;

public class ThrowsExample {
    // method declares it may throw IOException
    void readFile() throws IOException {
        FileReader fr = new FileReader("abc.txt");
        BufferedReader br = new BufferedReader(fr);
        System.out.println(br.readLine());
    }

    public static void main(String[] args) {
        ThrowsExample obj = new ThrowsExample();
        try {
            obj.readFile();
        } catch (IOException e) {
            System.out.println("Exception handled: " + e);
        }
    }
}