package origin;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Output {
    public static int surSizo = 10;
    public static int initSizo = 8;

    public static void size(Entry entry) {
        int sursize = entry.name.length();
        int initsize = entry.initials.length();

        if (sursize > surSizo) {
            surSizo = sursize;
        }
        if (initsize > initSizo) {
            initSizo = initsize;
        }
    }

    public static String header(int size) {
        String strink = "";
        for (int i = 0; i < size; i++) {
            strink += "-";
        }
        return strink;
    }

    public static void printer(Directory object) {
        List<Entry> list = object.toArrayList();
        System.out.format("+%" + (2 + surSizo) + "s+%" + (2 + initSizo) + "s+%12s+\n", header(surSizo + 2), header(initSizo + 2), header(12));
        System.out.format("| %" + surSizo + "s | %" + initSizo + "s | %10s |\n", "Name", "Initials", "Extensions");
        System.out.format("+%" + (2 + surSizo) + "s+%" + (2 + initSizo) + "s+%12s+\n", header(surSizo + 2), header(initSizo + 2), header(12));
        for (Entry entry : list) {
            System.out.format("| %" + surSizo + "s | %" + initSizo + "s | %10s |\n", entry.name, entry.initials, entry.teleExtend);
        }
        System.out.format("+%" + (2 + surSizo) + "s+%" + (2 + initSizo) + "s+%12s+\n", header(surSizo + 2), header(initSizo + 2), header(12));
    }

    public static void outputTestFile(String paco) {
        PrintStream main = System.out;
        try {
            PrintStream file = new PrintStream(new File(paco));
            System.setOut(file);
            Score.pront();
            file.flush();
            file.close();
            System.setOut(main);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveData(Directory[] all) {
        String chk = Input.saveChk();
        if (!chk.equals("false")) {
            System.out.println("There is already a save made at time" + chk + ". Do you want to overwrite it? Y(yes)/N(no)?");
            Scanner temp = new Scanner(System.in);
            String test = temp.nextLine();
            if (test.equalsIgnoreCase("n")){
                System.out.println("Data not saved");
                return;
            }
        }
            DateTimeFormatter utest = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            String date = LocalDateTime.now().format(utest);

            try {
                File saveChk = new File(System.getProperty("java.class.path") + "/save.cfg");
                FileWriter testWriter = new FileWriter(saveChk);
                testWriter.write("date: " + date + "\n");

                for (Entry x : all[0].toArrayList()) {
                    String formatted = String.format("%s", x);
                    testWriter.write(formatted);
                }
                testWriter.write("end\n");
                for (Entry x : all[1].toArrayList()) {
                    String formatted = String.format("%s", x);
                    testWriter.write(formatted);
                }
                testWriter.write("end\n");
                for (Entry x : all[2].toArrayList()) {
                    String formatted = String.format("%s", x);
                    testWriter.write(formatted);
                }
                testWriter.flush();
                testWriter.close();
                System.out.println("Saved");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
