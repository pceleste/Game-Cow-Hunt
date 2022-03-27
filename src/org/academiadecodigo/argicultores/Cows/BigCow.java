package org.academiadecodigo.argicultores.Cows;

import org.academiadecodigo.argicultores.Random;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BigCow extends Cow {

    private Random ran = new Random(650);

    public BigCow() {
        super();
        setCow(new Picture(ran.getRandom(),455, "cow_big.png"));
    }

    @Override
    public void move() {
        direction(1);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}

