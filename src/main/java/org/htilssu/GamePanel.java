package org.htilssu;

import org.htilssu.entities.Camera;
import org.htilssu.entities.EntityManager;
import org.htilssu.entities.EntityType;
import org.htilssu.entities.Player;
import org.htilssu.entities.states.PlayerState;
import org.htilssu.inputs.KeyInputListener;
import org.htilssu.utils.Assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import static org.htilssu.controls.GameSetting.SCALE;

public class GamePanel extends JPanel implements FocusListener, ComponentListener {
    private final Player player = new Player(0, 0, 10, EntityType.Player, 1, 20, PlayerState.IDLE, "htilssu", 100, 1);
    private final Camera camera = new Camera(player);
    GameWindow window;

    {
        player.loadAsset("knight_idle.png");
    }

    public GamePanel(GameWindow window) {
        this.window = window;
        addKeyListener(new KeyInputListener(this));
        setFocusable(true);
        setPreferredSize(window.getSize());
        addFocusListener(this);
        addComponentListener(this);
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(SCALE, SCALE);
        EntityManager.render(g2d);
    }

    public GameWindow getWindow() {
        return window;
    }

    @Override
    public void focusGained(FocusEvent e) {
        requestFocus();
    }

    @Override
    public void focusLost(FocusEvent e) {
        player.resetMoveState();
    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
