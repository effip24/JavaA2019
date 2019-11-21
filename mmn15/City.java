/**
 * Represents information about a city Maman12 question2 2019a.
 *
 * @author (Ephraim Phil -)
 * @version (14/12/2018)
 */
public class City
{
    //variables and constatns declaration
    private String _cityName;
    private Point _cityCenter;
    private Point _centralStation;
    private long _numOfResidents;
    private int _numOfNeighborhoods;
    public final long RESIDENTS_DEFAULT_VALUE = 0;
    public final int NEGHIBORHOODS_DEFAULT_VALUE = 1;

    /**
     * Constructor for objects of class City. 
     * Construct a new city with the specified info. 
     * If numOfResidents is smaller than RESIDENTS_DEFAULT_VALUE, RESIDENTS_DEFAULT_VALUE is used. 
     * If noOfNeighborhoods is smaller than NEGHIBORHOODS_DEFAULT_VALUE, NEGHIBORHOODS_DEFAULT_VALUE is used. 
     * If any coordinate is negative - 0 is used instead.
     * @param cityName  The name of the city.
     * @param cityCenterX  The X coordinate of the center point of the city.
     * @param cityCenterY  The Y coordinate of the center point of the city.
     * @param centralStationX  The X coordinate of the central station of the city.
     * @param centralStationY  The Y coordinate of the central station of the city.
     * @param numOfResidents  The number of residents in the city.
     * @param noOfNeighborhoods  The number of neighborhoods in the city.
     */
    public City(String cityName,double cityCenterX,double cityCenterY,double centralStationX,double centralStationY,long numOfResidents,int numOfNeighborhoods)
    {
        _cityName = cityName;
        _cityCenter = new Point(cityCenterX,cityCenterY);
        _centralStation = new Point(centralStationX,centralStationY);
        if(numOfResidents < RESIDENTS_DEFAULT_VALUE)
        {
            _numOfResidents = RESIDENTS_DEFAULT_VALUE;
        }
        else
        {
            _numOfResidents = numOfResidents;
        }
        if(numOfNeighborhoods < NEGHIBORHOODS_DEFAULT_VALUE)
        {
            _numOfNeighborhoods = NEGHIBORHOODS_DEFAULT_VALUE;
        }
        else
        {
            _numOfNeighborhoods = numOfNeighborhoods;
        }
    }

    /**
     * Constructor for objects of class City. Copy constructor, construct a city using another city.
     * @param other  The city from which to construct the new object
     */
    public City(City other)
    {
        _cityName = other._cityName;
        _cityCenter = new Point(other._cityCenter);
        _centralStation = new Point(other._centralStation);
        _numOfResidents = other._numOfResidents;
        _numOfNeighborhoods = other._numOfNeighborhoods;
    }

    /**
     * Returns the name of the city.
     * @returns The name of the city.
     */
    public String getCityName()
    {
        return _cityName;
    }

    /**
     * Returns the center of the city as a Point object.
     * @returns The center point of the city.
     */
    public Point getCityCenter()
    {
        return new Point(_cityCenter);
    }

    /**
     * Returns the centeral station of the city as a Point object.
     * @returns The central station of the city.
     */
    public Point getCentralStation()
    {
        return new Point(_centralStation);
    }

    /**
     * Returns the number of residents of the city.
     * @returns The number of residents of the city
     */
    public long getNumOfResidents()
    {
        return _numOfResidents;
    }

    /**
     * Returns the number of neighborhoods of the city.
     * @returns The number of neighborhoods of the city
     */
    public int getNoOfNeighborhoods()
    {
        return _numOfNeighborhoods;
    }

    /**
     * Sets the name of the city.
     * @param cityName  The new name of the city
     */
    public void setCityName(String cityName)
    {
        _cityName = cityName;
    }

    /**
     * Sets the center point of the city.
     * @param cityCenter  The new center point of the city
     */
    public void setCityCenter(Point cityCenter)
    {
        _cityCenter = new Point(cityCenter);
    }

    /**
     * Sets the central station point of the city.
     * @param centralStation  The new central station point of the city
     */
    public void setCentralStation(Point centralStation)
    {
        _centralStation = new Point(centralStation);
    }

    /**
     * Sets the number of residents of the city, but only if it is bigger or equal to RESIDENTS_DEFAULT_VALUE.
     * @param numOfResidents  The new number of residents in the city.
     */
    public void setNumOfResidents(long numOfResidents)
    {
        if(numOfResidents >= RESIDENTS_DEFAULT_VALUE)
        {
            _numOfResidents = numOfResidents;
        }
        else
        {
            _numOfResidents = _numOfResidents;
        }
    }

    /**
     * Sets the number of neighborhoods of the city, but only if it is bigger or equal to NEGHIBORHOODS_DEFAULT_VALUE.
     * @param noOfNeighborhoods  The new number of neighborhoods in the city
     */
    public void setNoOfNeighborhoods(int numOfNeighborhoods)
    {
        if(numOfNeighborhoods >= NEGHIBORHOODS_DEFAULT_VALUE)
        {
            _numOfNeighborhoods = numOfNeighborhoods;
        }
        else
        {
            _numOfNeighborhoods = _numOfNeighborhoods;
        }
    }

    /**
     * Returns a string representation of this City in the format
     *<p> City Name: Tel Aviv </p>
     *<p> City Center: (5.0,8.0) </p>
     *<p> Central Station: (3.0,4.0) </p>
     *<p> Number of Residents: 1004 </p>
     *<p> Number of Neighborhoods: 5 </p>
     * @override toString in class java.lang.Object
     * @return A String representation of this city

     */
    public String toString()
    {
        return "City Name: "+_cityName+"\nCity Center: "+_cityCenter+"\nCentral Station: "
        +_centralStation+"\nNumber of Residents: "+_numOfResidents+"\nNumber of Neighborhoods: "+_numOfNeighborhoods;
    }

    /**
     * Adds the given number of residents - either positive or negative number - to the city. 
     * If the resulted number of residents is smaller than RESIDENTS_DEFAULT_VALUE, 
     * RESIDENTS_DEFAULT_VALUE is set to be the new number of residents of the city, and false is returned. 
     * Otherwise (i.e. the resulted number is bigger or equal to RESIDENTS_DEFAULT_VALUE), true is returned.
     * @return false if resulted number of residents is smaller than RESIDENTS_DEFAULT_VALUE, true otherwise
     */
    public boolean addResidents(long residentsUpdate)
    {
        if(residentsUpdate + _numOfResidents >= RESIDENTS_DEFAULT_VALUE)
        {
            _numOfResidents += residentsUpdate;
            return true;
        }
        else
        {
            _numOfResidents = RESIDENTS_DEFAULT_VALUE;
            return false;
        }
    }

    /**
     * Move the location of the central station of the city with the given deltas. 
     * If the new location has a negative coordinate - the central station keeps its original location.
     * @param deltaX  How much the x coordinate of the central station of the city is to be moved
     * @param deltaY  How much the y coordinate of the central station of the city is to be moved
     */
    public void moveCentralStation(double deltaX, double deltaY)
    {
        _centralStation.move(deltaX , deltaY);
    }

    /**
     * Calculates the distance between the center of this city and its central station.
     * @return The distance between the center of this city and its central station.
     */
    public double distanceBetweenCenterAndStation()
    {
        return _cityCenter.distance(_centralStation);
    }

    /**
     * Creates a new city with a new name, 
     * and where its center and central station are moved by the given deltas from this city. 
     * If either new point has negative coordinates - it gets the center or central station of this city. 
     * Its number of residents is set to RESIDENTS_DEFAULT_VALUE and its number of neightborhoods is set to NEGHIBORHOODS_DEFAULT_VALUE.
     * @return A new city with the given values
     */
    public City newCity(String newCityName,double dX,double dY)
    {
        Point cityCenter = new Point(_cityCenter);
        Point centralStation = new Point(_centralStation);
        //if dX or dY is out of first quadrant the cityCenter stays as it was
        cityCenter.move(dX, dY);
        centralStation.move(dX,dY);
        return new City(newCityName,cityCenter.getX(),cityCenter.getY(),centralStation.getX(),centralStation.getY(),RESIDENTS_DEFAULT_VALUE,NEGHIBORHOODS_DEFAULT_VALUE);
    }
}    