import GLOOP.*;
public class Balls {
    private GLKugel s1;
    private Player player;
    private Floor floor;
    
    private double radius;
    private boolean istAktiv;
    private double vX, vZ;

    public Balls(){
        s1 = new GLKugel(Math.random()*500-103,25,Math.random()*500-162, 10);
    }

}
