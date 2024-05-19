package org.htilssu;

import org.htilssu.controls.GameSetting;
import org.htilssu.entities.EntityManager;
import org.htilssu.utils.Assets;
import org.htilssu.utils.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import static java.lang.Math.round;

public class GameWindow extends JFrame implements ComponentListener {
    public final String TITLE = "Survival Game";
    private final GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    public short currentFPS = 0;
    GamePanel panel;
    GameSplashScreen gameSplashScreen = new GameSplashScreen(this);
    private boolean isFullScreen = false;
    private Thread renderThread;

    public GameWindow() {
        setTitle(TITLE);
        setPreferredSize(new Dimension(GameSetting.WIDTH, GameSetting.HEIGHT));
        setResizable(true);
        setMinimumSize(new Dimension(GameSetting.WIDTH, GameSetting.HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/icon.png")));

        //Su kien resize va thoat khoi man hinh
        addComponentListener(this);
        panel = new GamePanel(this);

    }

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();

        gameWindow.start();
        gameWindow.loadGame();
    }

    public GamePanel getPanel() {
        return panel;
    }

    /**
     * Vòng lặp render game
     */
    private void render() {
        long lastTimeFrame = System.nanoTime();
        long lastTimeTick = System.nanoTime();
        float nsPerFrame = 1e9f / GameSetting.FPS;
        float nsPerTick = 1e9f / GameSetting.TPS;
        long timer = System.currentTimeMillis();
        float markTick = 0;
        short frames = 0;

        while (true) {
            long now = System.nanoTime();

            markTick += (now - lastTimeTick) / nsPerTick;

            if (markTick >= 1) {
                EntityManager.update();
                Time.deltaTime = (now - lastTimeTick) / 1e9;
                markTick -= 1;
                lastTimeTick = now;
            }

            if (now - lastTimeFrame < nsPerFrame) {
                continue;
            }

            panel.repaint();
            if (gameSplashScreen != null) {
                gameSplashScreen.repaint();
            }

            lastTimeFrame = now;
            frames++;
            if (System.currentTimeMillis() - timer >= 1000) {
                currentFPS = frames;
                setTitle(TITLE + " | FPS: " + currentFPS);
                frames = 0;
                timer = System.currentTimeMillis();
            }

        }
    }

    /**
     * Bắt đầu chạy game
     */
    public void start() {
        renderThread = new Thread(this::render);
        renderThread.start();
    }

    /**
     * Dừng chạy game
     */
    public void stop() {
        try {
            renderThread.join();
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * Thực hiện load game
     */
    public void loadGame() {
        setUndecorated(true);
        gameSplashScreen = new GameSplashScreen(this);
        add(gameSplashScreen);
        pack(); // pack before setting visible
        Assets.loadAssets();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Vao game chinh
     */
    public void joinMain() {
        remove(gameSplashScreen);
        gameSplashScreen = null;
        add(panel);
        dispose();
        setUndecorated(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        panel.requestFocus();
    }

    /**
     * Chuyển đổi giữa chế độ toàn màn hình và chế độ cửa sổ
     */
    public void toggleFullScreen() {
        isFullScreen = !isFullScreen;
        dispose();
        setUndecorated(isFullScreen);
        if (isFullScreen) {
            device.setFullScreenWindow(this);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            device.setFullScreenWindow(null);
            setLocationRelativeTo(null);
        }
        setVisible(true);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        GameSetting.SCALE = Math.min(getWidth() / (float) GameSetting.WIDTH, getHeight() / (float) GameSetting.HEIGHT) + 1;

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
