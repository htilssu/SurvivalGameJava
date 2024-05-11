package org.htilssu;

import org.htilssu.controls.GameSetting;
import org.htilssu.utils.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.net.ServerSocket;

public class GameWindow extends JFrame implements ComponentListener {
    public final String TITLE = "Survival Game";
    private final GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    public int WIDTH = 800;
    public int HEIGHT = 500;
    public short currentFPS = 0;
    GamePanel panel = new GamePanel(this);
    ServerSocket serverSocket;
    GameSplashScreen gameSplashScreen = new GameSplashScreen(this);
    private boolean isFullScreen = false;
    private Thread renderThread;

    {
        try {
            serverSocket = new ServerSocket(9000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GameWindow() {
        setTitle(TITLE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setResizable(true);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/icon.png")));

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();

        gameWindow.start();
        gameWindow.loadGame();
    }

    private void render() {
        long lastTime = System.nanoTime();
        double nsPerFrame = 1e9 / GameSetting.FPS;
        long timer = System.currentTimeMillis();
        short frames = 0;

        while (true) {
            long now = System.nanoTime();

            if (now - lastTime < nsPerFrame) {
                continue;
            }
            Time.deltaTime = (now - lastTime) / 1e9;

            panel.repaint();
            if (gameSplashScreen != null) {
                gameSplashScreen.repaint();
            }

            lastTime = now;
            frames++;
            if (System.currentTimeMillis() - timer >= 1000) {
                currentFPS = frames;
                setTitle(TITLE + " | FPS: " + currentFPS);
                frames = 0;
                timer = System.currentTimeMillis();
            }

        }
    }

    public void start() {
        renderThread = new Thread(this::render);
        renderThread.start();
    }

    public void stop() {
        try {
            renderThread.join();
        } catch (InterruptedException ignored) {
        }
    }

    public void loadGame() {
        setUndecorated(true);
        gameSplashScreen = new GameSplashScreen(this);
        add(gameSplashScreen);
        pack(); // pack before setting visible
        setVisible(true);
    }

    public void joinGame() {
        remove(gameSplashScreen);
        gameSplashScreen = null;
        add(panel);
        dispose();
        setUndecorated(false);
        pack();
        setVisible(true);
        requestFocus();
        panel.requestFocus();
    }

    public void toggleFullScreen() {
        isFullScreen = !isFullScreen;
        dispose();
        setUndecorated(isFullScreen);
        if (isFullScreen) {
            device.setFullScreenWindow(this);
        } else {
            pack();
            device.setFullScreenWindow(null);
        }
        setVisible(true);
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
        panel.getPlayer().resetMoveState();
    }
}
