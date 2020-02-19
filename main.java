import javax.swing.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("./src/mini.csv");
            BufferedReader br = new BufferedReader(file);
            String line;
            ArrayDirectory init = new ArrayDirectory();
            ArrayListDirectory initList = new ArrayListDirectory();
            HashMapDirectory initHash = new HashMapDirectory();
            while ((line = br.readLine()) != null) {
                Entry entryObj = new Entry();
                Entry entryListObj = new Entry();
                Entry entryHashObj = new Entry();
                entryObj.parseToEntry(line);
                entryListObj.parseToEntry(line);
                entryHashObj.parseToEntry(line);
                init.insertEntry(entryObj);
                initList.insertEntry(entryListObj);
                initHash.insertEntry(entryHashObj);
            }
            Output.printer(init);

            /*init.deleteEntryUsingName("Amner");
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

            System.out.println("HASHMAPPPPPPSPSPSPSPSPSPSAJFFSDFISJJFGSOIJDSGIJ");
            System.out.println(initHash.toArrayList().size());
            initHash.deleteEntryUsingName("Amner");
            initHash.deleteEntryUsingName("Amner");
            initHash.deleteEntryUsingExtension("49521");
            initHash.deleteEntryUsingExtension("49521");
            initHash.updateExtensionUsingName("Ferro", "00000");
            initHash.lookupExtension("Mayow");
            initHash.lookupExtension("Prott");
            System.out.println(initHash.toArrayList().size());*/


        } catch (IOException ie) {
            System.out.println(ie);
        }
    }
}

//ADD VALIDATION, CORRECTNESS TESTING AND EYE CANDY
//Search and test premade entries
//COntinuous environment test
//Binary Search
