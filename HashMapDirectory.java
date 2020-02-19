import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashMapDirectory implements Directory {
    private static HashMap<String, Entry> nameDrivenDatabase =  new HashMap<>();
    private static HashMap<String, Entry> extensionDrivenDatabase =  new HashMap<>();


    public void insertEntry(Entry entry){
        nameDrivenDatabase.put(entry.name, entry);
        extensionDrivenDatabase.put(entry.teleExtend, entry);

    }

    public void deleteEntryUsingName(String surname){
        boolean deletable = nameDrivenDatabase.containsKey(surname);
        if (deletable) {
            Entry edit = nameDrivenDatabase.remove(surname);
            extensionDrivenDatabase.remove(edit.teleExtend);
            System.out.printf("Entry with name '%s' has been deleted\n", surname);
        }else{
            System.out.printf("There is no entry with the name '%s'\n", surname);
        }
    }


    public void deleteEntryUsingExtension(String number){
        boolean deletable = extensionDrivenDatabase.containsKey(number);
        if (deletable) {
            Entry edit = extensionDrivenDatabase.remove(number);
            nameDrivenDatabase.remove(edit.name);
            System.out.printf("Entry with name '%s' has been deleted\n", number);
        }else{
            System.out.printf("There is no entry with the name '%s'\n", number);
        }
    }


    public void updateExtensionUsingName(String surname, String newNumber){
        boolean changable = nameDrivenDatabase.containsKey(surname);
        if (changable) {
            Entry hashX = nameDrivenDatabase.get(surname);
            Entry hashY = extensionDrivenDatabase.get(hashX.teleExtend);
            hashX.teleExtend = newNumber;
            hashY.teleExtend = newNumber;
            System.out.printf("Entry with name '%s' has extension changed from '%s' to '%s'\n", surname, hashX.teleExtend, newNumber);

        }
        if (!changable) {
            System.out.printf("There is no entry with the name '%s'\n", surname);
        }
    }


    public String lookupExtension(String surname){
        boolean found = nameDrivenDatabase.containsKey(surname);
        if (found) {
            Entry hashX = nameDrivenDatabase.get(surname);

            System.out.printf("Entry with name '%s' has extension '%s'\n", hashX.name, hashX.teleExtend);
        }
        if (!found) {
            System.out.printf("There is no entry with the name '%s'\n", surname);
        }
        return "";
    }


    public List<Entry> toArrayList(){
        return new ArrayList<Entry>(extensionDrivenDatabase.values());
    }

    public void bugging(){
        System.out.println(nameDrivenDatabase.entrySet());
    }
}
