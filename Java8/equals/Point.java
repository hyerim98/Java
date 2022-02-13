package equals;

public class Point {
    private int xpos;
    private int ypos;

    public Point(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point)obj;
        if(xpos == p.xpos && ypos == p.ypos){
            return true;
        }
        return false;
    }
}
