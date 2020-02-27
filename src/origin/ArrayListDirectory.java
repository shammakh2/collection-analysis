package origin;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDirectory implements Directory{
    public ArrayList<Entry> database = new ArrayList<Entry>();


    public void insertEntry(Entry entry){
        for (Entry x: database){
            if (x.name.equals(entry.name) || x.teleExtend.equals(entry.teleExtend)){
                System.out.println("Entry already exists in ArrayListDirectory");
                return;
            }
        }
        Output.size(entry);
        database.add(entry);
    }

    public void deleteEntryUsingName(String forget){
        if (database.removeIf(n -> (n.name.equals(forget)))) {
            return;
        }
            System.out.printf("There is no entry with the name '%s' in ArrayListDirectory\n", forget);
    }

    public void deleteEntryUsingExtension(String unique){
        if (database.removeIf(x -> (x.teleExtend.equals(unique)))){
            return;
        }
            System.out.printf("There is no entry with the telephone extension '%s' in ArrayListDirectory\n", unique);
    }


    public void updateExtensionUsingName(String surname, String replace){
        for (Entry x: database) {
            if (x.name.equals(surname)) {
                x.teleExtend = replace;
                return;
            }
        }
            System.out.printf("There is no entry with the name '%s' in ArrayListDirectory\n", surname);
    }


    public String lookupExtension(String surname){
        for (Entry x: database) {
            if (x.name.equals(surname)) {
                return x.teleExtend;
            }
        }
            System.out.printf("There is no entry with the name '%s' in ArrayListDirectory\n", surname);
        return null;
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
