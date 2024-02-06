package containers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

public class Mark implements Serializable{
    private final Map<Double, String> gpaToAlphabetical = new HashMap<Double, String>() {{
        put(4.0, "A");
        put(3.67, "A-");
        put(3.33, "B+");
        put(3.0, "B");
        put(2.67, "B-");
        put(2.33, "C+");
        put(2.0, "C");
        put(1.67, "C-");
        put(1.33, "D+");
        put(1.0, "D");
        put(0.0, "F");
    }};

    private Vector<Point> firstAttestation;
    private Vector<Point> secondAttestation;
    private Point finalExam;
    {
        firstAttestation = new Vector<Point>();
        secondAttestation = new Vector<Point>();
        finalExam = new Point();
    }

    public Mark() {}

    /**
     * @param point A point with amount of points, date when it was put and what attestation (or final) it corresponds to
     */
    public void putMark(Point point){
        switch (point.getType()) {
            case FIRST_ATTESTATION:
                firstAttestation.add(point);
                break;
            case SECOND_ATTESTATION:
                secondAttestation.add(point);
                break;
            case FINAL:
                finalExam = point;
        }
    }

    /**
     * @return Returns all points combined to one Vector
     */
    public Vector<Point> getPoints(){
        Vector<Point> result = new Vector<Point>();
        result.addAll(firstAttestation);
        result.addAll(secondAttestation);
        result.add(finalExam);
        return result;
    }
    
    public double getNumericalPoints(){
    	double totalPoints = 0;

        for (Point point : getPoints()) {
            totalPoints += point.getPoint();
        }
        return totalPoints;
    }

    public double getGPA() {
        double totalPoints = 0;

        for (Point point : getPoints()) {
            totalPoints += point.getPoint();
        }

        double roundedPoints = Math.round(totalPoints);

        if (roundedPoints >= 95) {
            return 4.0;
        } else if (roundedPoints >= 90) {
            return 3.67;
        } else if (roundedPoints >= 85) {
            return 3.33;
        } else if (roundedPoints >= 80) {
            return 3.0;
        } else if (roundedPoints >= 75) {
            return 2.67;
        } else if (roundedPoints >= 70) {
            return 2.33;
        } else if (roundedPoints >= 65) {
            return 2.0;
        } else if (roundedPoints >= 60) {
            return 1.67;
        } else if (roundedPoints >= 55) {
            return 1.33;
        } else if (roundedPoints >= 50) {
            return 1.0;
        } else {
            return 0.0;
        }
    }


    /**
     * @return Returns an alphabetical representation of Student's grade
     */
    public String getGrade(){ // TO DO
        return gpaToAlphabetical.get(getGPA());
    }

    @Override
    public String toString() {
        String firstAtt = "";
        for(Point p : firstAttestation){
            firstAtt += p + " ";
        }
        String secondAtt = "";
        for(Point p : secondAttestation){
            secondAtt += p + " ";
        }
        return "Marks for first attestation:\n" +
                "firstAttestation=" + firstAtt +
                "\nsecondAttestation=" + secondAtt +
                "\nfinalExam=" + finalExam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return Objects.equals(firstAttestation, mark.firstAttestation) && Objects.equals(secondAttestation, mark.secondAttestation) && Objects.equals(finalExam, mark.finalExam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstAttestation, secondAttestation, finalExam);
    }

    public Vector<Point> getFirstAttestation() {
        return firstAttestation;
    }

    public void setFirstAttestation(Vector<Point> firstAttestation) {
        this.firstAttestation = firstAttestation;
    }

    public Vector<Point> getSecondAttestation() {
        return secondAttestation;
    }

    public void setSecondAttestation(Vector<Point> secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    public Point getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(Point finalExam) {
        this.finalExam = finalExam;
    }

}
