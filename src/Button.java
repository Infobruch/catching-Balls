import GLOOP.GLTafel;
import GLOOP.GLVektor;

public class Button {
    double x,y,z,pX,pZ,textSize;
    boolean visible;
    String text;
    GLTafel button;
    public Button(){}
    public void build(double pFX,double pFY, double pFZ,double pLX, double pLZ, String pText,double pTextSize, boolean pVisible){
        x = pFX;
        y = pFY;
        z = pFZ;
        pX = pLX;
        pZ = pLZ;
        text = pText;
        textSize = pTextSize;
        visible = pVisible;
        button = new GLTafel(x,y,z,pX,pZ);
        button.setzeText(text,textSize);
        button.setzeSichtbarkeit(visible);
    }
    public void setText(String pText, double pTextSize){
        text = pText;
        textSize = pTextSize;
        button.setzeText(text,textSize);
    }
    public void setVisibility(boolean pVisible){
        visible = pVisible;
        button.setzeSichtbarkeit(visible);
    }
    public void setPos(double pX, double pY, double pZ){
        x = pX;
        y = pY;
        z = pZ;
        button.setzePosition(x,y,z);
    }
    public GLVektor getPos(){
        return button.gibPosition();
    }
    public void setTextColor(double pR, double pG, double pB){
        button.setzeTextfarbe(pR/255,pG/255,pB/255);
    }
    public void setButtonColor(double pR, double pG, double pB){
        button.setzeFarbe(pR/255,pG/255,pB/255);
    }
    public void setGlow(double pR, double pG, double pB){
        button.setzeSelbstleuchten(pR/255,pG/255,pB/255);
    }
    public void rotate(double pX, double pY, double pZ){
        button.drehe(pX,pY,pZ);
    }
}
