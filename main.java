import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class main {
    public static void main(String[] args){
        try {
            FileReader file = new FileReader("./src/test_data.csv");
            BufferedReader br = new BufferedReader(file);
            String line;
            int lineNum = 0;
            while ((br.readLine()) != null) {
                lineNum++;
            }
            ArrayDirectory init = new ArrayDirectory(lineNum);
            System.out.println(lineNum);
            file.close();
            file = new FileReader("./src/test_data.csv");
            br = new BufferedReader(file);
            while ((line = br.readLine()) != null) {
                Entry entryObj = new Entry();
                entryObj.parseToEntry(line);
                init.insertEntry(entryObj);
            }
        }catch (IOException ie){
            System.out.println(ie);
        }
    }
}
