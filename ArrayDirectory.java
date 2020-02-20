import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDirectory implements Directory{
    public static Entry[] database = new Entry[0];


    public void insertEntry(Entry ent){
        for (Entry x: database){
            if (x.name.equals(ent.name) || x.teleExtend.equals(ent.teleExtend)){
                System.out.println("Entry already exists in ArrayDirectory");
                return;
            }
        }
        Output.size(ent);
        Entry[] update = Arrays.copyOf(database, database.length+1);
        update[update.length-1] = ent;
        database = update;
    }

    public void deleteEntryUsingName(String namae){
        int deletable = 0;
        for (Entry x: database) {
            if (x.name.equals(namae)) {
                deletable++;
                x.name = null;
            }
        }
        if (deletable > 0) {
            Entry[] update = new Entry[database.length - deletable];
            int i = 0;
            for (Entry x : database) {
                if (x.name != null) {
                    update[i] = x;
                    i++;
                }
            }
            database = update;
        }
        if (deletable == 0) {
            System.out.printf("There is no entry with the name '%s' in ArrayDirectory\n", namae);
        }
    }


    public void deleteEntryUsingExtension(String numre) {
        int deletable = 0;
        for (Entry x : database) {
            if (x.teleExtend.equals(numre)) {
                deletable++;
                x.teleExtend = null;
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
        } else {
            System.out.printf("There is no entry with the name '%s' in ArrayDirectory\n", numre);
        }
    }


    public void updateExtensionUsingName(String surname, String newmre){
        for (Entry x: database) {
            if (x.name.equals(surname)) {
                x.teleExtend = newmre;
                return;
            }
        }
            System.out.printf("There is no entry with the name '%s'\n", surname);
    }


    public String lookupExtension(String surname){
        for (Entry x: database) {
            if (x.name.equals(surname)) {
                return x.teleExtend;
            }
        }
        System.out.printf("There is no entry with the name '%s'\n", surname);
        return "";
    }


    public List<Entry> toArrayList(){
        return new ArrayList<Entry>(Arrays.asList(database));
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
