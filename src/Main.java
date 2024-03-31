public class Main {
    public static void main(String[] args) {
        new WriteObject().saveGame(new GameProgress(1,2,3,4),"C://Games//savegames//save3.dat");
        new WriteObject().saveGame(new GameProgress(2,3,4,5),"C://Games//savegames//save3.dat");
        new WriteObject().saveGame(new GameProgress(3,4,5,6),"C://Games//savegames//save3.dat");
        new WriteObject().zipFiles("C://Games//savegames//save3.dat","C://Games//savegames//save3.zip");
    }
}
