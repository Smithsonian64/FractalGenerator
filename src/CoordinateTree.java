public class CoordinateTree {
    CoordinateTree leftTree;
    CoordinateTree rightTree;
    int x;
    int y;
    int level;
    double angle;
    int scale;

    static double rotation;

    public CoordinateTree(int x, int y, int n, double angle, int scale) {

        rotation += angle / 2;

        this.x = x;
        this.y = y;
        int level = n;
        this.angle = angle;
        this.scale = scale;

        //System.out.println("x: " + this.x + ", y: " + this.y);


        if(n != 0) {
            int newX = (int) (scale * Math.sin(this.angle / 2)) + this.x;
            int newY = (int) (scale * Math.cos(this.angle / 2)) + this.y;

            int newNewX = (int) (newX * Math.cos(this.angle) - newY * Math.sin(this.angle));
            int newNewY = (int) (newY * Math.cos(this.angle) + newX * Math.sin(this.angle));

            //System.out.println();
            //System.out.println("LEFT newX: " + newX + ", newY: " + newY);

            this.leftTree = new CoordinateTree(newNewX, newNewY, n - 1, this.angle,  3 * this.scale / 4);



            newX = (int) (scale * Math.sin(-this.angle / 2)) + this.x;
            newY = (int) (scale * Math.cos(-this.angle / 2)) + this.y;

            newNewX = (int) (newX * Math.cos(-this.angle) - newY * Math.sin(-this.angle));
            newNewY = (int) (newY * Math.cos(-this.angle) + newX * Math.sin(-this.angle));

            //System.out.println("RIGHT newX: " + newX + ", newY: " + newY);
            //System.out.println();

            this.rightTree = new CoordinateTree(newNewX, newNewY, n - 1, this.angle,  3 * this.scale / 4);
        }

        //

    }



}
