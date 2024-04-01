public class Main {
    public static void main(String[] args) {
        new WriteObject().saveGame(new GameProgress(1,2,3,4),"C://Games//savegames//save4.dat");
        new WriteObject().zipFiles("C://Games//savegames//save4.dat","C://Games//savegames//save4.zip");
    }
}
