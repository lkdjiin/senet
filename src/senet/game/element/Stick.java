package senet.game.element;

public class Stick {

    public StickFace throwMe() {
        int random = (int) (Math.random() * 2);
        assert(random==0 || random==1);
        if(random == 0)
            return StickFace.BLACK;
        else
            return StickFace.WHITE;
    }
}
