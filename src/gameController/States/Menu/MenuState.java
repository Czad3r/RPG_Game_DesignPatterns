package gameController.States.Menu;

import gameController.Handler;
import gameController.Inputs.ClickListener;
import gameController.States.State;
import gameView.Assets;

import java.awt.*;

public class MenuState extends State {

    private MenuManager menuManager;
    private boolean isMouseActive;

    public MenuState(Handler handler) {

        super(handler);
        menuManager = new MenuManager(handler);
        handler.getMouseHandler().setMenuManager(menuManager);
        isMouseActive=true;
        initButtons();
    }

    public void initButtons(){
        menuManager.addObject(new StartButton((handler.getWidth() / 2) - (Assets.buttonWidth / 2), 100,
                Assets.buttonWidth, Assets.buttonHeight, Assets.startButton, new ClickListener() {
            @Override
            public void onClick() {
                isMouseActive=false;
                State.setCurrentState(handler.getGame().getGameState());
            }
        }));

        menuManager.addObject(new StartButton((handler.getWidth() / 2) - (Assets.createButtonWidth / 2), 200,
                Assets.createButtonWidth, Assets.buttonHeight, Assets.createButton, new ClickListener() {
            @Override
            public void onClick() {
               // State.setCurrentState(handler.getGame().getGameState());  Zmiana na CreateState
            }
        }));

    }

    @Override
    public void tick() {
        if(!isMouseActive) handler.getMouseHandler().setMenuManager(menuManager);
        menuManager.tick();
    }

    @Override
    public void render(Graphics g) {
        menuManager.render(g);
    }
}
