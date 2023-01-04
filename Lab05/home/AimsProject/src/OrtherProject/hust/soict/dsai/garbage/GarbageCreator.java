package OrtherProject.hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe";	// test.exe is the name or path to an executable file
        byte[] inputBytes = { 0 };
        long startTime,endTime ;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();

//		String outputString = "";
//		for(byte b: inputBytes) {
//			outputString += (char)b;
//		}

        StringBuilder outputStringBuilder = new StringBuilder();
        for(byte b : inputBytes) {
            outputStringBuilder.append((char)b);
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}
