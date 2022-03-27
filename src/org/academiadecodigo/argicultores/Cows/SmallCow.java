package org.academiadecodigo.argicultores.Cows;

import org.academiadecodigo.argicultores.Random;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SmallCow extends Cow {

    public SmallCow() {
        super();
        Random ran = new Random(800);
        setCow(new Picture(ran.getRandom(),500 , "cow_small.png"));
    }

    @Override
    public void move() {
        direction(5);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
