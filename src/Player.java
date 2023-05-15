import GLOOP.*;
public class Player {
    private GLZylinder p1;
    private Floor floor;
    GLVektor vPos, vResetPos;
    double radius, speed;


    public Player(double pX, double pZ, double pRadius, double pSpeed, Floor pFloor) {
        floor = pFloor;
        speed = pSpeed;
        radius = pRadius;
        vPos = new GLVektor(pX, 0, pZ);
        vResetPos = new GLVektor(pX, 0, pZ);
        p1 = new GLZylinder(vPos, radius, 20);
        p1.drehe(90, 0, 0);
        p1.setzeFarbe(0, 1, 0);
        p1.setzeMaterial(GLMaterial.BLAUGLAS);
        p1.setzeSelbstleuchten(0,0,1);
    }

    public void moveRight(){
        if(this.getPos().x + radius < floor.getRightX()) {
            vPos.x += speed;
            this.updateCatcherPos();
        }
    }
    public void moveLeft(){
        if(this.getPos().x - radius > floor.getLeftX()) {
            vPos.x -= speed;
            this.updateCatcherPos();
        }
    }
    public void moveUp(){
        if(this.getPos().z - radius > floor.getBackZ()) {
            vPos.z -= speed;
            this.updateCatcherPos();
        }
    }
    public void moveDown(){
        if(this.getPos().z + radius < floor.getFrontZ()) {
            vPos.z += speed;
            this.updateCatcherPos();
        }
    }
    public void updateCatcherPos(){
        p1.setzePosition(vPos);
    }
    public void reset(){
        vPos = vResetPos;
        p1.setzePosition(vPos);
    }

    public GLVektor getPos(){
        return vPos;
    }
    public double getRadius(){
        return radius;
    }
}
