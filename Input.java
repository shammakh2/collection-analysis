import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Input {
    static ArrayDirectory init = new ArrayDirectory();
    static ArrayListDirectory initList = new ArrayListDirectory();
    static HashMapDirectory initHash = new HashMapDirectory();
    static Directory act;
    static boolean all = false;
    private static Scanner path = new Scanner(System.in);

    public static String gitMahDir(){
        System.out.println("Type in the directory you want to use for this task \n 'a' for Array \n 'al' for arraylist \n 'h' for hashmaps \n 'all' for all directories");
        String tcase = path.next();
        switch (tcase.toLowerCase()){
            case "a":
                act = init;
                break;
            case "al":
                act = initList;
                break;
            case "h":
                act = initHash;
                break;
            case "all":
            default:
                all = true;

        }
        return null;
    }

    public static String loadFile(){
        System.out.println("Enter the path of the csv file that you want to load.");
        String disPath = path.next();
        return disPath;
    }

    public static void myDad(String cacio){
        String com;
        Entry humanact;
        switch (cacio) {
            case "help":
                System.out.println("'view' \n --- Print directory in form of a table");
                System.out.println();
                System.out.println("'insert' \n --- Insert a record into a directory");
                System.out.println();
                System.out.println("'delByName' \n --- Delete an entry by name in a directory");
                System.out.println();
                System.out.println("'delByExtension' \n --- Delete an entry by extension in a Directory");
                System.out.println();
                System.out.println("'upd-extByName' \n --- Update an entry extension by using surname");
                System.out.println();
                System.out.println("'lookupByName' \n --- Lookup extension by name");
                System.out.println();

                break;

            case "insert":
                gitMahDir();
                System.out.println("Type in the entry you want to insert and separate the elements using comas \n Eg: surname,Initials,00000");
                com = path.next();
                if (all) {
                    humanact = new Entry();
                    Entry humanact2 = new Entry();
                    Entry humanact3 = new Entry();
                    humanact.parseToEntry(com);
                    init.insertEntry(humanact);
                    initList.insertEntry(humanact2);
                    initHash.insertEntry(humanact3);
                    all = false;
                } else {
                    humanact = new Entry();
                    humanact.parseToEntry(com);
                    act.insertEntry(humanact);
                }
                break;

            case "del":

                break;

            case "delByName":
                gitMahDir();
                System.out.println("Type in the exact surname of the entry you want to delete");
                com = path.next();
                if (all) {
                    init.deleteEntryUsingName(com);
                    initList.deleteEntryUsingName(com);
                    initHash.deleteEntryUsingName(com);
                    all = false;
                } else {
                    act.deleteEntryUsingName(com);
                }
                break;

            case "delByExtension":
                gitMahDir();
                System.out.println("Type in the exact extension of the entry you want to delete");
                com = path.next();
                if (all) {
                    init.deleteEntryUsingExtension(com);
                    initList.deleteEntryUsingExtension(com);
                    initHash.deleteEntryUsingExtension(com);
                    all = false;
                } else {
                    act.deleteEntryUsingExtension(com);
                }
                break;

            case "upd-extByName":
                gitMahDir();
                System.out.println("Type in the exact surname of the entry you want to update");
                com = path.next();
                System.out.println("Type in the new extension to update the entry");
                String update = path.next();

                if (all) {
                    init.updateExtensionUsingName(com, update);
                    initList.updateExtensionUsingName(com, update);
                    initHash.updateExtensionUsingName(com, update);
                    all = false;
                } else {
                    act.updateExtensionUsingName(com, update);;
                }
                break;

            case "lookupByName":
                gitMahDir();
                System.out.println("Type in the exact name to look up the extension");
                com = path.next();
                if (all) {
                    String l1 = init.lookupExtension(com);
                    String l2 = initList.lookupExtension(com);
                    String l3 = initHash.lookupExtension(com);
                    if (l1 == null){
                        System.out.printf("There is no entry with the name '%s' in ArrayDirectory\n", com);

                    }else{
                        System.out.printf("Entry with name '%s' has extension '%s' in ArrayDirectory\n", com, l1);
                    }
                    if (l2 == null){
                        System.out.printf("There is no entry with the name '%s' in ArrayListDirectory\n", com);
                    }else{
                        System.out.printf("Entry with name '%s' has extension '%s' in ArrayListDirectory\n", com, l2);
                    }
                    if (l3 == null){
                        System.out.printf("There is no entry with the name '%s' in HashMapDirectory\n", com);
                    }else{
                        System.out.printf("Entry with name '%s' has extension '%s' in HashMapDirectory\n", com, l3);
                    }
                    all = false;
                } else {
                    String l = act.lookupExtension(com);
                    if ( l == null){
                        System.out.printf("There is no entry with the name '%s' in HashMapDirectory\n", com);
                    }else{
                        System.out.printf("Entry with name '%s' has extension '%s' in HashMapDirectory\n", com, l);

                    }
                }
                break;

            case "view":
                gitMahDir();
                if (all) {
                    System.out.println("Array Table");
                    Output.printer(init);
                    System.out.println("\n");
                    System.out.println("ArrayList Table");
                    Output.printer(initList);
                    System.out.println("\n");
                    System.out.println("HashMap Table");
                    Output.printer(initHash);
                    all = false;
                } else {
                    Output.printer(act);
                }
                break;



        }
    }

    public static void main(String[] args){
        try {
            FileReader file = new FileReader(loadFile());
            BufferedReader br = new BufferedReader(file);
            String line;
            while ((line = br.readLine()) != null) {
                Entry entryObj = new Entry();
                Entry entryListObj = new Entry();
                Entry entryHashObj = new Entry();
                entryObj.parseToEntry(line);
                entryListObj.parseToEntry(line);
                entryHashObj.parseToEntry(line);
                init.insertEntry(entryObj);
                initList.insertEntry(entryListObj);
                initHash.insertEntry(entryHashObj);
            }
            while(true) {
                System.out.println("Enter a command or type in 'help' to get a list of commands.");
                myDad(path.next());
            }
//            Entry tester = initList.database.get(0);
//            if (init.database[0] == tester){
//                init.database[0] = null;
//                System.out.println(tester.name);
//                System.out.println(init.database[0]);
//            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
}
