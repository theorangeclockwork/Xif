package fix.task.model;

import fix.task.util.Util;

import java.util.Objects;

public class Position {

    private int vertical;  // порядковый номер вертикали
    private int horizontal; // порядковый номер горизонтали

    public Position(String pos) {
        vertical = Util.convertToDecimal(Util.extractVertical(pos), 26);
        horizontal = Util.extractHorizontal(pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return vertical == position.vertical &&
                horizontal == position.horizontal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertical, horizontal);
    }


    public Position(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

}
