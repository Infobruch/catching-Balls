import GLOOP.*;
public class Player {
    private GLKugel p1;
    private Floor feld;
    private double vX,vZ;
    private double breite, tiefe;

    public Player(double pWidth, double pLength) {
        breite = pWidth;
        tiefe = pLength;
        p1 = new GLKugel(0, 30, 0, 30);
        p1.setzeMaterial(GLMaterial.BLAUGLAS);
        p1.setzeSelbstleuchten(0,0,1);
    }

}
