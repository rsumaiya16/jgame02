package object;

import javax.imageio.ImageIO;
import java.io.IOException;


public class Objdoor extends Superobject {
    public Objdoor() {
        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision=true;
    }

}
