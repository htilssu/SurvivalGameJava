package org.htilssu.entities;

import org.htilssu.controls.GameSetting;
import org.htilssu.entities.states.PlayerState;
import org.htilssu.utils.Time;

public class Player extends Entity {

    public static Player currentPlayer;
    public byte state = PlayerState.IDLE;
    public String name = "Player";
    /**
     * Mana tối đa
     */
    public double maxMana = 100;
    /**
     * Mana hiện tại
     */
    public double currentMana = 100;
    /**
     * Tốc độ hồi mana mỗi giây
     */
    public double manaRegen = 1;

    public Player(String assetPath) {
        loadAsset(assetPath);
        maxHealth = 100;
        currentHealth = 100;
        speed = 1;
        damage = 10;
        currentPlayer = this;
    }

    /**
     * S&#x1EED; d&#x1EE5;ng mana c&#x1EE7;a {@link Player} khi th&#x1EF1;c hi&#x1EC7;n skill ho&#x1EB7;c spell, n&#x1EBF;u kh&ocirc;ng &#x111;&#x1EE7; mana &#x111;&#x1EC3; th&#x1EF1;c hi&#x1EC7;n th&igrave; tr&#x1EA3; v&#x1EC1; false, ng&#x1B0;&#x1EE3;c l&#x1EA1;i th&igrave; tr&#x1EA3; v&#x1EC1; true
     *
     * @param amount l&#x1B0;&#x1EE3;ng mana c&#x1EA7;n s&#x1EED; d&#x1EE5;ng
     * @return {@code true} n&#x1EBF;u &#x111;&#x1EE7; mana &#x111;&#x1EC3; s&#x1EED; d&#x1EE5;ng, ng&#x1B0;&#x1EE3;c l&#x1EA1;i tr&#x1EA3; v&#x1EC1; {@code false}
     */
    public boolean useMana(double amount) {
        if (currentMana >= amount) {
            currentMana -= amount;
            return true;
        }
        return false;
    }

    /**
     * H&#x1ED3;i mana cho ng&#x1B0;&#x1EDD;i ch&#x1A1;i m&#x1ED7;i gi&acirc;y d&#x1EF1;a v&agrave;o {@link Player#manaRegen}
     */
    public void regenMana() {
        if (currentMana < maxMana) {
            currentMana += manaRegen;
            if (currentMana > maxMana) {
                currentMana = maxMana;
            }
        }
    }

    /**
     * Đặt lại trạng thái di chuyển của {@link Player} về trạng thái đứng yên
     */
    public void resetMoveState() {
        state = PlayerState.IDLE;
    }

    @Override
    public void update() {
        super.update();
        if (PlayerState.MOVE_LEFT == state) {
            X -= speed * GameSetting.moveDistance * Time.deltaTime;
        } else if (PlayerState.MOVE_RIGHT == state) {
            X += speed * GameSetting.moveDistance * Time.deltaTime;
        }
    }
}