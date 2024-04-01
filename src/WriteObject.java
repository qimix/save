import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WriteObject {
    public void saveGame(GameProgress gameProgress, String savePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(savePath, true))) {
            outputStream.writeObject(gameProgress);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void zipFiles(String file, String arch) {
        try(FileInputStream fileInputStream = new FileInputStream(file); ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(arch))){
            zipOutputStream.putNextEntry(new ZipEntry("save4.dat"));
            zipOutputStream.write(fileInputStream.readAllBytes());
            zipOutputStream.closeEntry();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
