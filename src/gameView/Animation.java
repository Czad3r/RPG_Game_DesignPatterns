package gameView;

import java.awt.image.BufferedImage;

public class Animation{
    private BufferedImage[] frames;

    public Animation(BufferedImage[] frames) {
        this.frames = frames;
    }
    public BufferedImage getAnimation(int lastMoveSide)
    {
        if (lastMoveSide==Assets.LEFT) {
            return Assets.player[Assets.LEFT];
        }
        else if (lastMoveSide==Assets.RIGHT) {
            return Assets.player[Assets.RIGHT];
        }
        else if (lastMoveSide==Assets.BACK) {
           return Assets.player[Assets.BACK];
        }
        else {
         return Assets.player[Assets.FRONT];
        }
    }
}
