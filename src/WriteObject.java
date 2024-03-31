import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class WriteObject {
    public void saveGame(GameProgress gameProgress, String savePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(savePath))) {
            outputStream.writeObject(gameProgress);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void zipFiles(String file, String arch){
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(arch)));
            FileInputStream fileInputStream = new FileInputStream(file)){
            zipOutputStream.putNextEntry(new ZipEntry(file));
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            zipOutputStream.write(buffer);
            zipOutputStream.closeEntry();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}