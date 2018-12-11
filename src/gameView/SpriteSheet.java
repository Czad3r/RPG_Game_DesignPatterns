package gameView;

import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet=sheet;
    }

    public BufferedImage crop(int x,int y,int width,int height) throws RasterFormatException {
        return sheet.getSubimage(x,y,width,height);
    }
}
