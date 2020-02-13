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
            ArrayListDirectory initList = new ArrayListDirectory();
            file.close();
            file = new FileReader("./src/test_data.csv");
            br = new BufferedReader(file);
            while ((line = br.readLine()) != null) {
                Entry entryObj = new Entry();
                Entry entryListObj = new Entry();
                entryObj.parseToEntry(line);
                entryListObj.parseToEntry(line);
                init.insertEntry(entryObj);
                initList.insertEntry(entryListObj);
            }

            init.deleteEntryUsingName("Amner");
            init.deleteEntryUsingName("Amner");
            init.deleteEntryUsingExtension("49521");
            init.deleteEntryUsingExtension("49521");
            init.updateExtensionUsingName("Ferro", "00000");
            init.lookupExtension("Mayow");
            init.lookupExtension("Prott");
            System.out.println(init.toArrayList().size());

            System.out.println("ARRAY LISTTTTTTT");
            initList.deleteEntryUsingName("Amner");
            initList.deleteEntryUsingName("Amner");
            initList.deleteEntryUsingExtension("49521");
            initList.deleteEntryUsingExtension("49521");
            initList.updateExtensionUsingName("Ferro", "00000");
            initList.lookupExtension("Mayow");
            initList.lookupExtension("Prott");
            System.out.println(initList.toArrayList().size());



        }catch (IOException ie){
            System.out.println(ie);
        }
    }
}

//ADD VALIDATION, CORRECTNESS TESTING AND EYE CANDY
//Search and test premade entries
