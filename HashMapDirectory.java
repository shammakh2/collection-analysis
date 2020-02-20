import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HashMapDirectory implements Directory {
    private static HashMap<String, Entry> nameDrivenDatabase =  new HashMap<>();
    private static HashMap<String, Entry> extensionDrivenDatabase =  new HashMap<>();


    public void insertEntry(Entry entre){
        Output.size(entre);
        if(!(nameDrivenDatabase.containsKey(entre.name)) && !(extensionDrivenDatabase.containsKey(entre.teleExtend))) {
            nameDrivenDatabase.put(entre.name, entre);
            extensionDrivenDatabase.put(entre.teleExtend, entre);
        }else{
            System.out.println("Entry already exists in HashMapDirectory.");
        }

    }

    public void deleteEntryUsingName(String sur){
            Entry edit = nameDrivenDatabase.remove(sur);
            if (edit == null) {
                System.out.printf("There is no entry with the name '%s' in HashMapDirectory\n", sur);
                return;
            }
            extensionDrivenDatabase.remove(edit.teleExtend);
    }


    public void deleteEntryUsingExtension(String yolk){
            Entry edit = extensionDrivenDatabase.remove(yolk);
            if (edit == null) {
                System.out.printf("There is no entry with the name '%s' in HashMapDirectory\n", yolk);
                return;
            }
            nameDrivenDatabase.remove(edit.name);
    }


    public void updateExtensionUsingName(String surname, String gatcha){
            Entry hashX = nameDrivenDatabase.remove(surname);
            if (hashX == null) {
                System.out.printf("There is no entry with the name '%s' in HashMapDirectory\n", surname);
                return;
            }
            extensionDrivenDatabase.remove(hashX.teleExtend);
            hashX.teleExtend = gatcha;
            nameDrivenDatabase.put(hashX.name, hashX);
            extensionDrivenDatabase.put(hashX.teleExtend, hashX);
    }


    public String lookupExtension(String surname){
            Entry hashX = nameDrivenDatabase.get(surname);
            if (hashX != null) {
                return hashX.teleExtend;
            }
            return null;
    }


    public List<Entry> toArrayList(){
        return new ArrayList<Entry>(extensionDrivenDatabase.values());
    }

    public void bugging(){
        System.out.println(nameDrivenDatabase.entrySet());
    }
}
