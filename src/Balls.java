import GLOOP.*;
public class Balls {
    private GLKugel s1;
    GLVektor pos;
    private Player player;
    private Floor floor;
    int index;
    Balls[] spheres;
    
    private double radius;
    private boolean istAktiv;
    private double speedX, speedZ,tempSpeedX, tempSpeedZ;
    private GLVektor outOfBounds,vPos;

    public Balls(Balls[] pBalls,int pIndex,double pRadius, Player pPlayer, Floor pFloor, double speed) {
        spheres = pBalls;
        index = pIndex;
        radius = pRadius;
        floor = pFloor;
        player = pPlayer;
        speedX = Math.random()*speed*2-speed;
        speedZ = Math.random()*speed-speed/2;
        outOfBounds = new GLVektor(9999999, 9999999, 9999999);
        s1 = new GLKugel(Math.random()*500-103,25,Math.random()*500-162, pRadius);
        pos = new GLVektor(this.getPos());
        vPos = s1.gibPosition();
    }
    public GLVektor getPos(){
        return s1.gibPosition();
    }
    public GLVektor newColor(){
        return new GLVektor(Math.random(), Math.random(), Math.random());
    }
    public void move(){
        System.out.println("test");
        if(this.getPos() != outOfBounds){
            s1.setzeSelbstleuchten(0, 0, 0);
            this.checkCollision();
            if(this.getPos().x + radius >= floor.getRightX() || this.getPos().x - radius <= floor.getLeftX()){
                speedX = -speedX;
                s1.setzeFarbe(this.newColor().x, this.newColor().y, this.newColor().z);
                if (this.getPos().x + radius >= floor.getRightX()){
                    floor.barrierCollision(3);
                } else if (this.getPos().x - radius <= floor.getLeftX()){
                    floor.barrierCollision(1);
                }
            }
            if(this.getPos().z + radius >= floor.getFrontZ() || this.getPos().z - radius <= floor.getBackZ()){
                speedZ = -speedZ;
                s1.setzeFarbe(this.newColor().x, this.newColor().y, this.newColor().z);
                if (this.getPos().z + radius >= floor.getFrontZ()){
                    floor.barrierCollision(2);
                } else if (this.getPos().z - radius <= floor.getBackZ()){
                    floor.barrierCollision(4);
                }
            }
            vPos.x += speedX;
            vPos.z += speedZ;
            s1.drehe(speedX, 0, speedZ);
            this.updateSpherePos(vPos);
        }
    }
    public void checkCollision(){
        for (int i = 0; i < spheres.length; i++) {
                if (i != index) {
                    double m = Math.sqrt(Math.pow( this.getPos().x - spheres[i].getPos().x, 2 ) + Math.pow( this.getPos().y - spheres[i].getPos().y, 2) + Math.pow( this.getPos().z - spheres[i].getPos().z, 2));
                    if (m < (spheres[i].getRadius() + 2* this.getRadius())) {
                        tempSpeedX = speedX;
                        tempSpeedZ = speedZ;
                        this.speedX = spheres[i].getSpeedX();
                        this.speedZ = spheres[i].getSpeedZ();
                        spheres[i].setSpeedX(tempSpeedX);
                        spheres[i].setSpeedZ(tempSpeedZ);
                        s1.setzeFarbe(this.newColor().x, this.newColor().y, this.newColor().z);
                    }
                }
            }
    }
    public void updateSpherePos(GLVektor pos){
        s1.setzePosition(pos);
    }
    public double getSpeedX(){
        return speedX;
    }
    public double getSpeedZ(){
        return speedZ;
    }
    public void setSpeedX(double pSpeedX){
        this.speedX = pSpeedX;
    }
    public void setSpeedZ(double pSpeedZ){
        this.speedZ = pSpeedZ;
    }
    public double getRadius(){
        return radius;
    }

}
