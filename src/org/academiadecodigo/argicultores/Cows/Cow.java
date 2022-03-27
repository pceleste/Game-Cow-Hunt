package org.academiadecodigo.argicultores.Cows;

import org.academiadecodigo.argicultores.Field.Direction;
import org.academiadecodigo.argicultores.Random;
import org.academiadecodigo.argicultores.Sound;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

abstract public class Cow extends Picture implements MouseHandler {

    private boolean isDead = false;
    private Direction currentDirection;
    private Picture cow;

    public Cow() {
        currentDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
        new Mouse(this);
    }

    public Picture getCow() {
        return cow;
    }

    public void setCow(Picture cow) {
        this.cow = cow;
    }

    abstract public void move();

    public void direction(int speed) {
        if (!isDead) {
            Random random = new Random(100);
            int rand = random.getRandom();
            if (rand < 10) {
                currentDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];
            }
            switch (currentDirection) {
                case RIGHT:
                    if (cow.getX() <= 700) {
                        cow.translate(speed, 0);
                    } else {
                        cow.translate(-speed, 0);
                    }
                    break;
                case LEFT:
                    if (cow.getX() >= 10) {
                        cow.translate(-speed, 0);
                    } else {
                        cow.translate(speed, 0);
                    }
                    break;
                case UP:
                    if (cow.getY() >= 10) {
                        cow.translate(0, -speed);
                    }  else {
                        cow.translate(0, 0);
                    }
                    break;
            }
        } else {
            cow.translate(0, 10);
            if (cow.getY() > 400) {
                cow.delete();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        double mX = mouseEvent.getX();
        double mY = mouseEvent.getY() - 26;
        double cowSize = this.getCow().getHeight();
        if (mX >= this.getCow().getX() &&
                mX < (this.getCow().getX() + cowSize) &&
                mY >= this.getCow().getY() &&
                mY <= (this.getCow().getY() + cowSize) &&
                !this.isDead) {
            Sound sound = new Sound("moo.wav");
            this.isDead = true;
            sound.play(false);
        } else if (this.isDead()) {
            this.translate(0, 1);
        }
    }

    public boolean isDead() {
        return isDead;
    }
}
