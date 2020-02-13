import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashMapDirectory implements Directory {

    private HashMap<String, Entry> nameDrivenDatabase =  new HashMap<>();
    private HashMap<String, Entry> extensionDrivenDatabase =  new HashMap<>();


    public void insertEntry(Entry entry){
        nameDrivenDatabase.put(entry.name, entry);
        nameDrivenDatabase.put(entry.teleExtend, entry);
        System.out.println(nameDrivenDatabase.size());
        System.out.println(extensionDrivenDatabase.size());
    }

    public void deleteEntryUsingName(String surname){
        boolean deletable = nameDrivenDatabase.containsKey(surname);
        if (deletable) {
            Entry edit = nameDrivenDatabase.remove(surname);
            extensionDrivenDatabase.remove(edit.teleExtend)
            System.out.printf("Entry with name '%s' has been deleted\n", surname);
        }else{
            System.out.printf("There is no entry with the name '%s'\n", surname);
        }
    }


    public void deleteEntryUsingExtension(String number){
        int deletable = 0;
        for (Entry x: database) {
            if (x.teleExtend.equals(number)) {
                deletable++;
                x.teleExtend = null;
                System.out.printf("Entry with name '%s' has been deleted\n", number);
            }
        }
        if (deletable > 0) {
            Entry[] update = new Entry[database.length - deletable];
            int i = 0;
            for (Entry x : database) {
                if (x.teleExtend != null) {
                    update[i] = x;
                    i++;
                }
            }
            database = update;
        }
        if (deletable == 0) {
            System.out.printf("There is no entry with the name '%s'\n", number);
        }
        System.out.println(database.length);
    }


    public void updateExtensionUsingName(String surname, String newNumber){
        boolean changable = false;
        for (Entry x: database) {
            if (x.name.equals(surname)) {
                changable = true;
                System.out.printf("Entry with name '%s' has extension changed from '%s' to '%s'\n", surname, x.teleExtend, newNumber);
                x.teleExtend = newNumber;
            }
        }
        if (!changable) {
            System.out.printf("There is no entry with the name '%s'\n", surname);
        }
        for (Entry x: database) {
            if (x.name.equals(surname)){
                System.out.println(x);
            }
        }
    }


    public String lookupExtension(String surname){
        boolean found = false;
        for (Entry x: database) {
            if (x.name.equals(surname)) {
                found = true;
                System.out.printf("Entry with name '%s' has extension '%s'\n", x.name, x.teleExtend);
            }
        }
        if (!found) {
            System.out.printf("There is no entry with the name '%s'\n", surname);
        }
        return "";
    }


    public List<Entry> toArrayList(){
        ArrayList<Entry> conversion = new ArrayList<Entry>(Arrays.asList(database));
        return conversion;
    }

    public void bugging(){
        int counter = 0;
        for (Entry x: database){
            if (x != null){
                //System.out.println(x);
                System.out.printf("%s\t%s\t%s\n", x.name,x.initials,x.teleExtend);
                counter++;
            }
        }
        System.out.println(counter);
    }
}
