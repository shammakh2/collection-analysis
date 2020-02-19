import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Output {
    public static String size() {
        String strink = "";
        for (int i = 0; i < 17; i++) {
            strink += "-";
        }
        return strink;
    }

    public static void printer(Directory object) {
        List<Entry> list = object.toArrayList();
        System.out.format("+%17s+%17s+%17s+\n", size(), size(), size());
        System.out.format("| %15s | %15s | %15s |\n", "Name", "Initials", "Extensions");
        System.out.format("+%17s+%17s+%17s+\n", size(), size(), size());
        for (Entry entry : list) {
            System.out.format("| %15s | %15s | %15s |\n", entry.name, entry.initials, entry.teleExtend);
        }
        System.out.format("+%17s+%17s+%17s+\n", size(), size(), size());
    }
}
