package org.htilssu.inputs;

import org.htilssu.GamePanel;
import org.htilssu.GameWindow;
import org.htilssu.controls.SoundControl;
import org.htilssu.entities.Player;
import org.htilssu.entities.states.PlayerState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInputListener implements KeyListener {

    private final Player player;
    GamePanel gamePanel;

    public KeyInputListener(GamePanel panel) {
        this.player = panel.getPlayer();
        gamePanel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                player.state = PlayerState.MOVE_LEFT;
                break;
            case KeyEvent.VK_D:
                player.state = PlayerState.MOVE_RIGHT;
                break;
            case KeyEvent.VK_F11:
                gamePanel.getWindow().toggleFullScreen();
                break;
            case KeyEvent.VK_ESCAPE:
                break;
            case KeyEvent.VK_SPACE:

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A, KeyEvent.VK_D:
                player.state = PlayerState.IDLE;
                break;
        }
    }

}
