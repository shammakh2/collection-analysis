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
            ArrayDirectory init = new ArrayDirectory();
            file.close();
            file = new FileReader("./src/test_data.csv");
            br = new BufferedReader(file);
            while ((line = br.readLine()) != null) {
                Entry entryObj = new Entry();
                entryObj.parseToEntry(line);
                init.insertEntry(entryObj);
            }
            init.deleteEntryUsingName("Amner");
            init.deleteEntryUsingName("Amner");
            init.deleteEntryUsingExtension("49521");
            init.deleteEntryUsingExtension("49521");
            init.updateExtensionUsingName("Ferro", "00000");

        }catch (IOException ie){
            System.out.println(ie);
        }
    }
}
