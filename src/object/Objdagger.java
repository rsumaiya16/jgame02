package object;

import javax.imageio.ImageIO;
import java.io.IOException;


public class Objdagger extends Superobject {
    public Objdagger() {
        name = "dagger";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/dagger.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision=true;
    }

}
