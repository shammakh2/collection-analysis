import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class ArrayDirectory implements Directory{

    private Entry[] database;
    private int inserter = 0;

    public ArrayDirectory(int length){
        this.database = new Entry[length];
    }

    public void insertEntry(Entry entry){
        database[inserter] = entry;
        inserter++;
        int counter = 0;
        for (Entry x: database){
            if (x != null){
                System.out.printf("%s\t%s\t%s", x.name,x.initials,x.teleExtend);
                counter++;
            }
        }
        System.out.println(counter);
    }

    public void deleteEntryUsingName(String surname){

    }


    public void deleteEntryUsingExtension(String number){

    }


    public void updateExtensionUsingName(String surname, String newNumber){

    }


    public String lookupExtension(String surname){
        return "";

    }

/*
    public List<Entry> toArrayList(){

    }
*/



}
