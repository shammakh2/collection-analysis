import java.util.List;

public class Output {
    public static int surSizo = 10;
    public static int initSizo = 8;

    public static void size(Entry entry){
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
        System.out.format("+%" + (2+surSizo) + "s+%"+ (2+initSizo) +"s+%12s+\n", header(surSizo+2), header(initSizo+2), header(12));
        System.out.format("| %"+ surSizo +"s | %" + initSizo + "s | %10s |\n", "Name", "Initials", "Extensions");
        System.out.format("+%" + (2+surSizo) + "s+%"+ (2+initSizo) +"s+%12s+\n", header(surSizo+2), header(initSizo+2), header(12));
        for (Entry entry : list) {
            System.out.format("| %" +surSizo+ "s | %"+initSizo+"s | %10s |\n", entry.name, entry.initials, entry.teleExtend);
        }
        System.out.format("+%" + (2+surSizo) + "s+%"+ (2+initSizo) +"s+%12s+\n", header(surSizo+2), header(initSizo+2), header(12));
    }
}
