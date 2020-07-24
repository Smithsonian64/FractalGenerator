public class FractalTree {

    int n;
    CoordinateTree coordinateTree;

    public FractalTree(int x, int y, int n, double angle, int scale) {
        this.n = n;
        coordinateTree = new CoordinateTree(x, y, n, angle, scale);
    }

}
