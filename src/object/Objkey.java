package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Objkey  extends Superobject{
    public Objkey(){
        name ="key";
        try{
            image= ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
