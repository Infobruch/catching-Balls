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
    int collisions;

    public Balls(Balls[] pBalls,int pIndex,double pRadius, Player pPlayer, Floor pFloor, double speed) {
        spheres = pBalls;
        index = pIndex;
        radius = pRadius;
        floor = pFloor;
        player = pPlayer;
        speedX = Math.random()*speed*2-speed;
        speedZ = Math.random()*speed-speed/2;
        vPos = new GLVektor(Math.random()*(floor.getWidth() - 2*radius) - (floor.getWidth() - 2*radius)/2, 0 + radius, Math.random()*(floor.getLength() - 2*radius) - (floor.getLength()- 2*radius)/2);
        outOfBounds = new GLVektor(0, 100, 0);
        s1 = new GLKugel(vPos, pRadius);
        pos = new GLVektor(this.getPos());
        s1.setzeFarbe(newColor().x,newColor().y, newColor().z);
        do{
           this.collisionAtSpawn();
           if(this.checkForCollisionWithHole()){
               collisions++;
               this.resetRandomPos();
           }
           System.out.println(collisions);
       }while(collisions > 0);
    }
    public GLVektor getPos(){
        return s1.gibPosition();
    }
    public GLVektor newColor(){
        return new GLVektor(Math.random(), Math.random(), Math.random());
    }
    public void move(){
        //System.out.println("test");
        if(this.getPos() != outOfBounds){
            this.checkCollision();
            if(this.getPos().x + radius >= floor.getRightX() || this.getPos().x - radius <= floor.getLeftX()){
                speedX = -speedX;
                s1.setzeSelbstleuchten(this.newColor().x, this.newColor().y, this.newColor().z);
                if (this.getPos().x != outOfBounds.x && this.getPos().x + radius >= floor.getRightX()){
                    floor.barrierCollision(3);
                } else if (this.getPos().x != outOfBounds.x && this.getPos().x - radius <= floor.getLeftX()){
                    floor.barrierCollision(1);
                }
            }
            if(this.getPos().z + radius >= floor.getFrontZ() || this.getPos().z - radius <= floor.getBackZ()){
                speedZ = -speedZ;
                s1.setzeSelbstleuchten(this.newColor().z, this.newColor().y, this.newColor().z);
                if (this.getPos().z != outOfBounds.z && this.getPos().z + radius >= floor.getFrontZ()){
                    floor.barrierCollision(2);
                } else if (this.getPos().z != outOfBounds.z && this.getPos().z - radius <= floor.getBackZ()){
                    floor.barrierCollision(4);
                }
            }
            vPos.x += speedX;
            vPos.z += speedZ;
            s1.drehe(speedX, 0, speedZ);
            this.updateSpherePos(vPos);
        }
        this.gotCaught();
    }
    public void collisionAtSpawn() {
    for (int i = 0; i < spheres.length; i++) {
        if (i == 0) {
            collisions = 0;
        }
        if (spheres[i] != null && i != index) {
            GLVektor spherePos = spheres[i].getPos();
            if (spherePos != null) {
                double a = Math.sqrt(Math.pow(this.getPos().x - spherePos.x, 2) +
                        Math.pow(this.getPos().y - spherePos.y, 2) +
                        Math.pow(this.getPos().z - spherePos.z, 2));
                if (a < (spheres[i].getRadius() + 2 * this.getRadius())) {
                    this.resetRandomPos();
                    collisions++;
                }
            }
        }
    }
}
    public void resetRandomPos(){
        vPos = new GLVektor(Math.random()*(floor.getWidth() - 2*radius) - (floor.getWidth() - 2*radius)/2, 0 + radius, Math.random()*(floor.getLength() - 2*radius) - (floor.getLength()- 2*radius)/2);
        s1.setzePosition(vPos);
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
                        s1.setzeSelbstleuchten(this.newColor().x, this.newColor().y, this.newColor().z);
                    }
                }
            }
    }
    public boolean checkForCollisionWithHole(){
        double d = Math.sqrt(Math.pow( this.getPos().x- player.getPos().x, 2 ) + Math.pow( this.getPos().y- player.getPos().y, 2) + Math.pow( this.getPos().z- player.getPos().z, 2));
        if(d < (player.getRadius() + this.getRadius())){
            return true;
        }else {
            return false;
        }
    }
    public void gotCaught(){
        if(checkForCollisionWithHole()) {
            this.makeItGoAway();
        }
    }
    public void makeItGoAway(){
        vPos = outOfBounds;
        this.updateSpherePos(vPos);
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
