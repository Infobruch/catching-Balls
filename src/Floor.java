//TODO: Texture getting changed later

import GLOOP.*;
public class Floor {
    private GLQuader untergrund;
    private double width, length;

    public Floor(double pWidth, double pLength){
        width = pWidth;
        length = pLength;
        untergrund = new GLQuader(0,0,0, width,20,length);
        untergrund.setzeMaterial(GLMaterial.GLAS);
        //untergrund.setzeSelbstleuchten(1,1,1);
    }
    public double getWidth(){
        return width;
    }
    public double getLength(){
        return length;
    }
}
