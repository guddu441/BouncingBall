package bouncingballs;

import java.util.Random;

public class Ball {
    private int BallPosX, BallPosY, Radius, BallSpeedX, BallSpeedY;
    Random r=new Random();
    
    Ball(){
        BallPosX=r.nextInt(500)+32;
        BallPosY=r.nextInt(300)+32;
        Radius=25;
        BallSpeedX=5;
        BallSpeedY=5;        
    }

    public int getBallPosX() {
        return BallPosX;
    }

    public int getBallPosY() {
        return BallPosY;
    }

    public int getBallSpeedX() {
        return BallSpeedX;
    }

    public int getBallSpeedY() {
        return BallSpeedY;
    }

    public void setBallPosX(int BallPosX) {
        this.BallPosX = BallPosX;
    }

    public void setBallPosY(int BallPosY) {
        this.BallPosY = BallPosY;
    }

    public void setBallSpeedX(int BallSpeedX) {
        this.BallSpeedX = BallSpeedX;
    }

    public void setBallSpeedY(int BallSpeedY) {
        this.BallSpeedY = BallSpeedY;
    }

    public int getRadius() {
        return Radius;
    }
    public void move(){     
        if((BallPosX>600-40)||(BallPosX<10)){
            BallSpeedX=BallSpeedX*-1;
        }
        if((BallPosY>360-40)||(BallPosY<30)){
            BallSpeedY=BallSpeedY*-1;
        }
        BallPosX+=BallSpeedX;
        BallPosY+=BallSpeedY;   
    }
    void ballsColloiding(Ball b2) {
        if((Math.abs(BallPosX-b2.getBallPosX())<=26)&&(Math.abs(BallPosY-b2.getBallPosY())<=26)){
            BallSpeedY=BallSpeedY*-1;
            BallSpeedX=BallSpeedX*-1;
        }
    }
}
