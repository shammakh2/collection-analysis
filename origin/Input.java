package origin;

import java.io.*;
import java.util.Scanner;

public class Input {
    static ArrayDirectory init = new ArrayDirectory();
    static ArrayListDirectory initList = new ArrayListDirectory();
    static HashMapDirectory initHash = new HashMapDirectory();
    static Directory act;
    static File saved = new File(System.getProperty("java.class.path") + "/save.cfg");
    public static boolean all = false;
    public static Scanner path = new Scanner(System.in);

    public static void gitMahDir() {
        System.out.println("Type in the directory you want to use for this task \n 'a' for Array \n 'al' for arraylist \n 'h' for hashmaps \n 'all' for all directories");
        String tcase = path.next();
        switch (tcase.toLowerCase()) {
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
    }

    public static String saveChk() {
        if (saved.exists()) {
            try {
                FileReader savedFile = new FileReader(saved);
                BufferedReader savedBuffer = new BufferedReader(savedFile);
                String l;
                l = savedBuffer.readLine();
                if (l.matches("date.*")) {
                        return l.replaceAll("date:", "");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        return "false";
    }

    public static void saveLoad() {
        try {
                FileReader savedFile = new FileReader(saved);
                BufferedReader savedBuffer = new BufferedReader(savedFile);
                String l;
                while ((l = savedBuffer.readLine()) != null) {
                    if (l.equals("end")) {
                        break;
                    }
                    if (l.split(",").length == 3) {
                        Entry entryObj = new Entry();
                        entryObj.parseToEntry(l);
                        init.insertEntry(entryObj);
                    }
                }
                while ((l = savedBuffer.readLine()) != null) {
                    if (l.equals("end")) {
                        break;
                    }
                    if (l.split(",").length == 3) {
                        Entry entryListObj = new Entry();
                        entryListObj.parseToEntry(l);
                        initList.insertEntry(entryListObj);
                    }
                }
                while ((l = savedBuffer.readLine()) != null) {
                    if (l.split(",").length == 3) {
                        Entry entryHashObj = new Entry();
                        entryHashObj.parseToEntry(l);
                        initHash.insertEntry(entryHashObj);
                    }
                }
        } catch (IOException e) {
        }
    }

    public static String loadFile() {
        String chk = saveChk();
        if (!chk.equals("false")) {
            System.out.println("A session was saved on" + chk + ". Would you like to load that session? Y(yes)/N(no)");
            if (path.next().equalsIgnoreCase("y")) {
                saveLoad();
                return null;
            }
        }
            String disPath;
            while (true) {
                System.out.println("Enter the path of the csv file that you want to load.");
                disPath = path.next();
                File test = new File(disPath);
                if (!test.exists()) {
                    System.out.println("File not found, Do you wish to start with an empty directory? Y/N for yes/no");
                    String bool = path.next();
                    if (bool.equalsIgnoreCase("Y")) {
                        return null;
                    } else if (bool.equalsIgnoreCase("N")) {
                        System.out.println("Do you want to start with default test records in directories? Y/N for yes/no");
                        bool = path.next();
                        if (bool.equalsIgnoreCase("Y")) {
                            disPath = "src/test_data.csv";
                            return disPath;
                        }
                    }
                } else {
                    return disPath;
                }
            }
    }

    public static void myDad(String cacio) throws End{
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
                System.out.println("'test' \n --- Do a performance analysis of all 3 directories and give an output. Then gives an option to save the data");
                System.out.println();
                System.out.println("'save' \n --- Save you session. You can then load it later.");
                System.out.println();
                System.out.println("'loadSave' \n --- Load previously saved session. (This will overwrite current session");
                System.out.println();
                System.out.println("'deleteSave' \n --- Delete previously saved session");
                System.out.println();
                System.out.println("'terminate' \n --- End the program");
                System.out.println();

                break;

            case "insert":
                gitMahDir();
                while (true) {
                    path.reset();
                    System.out.println("Type in the entry you want to insert and separate the elements using commas \n Eg: surname,Initials,00000");
                    com = path.nextLine();
                    if (com.split(",").length == 3) {
                        if (com.split(",")[2].replaceAll("[^\\d]", "").length() == 5) {
                            break;
                        }
                    }
                    System.out.println("Make sure extensions are 5 digits long and the data is in the right format");
                }
                if (all) {
                    humanact = new Entry();
                    Entry humanact2 = new Entry();
                    Entry humanact3 = new Entry();
                    humanact.parseToEntry(com);
                    humanact2.parseToEntry(com);
                    humanact3.parseToEntry(com);
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
                    act.updateExtensionUsingName(com, update);
                    ;
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
                    if (l1 == null) {
                        System.out.printf("There is no entry with the name '%s' in ArrayDirectory\n", com);

                    } else {
                        System.out.printf("Entry with name '%s' has extension '%s' in ArrayDirectory\n", com, l1);
                    }
                    if (l2 == null) {
                        System.out.printf("There is no entry with the name '%s' in ArrayListDirectory\n", com);
                    } else {
                        System.out.printf("Entry with name '%s' has extension '%s' in ArrayListDirectory\n", com, l2);
                    }
                    if (l3 == null) {
                        System.out.printf("There is no entry with the name '%s' in HashMapDirectory\n", com);
                    } else {
                        System.out.printf("Entry with name '%s' has extension '%s' in HashMapDirectory\n", com, l3);
                    }
                    all = false;
                } else {
                    String l = act.lookupExtension(com);
                    if (l == null) {
                        System.out.printf("There is no entry with the name '%s' in HashMapDirectory\n", com);
                    } else {
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
            case "test":
                System.out.println("Please wait while tests are being performed. This may take a moment");
                Score.calculated(init);
                Score.calculated(initList);
                Score.calculated(initHash);
                Score.pront();

                System.out.println("Do you want to save the performance analysis report on your computer? Y/N for yes/no");
                if (path.next().equalsIgnoreCase("y")) {
                    String write;
                    System.out.println("Please enter a location to output file");
                    write = path.next();
                    Output.outputTestFile(write);
                }
                break;
            case "save":
                Output.saveData(new Directory[]{init, initList, initHash});
                break;
            case "loadSave":
                String chk = saveChk();
                if (!chk.equals("false")) {
                    System.out.println("Loading in previous save will cause you to lose your current data. Are you sure you want to continue? Y(for Yes)/N(for No)");
                    if (path.next().equalsIgnoreCase("y")) {
                        init = new ArrayDirectory();
                        initList = new ArrayListDirectory();
                        initHash = new HashMapDirectory();
                        saveLoad();
                    }
                }else{
                    System.out.println("There is no save available.");

                }
                break;
            case "deleteSave":
                    if (saved.exists()) {
                        System.out.println("Are you sure you want to delete the save? Y(for Yes)/N(for No)");
                        if (path.next().equalsIgnoreCase("y")) {
                            saved.delete();
                        }
                    } else {
                        System.out.println("No save currently exists");
                    }
                break;
            case "terminate":
                System.out.println("Do you want to save before terminating? Y(for Yes)/N(for No)");
                if (path.next().equalsIgnoreCase("y")) {
                    Output.saveData(new Directory[]{init, initList, initHash});
                }
                throw new End();

        }
    }

    public static void lesGO() {
        try {
            String data = loadFile();
            if (data != null) {
                FileReader file = new FileReader(data);
                BufferedReader br = new BufferedReader(file);
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.split(",").length == 3) {
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
                }
            }
            try {

            while(true) {
                System.out.println("Enter a command or type in 'help' to get a list of commands.");
                myDad(path.next());
            }
            }catch(End e){

                }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}

class End extends Exception{
    public End(){
    }
}
