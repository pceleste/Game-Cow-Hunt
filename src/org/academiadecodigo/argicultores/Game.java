package org.academiadecodigo.argicultores;

import org.academiadecodigo.argicultores.Cows.Cow;
import org.academiadecodigo.argicultores.Levels.LevelInit;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Game implements KeyboardHandler {

    private static final int PADDING = 10;
    private static final int QUT = 35;
    private final Picture fBackground = new Picture(PADDING, PADDING, "background-teste1.png");
    private Picture cToytaR = new Picture(10, 488, "toyta.png");
    private final Picture cToytaL = new Picture(800, 488, "toyota2.png");
    private ArrayList<Cow> cow = new ArrayList<>();
    private final LevelInit levelInit = new LevelInit();
    private Text text;
    private int vacas = 0;
    private int auxVacas=0;
    private String direction = "Direita";

    public void init() {
        levelInit.menuInit();
        fBackground.draw();
        cow = levelInit.createCow(QUT);
        cToytaR.draw();
        text = new Text(845, 10, "About");
        text.setColor(Color.BLACK);
    }

    public void start() throws InterruptedException {
        Keyboard kb = new Keyboard(this);

        KeyboardEvent esc = new KeyboardEvent();
        esc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        esc.setKey(KeyboardEvent.KEY_ESC);
        kb.addEventListener(esc);

        while (true) {
            Thread.sleep(45);
            cow.forEach(Cow::move);
            if (allDead()) {
                auxVacas+=vacas;
                cow.removeAll(cow);
                fBackground.delete();
                fBackground.draw();
                cToytaR.delete();
                cow = levelInit.createCow(QUT);
                text = new Text(845, 10, "Vacas: " + auxVacas);
                text.draw();
                cToytaR = new Picture(10, 488, "toyta.png");
                cToytaR.draw();
            }
            if (cToytaR.getX() < 800 && Objects.equals(direction, "Direita")) {
                cToytaR.translate(5, 0);
            } else {
                cToytaR.translate(-cToytaR.getX(), 0);
                cToytaR.delete();
                cToytaL.draw();
                direction = "Esquerda";
            }
            if (cToytaL.getX() > 0 && Objects.equals(direction, "Esquerda")) {
                cToytaL.translate(-5, 0);
            } else {
                cToytaL.delete();
                cToytaR.draw();
                direction = "Direita";
            }
        }
    }

    public boolean allDead() {
        List<Cow> oCont = cow.stream().filter(Cow::isDead).collect(Collectors.toList());
        vacas= oCont.size();
        return oCont.size() >= QUT;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_ESC) {
            System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
