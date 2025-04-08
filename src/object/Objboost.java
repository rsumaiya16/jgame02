package object;

import javax.imageio.ImageIO;
import java.io.IOException;


public class Objboost extends Superobject {
    public Objboost() {
        name = "boost";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/boost.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision=true;
    }

}
