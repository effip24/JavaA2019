// Comment - Good work!

/**
 * Represents 2 dimensional points int the polaris system.
 *
 * @author (Ephraim Phil -)
 * @version (14/12/2018)
 */
public class Point
{
    //variable and constant declaration
    private double _radius;
    private double _alpha;
    private final double DEFAULT_VAL = 0;
    private final double QUADRANT_Y_VALUE = 90;
    private final double QUADRANT_X_VALUE = 0;
    /**
     * Constructor for objects of class Point. 
     * Construct a new point with the specified x y coordinates. 
     * If the x coordinate is negative it is set to zero. 
     * If the y coordinate is negative it is set to zero
     * @param x  The x coordinate
     * @param y  The y coordinate 
     */
    public Point(double x,double y)
    {
        if(x <= 0)
        {
            x = DEFAULT_VAL;
        }
        if(y <= 0)
        {
            y = DEFAULT_VAL;
        }
        _radius = setRadius(x , y);
        _alpha = setAlpha(x , y);
    }

    /**
     * Constructor for objects of class Point. Copy constructor, construct a point using another point.
     * @param other  The point from which to construct the new object
     */
    public Point(Point other)
    {
        _radius = other._radius;
        _alpha = other._alpha;
    }

    /**
     * This method returns the x coordinate of the point.
     * @return The x coordinate of the point 
     */
    public double getX()
    {
        return ((double)(Math.round(_radius * Math.cos(_alpha * (Math.PI /180))*10000))/10000.0)  ;
    }

    /**
     * This method returns the y coordinate of the point.
     * @return The y coordinate of the point
     */
    public double getY()
    {
        return (double)(Math.round(_radius * Math.sin(_alpha * (Math.PI/180))*10000))/10000.0 ;
    }

    /**
     * This method sets the x coordinate of the point. 
     * If the new x coordinate is negative the old x coordinate will remain unchanged.
     * @param x  The new x coordinate
     */
    public void setX(double num)
    {
        double y = getY();
        if(num >= 0)
        { 
            {
                _radius = setRadius(num , y);
                _alpha = setAlpha(num , y);
            }
        }
        else
        {
            _radius = _radius;
            _alpha = _alpha;
        }
    }

    /**
     * This method sets the y coordinate of the point. 
     * If the new y coordinate is negative the old y coordinate will remain unchanged.
     * @param y  The new y coordinate

     */
    public void setY(double num)
    {
        double x = getX();
        if(num >= 0)
        {
            _radius = setRadius(x , num);
            _alpha = setAlpha(x , num);

        }
        else
        {
            _radius = _radius;
            _alpha = _alpha;
        }
    }

    /**
     * Returns a string representation of Point in the format (x,y).
     * @override toString in class java.lang.Object
     * @return A String representation of the Point
     */
    public String toString()
    {
        double x = getX();
        double y = getY();
        return "("+x+","+y+")";
    }

    /**
     * Check if the given point is equal to this point.
     * @param other  The point to check equality with
     * @return True if the given point is equal to this point
     */
    public boolean equals(Point other)
    {
        if(_radius == other._radius && _alpha == other._alpha)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Check if this point is above a received point.
     * @param other  The point to check if this point is above
     * @return True if this point is above the other point
     */
    public boolean isAbove(Point other)
    {
        return getY() > other.getY();
    }

    /**
     * Check if this point is below a received point.
     * @param other  The point to check if this point is below
     * @return True if this point is below the other point
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }

    /**
     * Check if this point is left of a received point.
     * @param other  The point to check if this point is left of
     * @return True if this point is left of the other point
     */
    public boolean isLeft(Point other)
    {
        return other.getX() > getX();
    }

    /**
     * Check if this point is right of a received point.
     * @param other  The point to check if this point is right of
     * @return True if this point is right of the other point
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    }

    /**
     * Check the distance between this point and a given point.
     * @param other  The point to check the distance from
     * @return The distance
     */
    public double distance(Point p)
    {
        double x= getX() - p.getX();
        double y = getY() - p.getY();
        return (double)(Math.round(Math.sqrt((Math.pow(y,2)) + Math.pow(x,2)) * 10000)) / 10000.0;
    }

    /**
     * Moves a point. If either coordinate becomes negative the point remains unchanged.
     * @param dx  The difference to add to x
     * @param dy  The difference to add to y
     */
    public void move(double dX, double dY)
    {
        double x = getX();
        double y = getY();
        double newX = x + dX;
        double newY = y + dY;
        //if the movement moves the new point out of the first quadrant the new point stays as it was before
        if(newX < 0 || newY < 0)
        {
            newX = x;
            newY = y;
        }
        else
        {
            newX = newX;
            newY = newY;
        }
        _radius = setRadius(newX , newY);
        _alpha = setAlpha(newX , newY);
    }
    //private method, sets _alpha
    private double setAlpha(double x ,double y)
    {
        double alpha = 0;
        //converts from radians to degree and then checks if the coordinates are in the first quadrant 
        if((Math.atan(y/x) * 180) / Math.PI  >= QUADRANT_X_VALUE && (Math.atan(y/x) * 180) / Math.PI  <= QUADRANT_Y_VALUE)
        {
            alpha = Math.round((Math.atan(y/x) * 90) / (Math.PI / 2) * 10000) / (double)10000 ;
        }
        return alpha;
    }
    //private method, sets _radius 
    private double setRadius(double x, double y)
    {
        double radius;
        radius = (double)(Math.round(Math.sqrt(Math.pow(x,2) + Math.pow(y,2)) * 10000)) / 10000.0;
        return radius;
    }
}