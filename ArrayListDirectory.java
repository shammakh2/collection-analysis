import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDirectory {

    private ArrayList<Entry> database = new ArrayList<Entry>();


    public void insertEntry(Entry entry){
        database.add(entry);
    }

    public void deleteEntryUsingName(String surname){
        boolean deletable = false;
        if (database.removeIf(n -> (n.name.equals(surname))) {
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
                x.teleExtend = null;
            }
            if (x.teleExtend != null) {
                update.add(x);
            }else if (x.teleExtend == null){
                x.teleExtend = newNumber;
            }
        }
        if (!changable) {
            System.out.printf("There is no entry with the name '%s'\n", surname);
        }
        database = update.toArray(new Entry[0]);
        for (Entry x: database) {
            if (x.name.equals(surname)){
                System.out.println(x);
            }
        }
    }


    public String lookupExtension(String surname){
        int counter = 0;
        for (Entry x: database){
            if (x != null){
                //System.out.println(x);
                System.out.printf("%s\t%s\t%s\n", x.name,x.initials,x.teleExtend);
                counter++;
            }
        }
        System.out.println(counter);
        return "";

    }

/*
    public List<Entry> toArrayList(){

    }
*/



}

}
