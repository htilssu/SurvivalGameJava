package org.htilssu.inputs;

import org.htilssu.GameWindow;
import org.htilssu.entities.Player;
import org.htilssu.entities.states.PlayerState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    private final Player player;
    GameWindow gameWindow;

    public KeyInput(Player player, GameWindow window) {
        this.player = player;
        gameWindow = window;
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
                gameWindow.toggleFullScreen();
                break;
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
