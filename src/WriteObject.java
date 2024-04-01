import java.io.*;
import java.util.List;
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

    public void zipFiles(List<File> file, String arch) {
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
}
