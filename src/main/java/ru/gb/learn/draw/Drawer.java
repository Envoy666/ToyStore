package ru.gb.learn.draw;

import ru.gb.learn.box.ToyBox;

/**
 * A drawer of ToyBox
 */
public interface Drawer {

    /**
     * @apiNote draws toys from a ToyBox
     * @param toyBox a ToyBox to be drawn
     */
    void draw(ToyBox toyBox);
}
