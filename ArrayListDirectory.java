import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDirectory implements Directory{
    public static ArrayList<Entry> database = new ArrayList<Entry>();


    public void insertEntry(Entry entry){
        database.add(entry);
    }

    public void deleteEntryUsingName(String surname){
        boolean deletable = false;
        if (database.removeIf(n -> (n.name.equals(surname)))) {
            deletable = true;
            System.out.printf("Entry with name '%s' has been deleted\n", surname);
        }
        if (!deletable) {
            System.out.printf("There is no entry with the name '%s'\n", surname);
        }
        System.out.println(database.size());
    }

    public void deleteEntryUsingExtension(String number){
        boolean deletable = false;
        if (database.removeIf(x -> (x.teleExtend.equals(number)))){
            deletable = true;
            System.out.printf("Entry with telephone extension '%s' has been deleted\n", number);
        }
        if (!deletable) {
            System.out.printf("There is no entry with the telephone extension '%s'\n", number);
        }
        System.out.println(database.size());
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
        return database;
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
