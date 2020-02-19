import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllStandPoint implements Directory{
    static final String name = "a";
    public Entry[] database = new Entry[0];


    public void insertEntry(Entry entry){

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


    public List<Entry> toArrayList(){
        return new ArrayList<>();
    }


}
