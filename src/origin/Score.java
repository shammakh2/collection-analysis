package origin;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Score {
    private static final String GEN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";
    public static final int ITERTEST = 10000;

    private static double[][] timeAvg = new double[3][5];
    private static double[][][] times = new double[3][5][ITERTEST];
    private static StopWatch cantTouchThis = new StopWatch();
    public static int dir = 0;

    public static void calculated(Directory d){
        PrintStream main = System.out;
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        }));
        boostation(d, true);
        meltation(d);
        breach(d);
        System.setOut(main);
    }

    public static void boostation(Directory d, boolean isTesting){
        dirSet(d);
        List<Entry> temp = d.toArrayList();
        while(temp.size() > 0){
            d.deleteEntryUsingName(temp.get(0).name);
            temp = d.toArrayList();
        }
        int test = 0;
        Random random = new Random();
        for(int i=0; i < ITERTEST; i++) {

            String convertedSur = randomGen(8 + random.nextInt(13));
            String convertedInit = randomGen(3 + random.nextInt(8));

            Entry entry = new Entry();

            entry.parseToEntry(convertedSur + "," + convertedInit + "," + extensionGen());

            if (isTesting) {
                cantTouchThis.start();
                d.insertEntry(entry);
                cantTouchThis.stop();

                times[dir][test][i] = cantTouchThis.getElapsedTime();
                cantTouchThis.reset();
            }else{
                d.insertEntry(entry);
            }

        }
    }
    public static void meltation(Directory d){
        dirSet(d);
        int test = 1;
        boostation(d, false);
        for(int i = 0; i < ITERTEST; i++){
            List<Entry> re = d.toArrayList();
            int index = (int)(Math.random()*re.size());
            Entry delStep = re.get(index);
            cantTouchThis.start();
            d.deleteEntryUsingName(delStep.name);
            cantTouchThis.stop();
            times[dir][test][i] = cantTouchThis.getElapsedTime();
            cantTouchThis.reset();
            if(re.size() < 2){
                boostation(d, false);
            }
        }


        test = 2;
        boostation(d, false);
        cantTouchThis.reset();

        for(int i = 0; i < ITERTEST; i++){
            List<Entry> re = d.toArrayList();
            int index = (int)(Math.random()*re.size());
            Entry delStep = re.get(index);
            cantTouchThis.start();
            d.deleteEntryUsingExtension(delStep.teleExtend);
            cantTouchThis.stop();
            times[dir][test][i] = cantTouchThis.getElapsedTime();
            cantTouchThis.reset();
            if(re.size() < 2){
                boostation(d, false);
            }
        }

    }

    public static void breach(Directory d){
        dirSet(d);
        boostation(d, false);
        int test = 3;
        for(int i = 0; i < ITERTEST; i++){
            List<Entry> re = d.toArrayList();
            int index = (int) (Math.random()*re.size());
            cantTouchThis.start();
            d.updateExtensionUsingName(re.get(index).name,"" + extensionGen());
            cantTouchThis.stop();
            times[dir][test][i] = cantTouchThis.getElapsedTime();
            cantTouchThis.reset();

        }
        test = 4;
        for(int i = 0; i < ITERTEST; i++){
            List<Entry> re = d.toArrayList();
            int index = (int) (Math.random()*re.size());
            cantTouchThis.start();
            d.lookupExtension(re.get(index).name);
            cantTouchThis.stop();
            times[dir][test][i] = cantTouchThis.getElapsedTime();
            cantTouchThis.reset();
        }

    }


    public static void pront(){
        for (int c = 0; c<3; c++) {
            for (int i = 0; i < 5; i++) {
                double sum = 0;
                for (int index = 0; index < times[c][i].length; index++) {
                    sum += times[c][i][index];
                }
                timeAvg[c][i] = sum / (times[c][i].length);
            }
        }

        for(int i = 0; i<3;i++) {
            for(int j = 0; j<5;j++) {
                Arrays.sort(times[i][j]);
            }
        }
        System.out.format("                    %61s                    \n", "Comparison: Time per Operation for directories in nanoseconds");
        System.out.println();
        System.out.format("                                  %20s     %20s     %20s \n", "Arrays", "ArrayList", "HashMaps");
        System.out.println();
        System.out.format("This is slowest insert time       %20.0f   %20.0f   %20.0f \n", times[0][0][times[0][0].length - 1], times[1][0][times[1][0].length - 1], times[2][0][times[2][0].length - 1]);
        System.out.format("This is fastest insert time       %20.0f   %20.0f   %20.0f \n", times[0][0][0], times[1][0][0], times[2][0][0]);
        System.out.format("This is average insert time       %20.0f   %20.0f   %20.0f \n", timeAvg[0][0], timeAvg[1][0], timeAvg[2][0]);
        System.out.println();
        System.out.format("This is slowest delByName time    %20.0f   %20.0f   %20.0f \n", times[0][1][times[0][1].length - 1], times[1][1][times[1][1].length - 1], times[2][1][times[2][1].length - 1]);
        System.out.format("This is fastest delByName time    %20.0f   %20.0f   %20.0f \n", times[0][1][0], times[1][1][0], times[2][1][0]);
        System.out.format("This is average delByName time    %20.0f   %20.0f   %20.0f \n",timeAvg[0][1], timeAvg[1][1], timeAvg[2][1]);
        System.out.println();
        System.out.format("This is slowest delByExt time     %20.0f   %20.0f   %20.0f \n", times[0][2][times[0][2].length - 1], times[1][2][times[1][2].length - 1], times[2][2][times[2][2].length - 1]);
        System.out.format("This is fastest delByExt time     %20.0f   %20.0f   %20.0f \n", times[0][2][0] , times[1][2][0], times[2][2][0]);
        System.out.format("This is average delByExt time     %20.0f   %20.0f   %20.0f \n", timeAvg[0][2], timeAvg[1][2], timeAvg[2][2]);
        System.out.println();
        System.out.format("This is slowest updExt time       %20.0f   %20.0f   %20.0f \n", times[0][3][times[0][3].length - 1], times[1][3][times[1][3].length - 1],times[2][3][times[2][3].length - 1]);
        System.out.format("This is fastest updExt time       %20.0f   %20.0f   %20.0f \n", times[0][3][0],times[1][3][0], times[2][3][0]);
        System.out.format("This is average updExt time       %20.0f   %20.0f   %20.0f \n", timeAvg[0][3], timeAvg[1][3], timeAvg[2][3]);
        System.out.println();
        System.out.format("This is slowest lookup time       %20.0f   %20.0f   %20.0f \n",times[0][4][times[0][4].length - 1],times[1][4][times[1][4].length - 1], times[2][4][times[2][4].length - 1]);
        System.out.format("This is fastest lookup time       %20.0f   %20.0f   %20.0f \n",times[0][4][0],times[1][4][0], times[2][4][0]);
        System.out.format("This is average lookup time       %20.0f   %20.0f   %20.0f \n", timeAvg[0][4],timeAvg[1][4],timeAvg[2][4]);

    }

    public static String randomGen(int i){

        StringBuilder selection = new StringBuilder(i);

        for (int x = 0; x < i; x++){
            int get = (int)(GEN.length() * Math.random());
            selection.append(GEN.charAt(get));

        }
        return selection.toString();
    }
    public static int extensionGen(){
        int exten = ITERTEST +( (int) Math.ceil(Math.random()*90000));
        return exten;
    }
    public static void dirSet(Directory d){
        switch (d.getClass().getCanonicalName()){
            case "origin.ArrayDirectory":
                dir = 0;
                break;
            case "origin.ArrayListDirectory":
                dir = 1;
                break;
            case "origin.HashMapDirectory":
                dir = 2;
                break;

        }
    }
}
