package org.htilssu;

import org.htilssu.utils.Assets;
import org.htilssu.utils.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class GameSplashScreen extends JPanel {
    GameWindow gameWindow;
    BufferedImage gameIcon;
    double progress = 0;


    public GameSplashScreen(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setPreferredSize(gameWindow.getPreferredSize());
        setBackground(Color.BLACK);
        setAlignmentX(CENTER_ALIGNMENT);
        gameIcon = Image.resizeImage(Objects.requireNonNull(Assets.loadImage("/icon.png")), 0.7);
    }

    @Override
    protected void paintComponent(Graphics g) {
        progress += 2;
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(gameIcon, (getWidth() - gameIcon.getWidth()) / 2, (getHeight() - gameIcon.getHeight()) / 2 - 50, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 0.5f));
        drawLoadingProgress((Graphics2D) g, progress % 101);
        if (progress == 100) {
            this.setVisible(false);
            gameWindow.joinMain();
        }
    }

    public void drawLoadingProgress(Graphics2D g2d, double progress) {
        g2d.fillRoundRect((getWidth() - 250) / 2, (getHeight() - 10 + 200) / 2, 250, 10, 8, 8);
        g2d.setColor(Color.white);
        g2d.fillRoundRect((getWidth() - 250) / 2, (getHeight() - 10 + 200) / 2, (int) (progress * 250 / 100), 10, 8, 8);
    }
}
