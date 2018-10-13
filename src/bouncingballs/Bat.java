package bouncingballs;

public class Bat {

    private int BatPosX, BatPosY, width, height, BatSpeedX;

    Bat() {
        width = 100;
        height = 12;
        BatPosY = 360 - 20;
        BatPosX = 300 - 50;
        BatSpeedX = 5;
    }

    public int getBatPosX() {
        return BatPosX;
    }

    public int getBatPosY() {
        return BatPosY;
    }

    public int getBatSpeedX() {
        return BatSpeedX;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setBatPosX(int BatPosX) {
        this.BatPosX = BatPosX;
    }

    public void setBatPosY(int BatPosY) {
        this.BatPosY = BatPosY;
    }

    public void setBatSpeedX(int BatSpeedX) {
        this.BatSpeedX = BatSpeedX;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    void moveBat(int x) {
        if (x == 1) {
            if (BatPosX <= 10) {
                BatPosX = 10;
            }
            else {
                BatPosX = BatPosX - BatSpeedX;
            }
        } else if (x == 2) {
            if (BatPosX + width >= 590) {
                BatPosX = 590-width;
            }
            else {
                BatPosX = BatPosX + BatSpeedX;
            }
        }
    }

}
