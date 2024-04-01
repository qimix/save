import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        new WriteObject().saveGame(new GameProgress(1,2,3,4),"C://Games//savegames//save1.dat");
        new WriteObject().saveGame(new GameProgress(2,3,4,5),"C://Games//savegames//save2.dat");
        new WriteObject().saveGame(new GameProgress(3,4,5,6),"C://Games//savegames//save3.dat");
        new WriteObject().zipFiles(Arrays.asList(new File("C://Games//savegames//").listFiles()),"C://Games//savegames//");
    }
}
