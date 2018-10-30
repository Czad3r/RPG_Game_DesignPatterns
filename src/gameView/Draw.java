package gameView;

import gameController.ButtonHandler;
import gameController.Instances;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw {
    JFrame frame;
    Canvas canvas;

    BufferStrategy bufferStrategy;

    private int WIDTH = 640;
    private int HEIGHT = 480;

    public Draw(){
        frame = new JFrame("RPG_GAME_DesignPatterns");
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);

        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setResizable(false);
        frame.setVisible(true);

        panel.add(canvas);
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        //This will make sure the canvas has focus, so that it can take input from mouse/keyboard
        canvas.requestFocus();
        canvas.setBackground(Color.black);
        canvas.addKeyListener(new ButtonHandler());
    }
    public void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        render(g);
        g.dispose();
        bufferStrategy.show();
    }
    protected void render(Graphics2D g){
        g.setColor(Color.white);
        g.fillRect(Instances.player.getX(), Instances.player.getY(), 15, 15);
    }
}


