package model.common;

public class Point{
    public int a = 0;
    public int b = 0;
    public int backa = a;
    public int backb = b;
    public Point(){

    }
    public Point(int x, int y){
        a = x;
        b = y;
        backa = a;
        backb = b;
    }
    public void setVoid(){
        a = -1;
        b = -1;
    }
    public void setBack(){
        a = backa;
        b = backb;
    }
}
