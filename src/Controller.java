import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {

    private File file;

    @FXML
    void open() throws FileNotFoundException {
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png"),
                new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.jpeg"),
                new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.gif"));
        openFile.setTitle("Open File");
        File fileOpen = openFile.showOpenDialog(null);
        if (fileOpen != null) {
            file = fileOpen;
        }
    }

    @FXML
    void saveRed() {
        if (file != null) {
            try {
                File fileSave = saveFile();

                BufferedImage source = ImageIO.read(file);
                BufferedImage result = new BufferedImage(source.getWidth(),
                        source.getHeight(),
                        source.getType());

                for (int x = 0; x < source.getWidth(); x++) {
                    for (int y = 0; y < source.getHeight(); y++) {
                        if (source.getRGB(x, y) == -1446160) {
                            result.setRGB(x, y, Color.RED.getRGB());
                        }
                    }
                }
                ImageIO.write(result,
                        fileSave.getName().substring(fileSave.getName().lastIndexOf(".") + 1),
                        fileSave);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not exit");
        }
    }

    @FXML
    void saveX2() {
        if (file != null) {
            try {
                File fileSave = saveFile();

                BufferedImage img = ImageIO.read(file);
                BufferedImage image = new BufferedImage(img.getWidth() * 2,
                        img.getHeight() * 2,
                        BufferedImage.TYPE_INT_RGB);
                image.getGraphics().drawImage(img.getScaledInstance(image.getWidth(),
                        image.getHeight(), Image.SCALE_SMOOTH), 0, 0, null);

                ImageIO.write(image,
                        fileSave.getName().substring(fileSave.getName().lastIndexOf(".") + 1),
                        fileSave);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not exit");
        }

    }

    private File saveFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png"),
                new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.jpeg"),
                new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.bmp"),
                new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.gif"));
        fileChooser.setInitialFileName("upscale");

        return fileChooser.showSaveDialog(null);
    }
}
