public class Entry {
    public String name, initials, teleExtend;

    public void  parseToEntry(String line){
        String[] split = line.split(",");
        this.name = split[0];
        this.initials = split[1];
        this.teleExtend = split[2];

    }
//    public String toString(){
//
//        return this.name + "\t" + this.initials + "\t" + this.teleExtend + "\n";
//    }
}
