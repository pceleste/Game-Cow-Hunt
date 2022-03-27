package org.academiadecodigo.argicultores.Levels;

import org.academiadecodigo.argicultores.Cows.Cow;
import org.academiadecodigo.argicultores.Cows.CowFactory;
import org.academiadecodigo.argicultores.Field.Background;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class LevelInit {
    private int cont;
    private final ArrayList<Cow> cow = new ArrayList<>();


    public void menuInit() {
        new Background();
    }

    public ArrayList<Cow> createCow(int qut) {

        while (cont < qut) {
            this.cow.add(CowFactory.getNewCow());
            cont++;
        }
        cont = 0;
        this.cow.forEach((n) -> n.getCow().draw());
        Picture grass = new Picture(10, 308, "grass.png");
        grass.draw();
        return cow;
    }
}
