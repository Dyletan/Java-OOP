package containers;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Point implements Serializable{
    private final LocalDate date;
    private double point;
    private PointType type;
    {
        date = LocalDate.now();
    }

    public Point() {}

    public Point(double point, PointType type) {
        this.point = point;
        this.type = type;
    }

    @Override
    public String toString() {
        return point + " " + date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return Double.compare(point, point1.point) == 0 && Objects.equals(date, point1.date) && type == point1.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, point, type);
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public PointType getType() {
        return type;
    }

    public void setType(PointType type) {
        this.type = type;
    }
}
