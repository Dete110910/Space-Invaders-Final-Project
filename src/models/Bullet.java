package models;

public abstract class Bullet implements Runnable {
    protected Coordinates coordinates;
    protected boolean isCrashed;
    protected static final byte VELOCITY = 30;

    public Bullet(Coordinates coordinates) {
        this.isCrashed = false;
        this.coordinates = coordinates;
    }

    public abstract void move();

    public abstract void verifyIsCrashes();

    @Override
    public void run() {
        while (!isCrashed){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.move();
            this.verifyIsCrashes();
        }
    }
}
