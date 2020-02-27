package origin;

public class Entry {
    public String name, initials, teleExtend;

    public void  parseToEntry(String line){
        String[] split = line.split(",");
        this.name = split[0];
        this.initials = split[1].toUpperCase();
        this.teleExtend = split[2].replaceAll("[^\\d]", "");

    }
    public String toString(){

        return this.name + "," + this.initials + "," + this.teleExtend + "\n";
    }
}
