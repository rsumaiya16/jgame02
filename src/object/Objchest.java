package object;


import javax.imageio.ImageIO;
import java.io.IOException;


public class Objchest extends Superobject {
    public Objchest() {
        name = "chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}