package Tests.gameModelTests;

import gameController.Game;
import gameController.Handler;
import gameModel.DynamicEntities.HeroAbstract;
import gameModel.DynamicEntities.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroAbstractTest {

    HeroAbstract hero=new Knight.KnightBuilder("",new Handler(new Game())).
            x(5).
            y(5).
            build();


    @Test
    void hurt() {
        hero.setHealthPoints(20);
        hero.setArmorPoints(5);
        hero.hurt(24);
        assertEquals(1,hero.getHealthPoints());

        hero.setArmorPoints(0);
        hero.setHealthPoints(20);
        hero.hurt(10);
        assertEquals(10,hero.getHealthPoints());
        hero.hurt(11);
        assertEquals(-1,hero.getHealthPoints());
        assertEquals(false,hero.isActive());

    }

}