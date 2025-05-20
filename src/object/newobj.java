package object;

import javax.imageio.ImageIO;
import java.io.IOException;


public class newobj extends Superobject {
    public newobj() {
        name = "newobj";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/newobj.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision=true;
    }

}
