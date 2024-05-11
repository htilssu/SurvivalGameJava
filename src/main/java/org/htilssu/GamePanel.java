package org.htilssu;

import org.htilssu.entities.Player;
import org.htilssu.inputs.KeyInput;
import org.htilssu.utils.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class GamePanel extends JPanel {
    private final Player player = new Player("knight_idle.png");
    public float x = 0;
    public float y = 0;
    public int step = 100;
    GameWindow window;
    Font font = new Font("Arial", Font.PLAIN, 16);

    public GamePanel(GameWindow window) {
        this.window = window;
        addKeyListener(new KeyInput(player, window));
        setFocusable(true);
        setPreferredSize(window.getSize());
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.update();
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.BLACK);
        g.setFont(font);
        AffineTransform at = AffineTransform.getTranslateInstance(player.X, player.Y);
        g2d.drawImage(Image.resizeImage(player.getSubAsset(), player.getSubAsset().getWidth() * 2, player.getSubAsset().getHeight() * 2), at, null);
    }
}
