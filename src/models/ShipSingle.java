package models;

public class ShipSingle extends Enemy{
    private int xPosition;
    private int yPosition;
    private int  direction;
    public ShipSingle(Coordinates coordinates) {
        super(coordinates);
        this.xPosition=coordinates.getCoordenateX();
        this.yPosition=coordinates.getCoordenateY();
    }

    @Override
    public int move() {
        defineDirection();
        defineXposition();
        return  xPosition;
    }

    @Override
    public void defineXposition() {
        if(this.direction==1){
            this.xPosition= this.xPosition+20;
        }else{
            this.xPosition= this.xPosition-20;
        }
    }

    @Override
    public void defineDirection() {
        if(this.xPosition==0){
            this.direction=1;
        }else if(this.xPosition==680){
            this.direction=0;
        }
    }
}
