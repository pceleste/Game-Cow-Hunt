package org.academiadecodigo.argicultores.Cows;


public class CowFactory {

    public static Cow getNewCow() {
        int random = (int) (Math.random() * CowType.values().length);
        CowType cowType = CowType.values()[random];
        Cow cow;
        switch (cowType) {
            case BIGCOW:
                cow = new BigCow();
                break;
            case MEDIUMCOW:
                cow = new MediumCow();
                break;
            default:
                cow = new SmallCow();
                break;
        }
        return cow;
    }
}
