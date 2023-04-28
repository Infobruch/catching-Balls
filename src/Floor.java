//TODO: Texture getting changed later

import GLOOP.*;
public class Floor {
    private GLQuader floor,leftBarrier,rightBarrier, topBarrier, bottomBarrier;
    private double width, length;

    public Floor(double pWidth, double pLength){
        width = pWidth;
        length = pLength;
        floor = new GLQuader(0,0,0, width,20,length);
        leftBarrier = new GLQuader(-width/2,0,0, 20,10,length);
        rightBarrier = new GLQuader(width/2,0,0, 20,10,length);
        topBarrier = new GLQuader(0,0,length/2, width,10,20);
        bottomBarrier = new GLQuader(0,0,-length/2, width,10,20);

        leftBarrier.setzeMaterial(GLMaterial.GLAS);
        leftBarrier.setzeSelbstleuchten(0,1,0);

        rightBarrier.setzeMaterial(GLMaterial.GLAS);
        rightBarrier.setzeSelbstleuchten(0,1,0);

        topBarrier.setzeMaterial(GLMaterial.GLAS);
        topBarrier.setzeSelbstleuchten(0,1,0);

        bottomBarrier.setzeMaterial(GLMaterial.GLAS);
        bottomBarrier.setzeSelbstleuchten(0,1,0);
        floor.setzeMaterial(GLMaterial.GLAS);
        //untergrund.setzeSelbstleuchten(1,1,1);
    }
    public void barrierCollision(int barrier){
        if (barrier == 1){
            leftBarrier.setzeSelbstleuchten(1,0,0);
        } else if (barrier == 2) {
            topBarrier.setzeSelbstleuchten(1,0,0);
        } else if (barrier == 3) {
            rightBarrier.setzeSelbstleuchten(1,0,0);
        } else if (barrier == 4) {
            bottomBarrier.setzeSelbstleuchten(1,0,0);
        }
    }

    public double getWidth(){
        return width;
    }
    public double getLength(){
        return length;
    }
}
