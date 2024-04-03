import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {

        saveGame(new GameProgress(1,2,3,4),"C://Games//savegames//save1.dat");
        saveGame(new GameProgress(2,3,4,5),"C://Games//savegames//save2.dat");
        saveGame(new GameProgress(3,4,5,6),"C://Games//savegames//save3.dat");

        zipFiles(Arrays.asList(new File("C://Games//savegames//").listFiles()),"C://Games//savegames//");
        delFiles(Arrays.asList(new File("C://Games//savegames//").listFiles()));
    }

    static void saveGame(GameProgress gameProgress, String savePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(savePath, true))) {
            outputStream.writeObject(gameProgress);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void zipFiles(List<File> file, String arch) {
        for (File i : file) {
            try (FileInputStream fileInputStream = new FileInputStream(i); ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(arch + i.getName() + ".zip"))) {
                zipOutputStream.putNextEntry(new ZipEntry(i.getName()));
                zipOutputStream.write(fileInputStream.readAllBytes());
                zipOutputStream.closeEntry();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    static void delFiles(List<File> file){
        for(File i : file) {
        Pattern pattern = Pattern.compile(".zip(\\w*)");
        Matcher matcher = pattern.matcher(i.getName());
            if(!matcher.find()) {
                i.delete();
            }
        }
    }
}

