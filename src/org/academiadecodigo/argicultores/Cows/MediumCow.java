package org.academiadecodigo.argicultores.Cows;

import org.academiadecodigo.argicultores.Random;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MediumCow extends Cow {

    private Random ran = new Random(800);

    public MediumCow() {
        super();
        setCow(new Picture(ran.getRandom(),500 , "cow_medium.png"));
    }

    @Override
    public void move() {
        direction(3);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
