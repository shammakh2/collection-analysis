package test;
import origin.ArrayDirectory;
import origin.Entry;

public class testArrays {
    static ArrayDirectory testInit = new ArrayDirectory();
    public static void testInsert(){
        String line = "Testdata,T.t,00509";
        Entry entry = new Entry();
        entry.parseToEntry(line);
        testInit.insertEntry(entry);
        assert testInit.toArrayList().size() == 1;

        line = "Testdata2,T.t,00000";
        entry = new Entry();
        entry.parseToEntry(line);
        testInit.insertEntry(entry);
        assert testInit.toArrayList().size() == 2;

        line = "Testdata3,T.t,99999";
        entry = new Entry();
        entry.parseToEntry(line);
        testInit.insertEntry(entry);
        assert testInit.toArrayList().size() == 3;
    }

    public static void testDeleteByName() {
        testInit.deleteEntryUsingName("Testdata");
        assert testInit.toArrayList().size() == 2;
    }

    public static void testDeleteByExtension() {
        testInit.deleteEntryUsingExtension("00000");
        assert testInit.toArrayList().size() == 1;
    }

    public static void testUpdateAndLookup(){
        testInit.updateExtensionUsingName("Testdata3", "65665");
        assert testInit.lookupExtension("Testdata3").equals("65665");
    }

        public static void main(String[] args){
        testInsert();
        testDeleteByName();
        testDeleteByExtension();
        testUpdateAndLookup();
    }
}
