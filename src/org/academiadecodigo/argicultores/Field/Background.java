package org.academiadecodigo.argicultores.Field;
import org.academiadecodigo.argicultores.Sound;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.omg.CORBA.PRIVATE_MEMBER;

public class Background extends Picture implements MouseHandler {

    private final Picture menuBackground;
    private boolean started=false;
    final static int PADDING = 10;
    private Text about = new Text(650,500,"To exit the game press ESC");
    private Text about2 = new Text(580,520,"In this game you don't have to WIN or LOSE,");
    private Text about3 = new Text(580,540,"all you have to do is have fun catching the ");
    private Text about4 = new Text(580,560,"cows that have started to run away, ENJOY");

    public Background() {
        menuBackground = new Picture(PADDING, PADDING, "finalMenuBackground.png");
        new Mouse(this);
        Sound sound = new Sound("menuSoundFinal.wav");
        sound.setLoop(15);
        initBackground();


    }

    public void initBackground(){

        while (!started) {
            menuBackground.draw();
            about.draw();
            about2.draw();
            about3.draw();
            about4.draw();
        }
        menuBackground.delete();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(!started) {
            if (mouseEvent.getX() > 278 && mouseEvent.getX() < 468 &&
                    mouseEvent.getY() > 321 && mouseEvent.getY() < 381) {
                started = true;
                initBackground();
            }
            if (mouseEvent.getX() > 307 && mouseEvent.getX() < 437 && mouseEvent.getY() > 421 && mouseEvent.getY() < 481) {
                System.exit(1);
            }

        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
