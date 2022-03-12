package models;

public class Coordinates {
    private int coordenateX;
    private int coordenateY;

    public Coordinates(int coordenateX, int coordenateY) {
        this.coordenateX = coordenateX;
        this.coordenateY = coordenateY;
    }

    public int getCoordenateX() {
        return coordenateX;
    }

    public void setCoordenateX(int coordenateX) {
        this.coordenateX = coordenateX;
    }

    public int getCoordenateY() {
        return coordenateY;
    }

    public void setCoordenateY(int coordenateY) {
        this.coordenateY = coordenateY;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "coordenateX=" + coordenateX +
                ", coordenateY=" + coordenateY +
                '}';
    }

}
