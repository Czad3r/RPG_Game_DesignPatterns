package gameView;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;

    public static BufferedImage path, doors, tree, grass, arenaDoors, shopSign, bedSign,woodWallWindow,arenaWall,monument;
    public static BufferedImage[] player;
    public static BufferedImage[] startButton;
    public static BufferedImage[] createButton;
    public static final int FRONT=0,BACK=1,RIGHT=2,LEFT=3;
    public static final int buttonWidth=164,buttonHeight=73;
    public static final int createButtonWidth=463;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/map.png"));
        SpriteSheet playerSheet=new SpriteSheet(ImageLoader.loadImage("/textures/hero1.png"));
        SpriteSheet buttonSheet=new SpriteSheet(ImageLoader.loadImage("/menu/Start.png"));
        SpriteSheet createbuttonSheet=new SpriteSheet(ImageLoader.loadImage("/menu/Create.png"));

        grass = sheet.crop(0, 0, width, height);
        path = sheet.crop(22 * width, 1 * height, width, height);
        doors = sheet.crop(15 * width, 20 * height, width, height);
        arenaDoors = sheet.crop(12 * width, 19 * height, width, height);
        shopSign = sheet.crop(5 * width, 3 * height, width, height);
        bedSign = sheet.crop(8 * width, 3 * height, width, height);
        tree = sheet.crop(0, height, width, height);

        player=new BufferedImage[4];
        startButton=new BufferedImage[2];
        createButton=new BufferedImage[2];

        player[FRONT]=playerSheet.crop(0*width,0*height,width,height); //Front
        player[BACK]=playerSheet.crop(1*width,0*height,width,height); //Back
        player[RIGHT]=playerSheet.crop(2*width,0*height,width,height); //Right
        player[LEFT]=playerSheet.crop(3*width,0*height,width,height); //Left

        startButton[0]=buttonSheet.crop(0,0,buttonWidth,buttonHeight);
        startButton[1]=buttonSheet.crop(0,buttonHeight,buttonWidth,buttonHeight);

        createButton[0]=createbuttonSheet.crop(0,0,createButtonWidth,buttonHeight);
        createButton[1]=createbuttonSheet.crop(0,buttonHeight,createButtonWidth,buttonHeight);

        woodWallWindow=sheet.crop(2*width,15*height,width,height);
        arenaWall=sheet.crop(15*width,18*height,width,height);
        monument=sheet.crop(13*width,14*height,width,height);
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
