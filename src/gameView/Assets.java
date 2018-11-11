package gameView;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;

    public static BufferedImage player, path, doors, tree, grass, arenaDoors, shopSign, bedSign;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/map.png"));

        grass = sheet.crop(0, 0, width, height);
        path = sheet.crop(22 * width, 1 * height, width, height);
        doors = sheet.crop(15 * width, 1 * height, width, height);
        arenaDoors = sheet.crop(12 * width, 19 * height, width, height);
        shopSign = sheet.crop(5 * width, 3 * height, width, height);
        bedSign = sheet.crop(8 * width, 3 * height, width, height);
        tree = sheet.crop(0, height, width, height);
        //player=sheet.crop(15*width,1*height,width,height);


    }
}
