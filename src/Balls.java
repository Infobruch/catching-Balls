import GLOOP.*;
public class Balls {
    private GLKugel s1;
    private Player player;
    private Floor floor;
    int index;
    Balls[] spheres;
    
    private double radius;
    private boolean istAktiv;
    private double vX, vZ;

    public Balls(Balls[] pBalls,int pIndex,double pRadius, Player pPlayer, Floor pFloor, int speedX, int speedZ) {
        spheres = pBalls;
        index = pIndex;
        s1 = new GLKugel(Math.random()*500-103,25,Math.random()*500-162, pRadius);
    }
    public void move(){

    }
    public GLVektor getPos(){
        return s1.gibPosition();
    }

}
