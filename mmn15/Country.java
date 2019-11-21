/**
 * Represents a country and contains an array of its cities.
 *
 * @author (Ephraim Phil -)
 * @version (30/12/2018)
 */
public class Country
{
    private String _countryName;
    private City [] _cities;
    private int _nomOfCities;
    private final int MAX_NUM_OF_CITIES = 100;

    /**
     * Constructor for objects of class Country. 
     * Construct a new country which contain an array of cities. 
     * @param countryName  The name of the country.
     */
    public Country(String countryName)
    {   
        _countryName = countryName;
        _cities = new City[MAX_NUM_OF_CITIES];
        _nomOfCities = 0;
    }

    /**
     * This method adds a city to the the country.
     * @param cityName the name of the new city.
     * @param cityCenterX the new cityCenter x coordinate of the new city.
     * @param cityCenterY the new cityCenter Y coordinate of the new city.
     * @return true if there is a place in the array for one more city and the city has been added. 
     */
    public boolean addCity(String cityName, double cityCenterX,double cityCenterY,double centralStationX,double centralStationY,long numOfResidents,int numOfNeighborhoods)
    {
        if(_nomOfCities == MAX_NUM_OF_CITIES)
        {
            return false;
        }
        _cities[_nomOfCities++] = new City(cityName, cityCenterX, cityCenterY, centralStationX, centralStationY, numOfResidents, numOfNeighborhoods);
        return true;
    }

    /**
     * This method returns the number of residents of the whole country.
     * @return the number of residents of the whole country. 
     */
    public int getNumOfResidents()
    {
        int sum = 0;
        for(int i = 0; i < _nomOfCities;i++)
        {
            sum += _cities[i].getNumOfResidents();
        }
        return sum;
    }

    /**
     * This method returns the longest distance between two cities.
     * <p> if the number of cities in the country is is leass than 2 the methods returns 0</p>
     * @return the longest distance between two cities. 
     */
    public double longestDistance()
    {
        if(_nomOfCities < 2)
        {
            return 0;
        }
        else
        {
            City a = new City(_cities[0]);
            City b = new City(_cities[1]);
            double aDistanceB = a.getCityCenter().distance(b.getCityCenter());
            for (int i = 0; i < _nomOfCities; i++) 
                for (int j = i + 1; j < _nomOfCities; j++)
                {
                    if(_cities[i].getCityCenter().distance(_cities[j].getCityCenter()) > aDistanceB)
                    {
                        a = new City(_cities[i]);
                        b = new City(_cities[j]);
                        aDistanceB = a.getCityCenter().distance(b.getCityCenter());
                    }
                }
            return aDistanceB;
        }
    }

    /**
     * This method returns the northen cities of a specific city in the country in this format:
     * The cities north of Eilat are: </p>
     * <p> City Name: TelAviv  </p>
     * <p> City Center: (10.0,10.0) </p>
     * <p> Central Station: (8.0,8.0) </p>
     * <p> Number of Residents: 10000 </p>
     * <p> Number of Neighborhoods: 5 </p>
     * 
     * <p> City Name: Jerusalem  </p>
     * <p> City Center: (3.0,20.0) </p>
     * <p> Central Station: (4.0,18.0) </p>
     * <p> Number of Residents: 20000 </p>
     * <p> Number of Neighborhoods: 8 </p>
     * @param cityName the city to find which cities are north of to it
     * @return the northen cities of a specific city in the array. 
     */
    public String citiesNorthOf(String cityName)
    {
        String northCities = "";
        boolean cityInArray = false;
        boolean noNorthenCity = true;

        //creating a for loop to search in the array
        for(int i = 0; i < _nomOfCities; i++)
        {
            //finding cityName which is the desired city in the array
            if(_cities[i].getCityName().equals(cityName))
            {
                //cityInArray is a flag to indicate if there is a city named cityName int the array
                cityInArray = true;
                for(int j=0; j< _nomOfCities; j++)
                {
                    //this loop checks if the cityCcenter of the cities in the array are north of CityName
                    if(_cities[j].getCityCenter().isAbove(_cities[i].getCityCenter()))
                    {
                        //noNorthenCity is a flag to indicate if there is no northen cities
                        noNorthenCity = false;
                        northCities = northCities + "\n" + _cities[j].toString() + "\n" ;
                    }
                }
            }
        }
        // checks if cityInArray flag is false, if it is then it returns that there is no city by the name cityName
        if (cityInArray == false)
        {
            northCities = null;
            return "There is no city with the name "+cityName;
        }
        // checks if cityInArray flag is false, if it is then it returns that there is no city cities north of cityName
        if(noNorthenCity == true)
        {
            northCities = null;
            return "There are no cities north of "+cityName;
        }

        return "The cities north of "+cityName + " are:\n "+northCities;
    }

    /**
     * This method returns the southern most City in the array.
     * <p> if there are no cities in the country, null will be returned</p>
     * @return the southern most City in the country. 
     */
    public City southernmostCity()
    {       
        //cheks if there are no cities in the array then returns null
        if(_nomOfCities <= 0)
        {
            return null;
        }
        else
        {
            City southernCity = new City(_cities[0]);
            for(int i = 0; i< _nomOfCities ; i++)
            {
                // equals the cityCenter of the cities in the array to find out which is the southern city
                if(_cities[i].getCityCenter().getY() < southernCity.getCityCenter().getY())
                {
                    southernCity = new City(_cities[i]);
                }
            }
            return new City(southernCity);
        }
    }

    /**
     * This method returns the name of the County.
     * @return the name of the County. 
     */
    public String getCountryName()
    {
        return _countryName;
    }

    /**
     * This method returns the number of cities of the County.
     * @returns the number of cities of the County. 
     */
    public int getNumOfCities()
    {
        return _nomOfCities;
    }

    /**
     * This method returns a copy array with the cities in the country.
     * @returns returns a copy array with the cities in the country. 
     */
    public City [] getCities()
    {
        //new array for the return city
        City [] cities = new City[_nomOfCities];
        for(int i = 0; i<_nomOfCities;i++)
        {
            // copies the cities to the new array from the original
            cities[i] = new City(_cities[i]);

        }
        return cities;
    }

    /**
     * This method unifies two cities in the array to one city.
     * <p> The name of the unified city will be: "city1-city2 </p>
     * <p> the number of residents of the unified city is the sum of city1 and city2 </p>
     * <p> the cityCenter of the unified city is the middle between the cityCenter of cityName1 and cityCenter of cityName2</p>
     * <p> the centralStation of the unified city is the western centralStation of cityName1 or cityName2 </p>
     * @param cityName1 the first city in the array to unify.
     * @param cityName2 the second city in the array to unify
     * @returns returns a new city, unified city of cityName1 and cityName2. 
     */
    public City unifyCities(String cityName1, String cityName2)
    {
        String newCityName = "";
        double oldCityCenterX = 0;
        double oldCityCenterY = 0;
        Point oldCentralStation1 = new Point(_cities[0].getCentralStation());
        Point oldCentralStation2 = new Point(_cities[0].getCentralStation());

        double newCityCenterX = 0;
        double newCityCenterY = 0;
        double newCentralStationX;
        double newCentralStationY;

        long numOfResidents = 0;
        int numOfNeighborhoods = 0;
        //bollean flags indicates if cityname1 and cityname2 are in the array
        boolean city1 = false;
        boolean city2 = false;
        //extracting cityName1 information from the arry
        for(int i = 0;i < _nomOfCities;i++)
        {
            if(_cities[i].getCityName().equals(cityName1))
            {
                city1 = true;
                newCityName = _cities[i].getCityName();
                numOfResidents = _cities[i].getNumOfResidents();
                numOfNeighborhoods = _cities[i].getNoOfNeighborhoods();
                oldCityCenterX = _cities[i].getCityCenter().getX();
                oldCityCenterY = _cities[i].getCityCenter().getY();
                oldCentralStation1 = new Point(_cities[i].getCentralStation());
            }
        }
        //extracting cityName2 information from the array and adding cityName 1 to them
        for (int i = 0;i < _nomOfCities;i++)
        {
            if(_cities[i].getCityName().equals(cityName2))
            {
                city2 = true;
                newCityName = newCityName + " - "+_cities[i].getCityName();
                numOfResidents += _cities[i].getNumOfResidents();
                numOfNeighborhoods += _cities[i].getNoOfNeighborhoods();
                newCityCenterX = (_cities[i].getCityCenter().getX() + oldCityCenterX) / 2;
                newCityCenterY = (_cities[i].getCityCenter().getY() + oldCityCenterY) / 2;
                oldCentralStation2 = new Point(_cities[i].getCentralStation());
            }
        }
        //checking if cityname1 and cityname2 are in the array if not return null
        if(city1 == true && city2 == true)
        {
            if(oldCentralStation1.isLeft(oldCentralStation2))
            {
                newCentralStationX = oldCentralStation1.getX();
                newCentralStationY = oldCentralStation1.getY();
            }
            else
            {
                newCentralStationX = oldCentralStation1.getX();
                newCentralStationY = oldCentralStation1.getY();
            }
            for(int i = 0; i < _nomOfCities; i++)
            {
                //finding cityName1 in the array
                if(_cities[i].getCityName().equals(cityName1))
                {
                    for(int y = 0; y < _nomOfCities ;y++)
                    {
                        //finding cityName2 in the array
                        if(_cities[y].getCityName().equals(cityName2))
                        {
                            //checking if CityName1 number of residents bigger then cityName2
                            if (_cities[i].getNumOfResidents() > _cities[y].getNumOfResidents())
                            {
                                //unify the cities and putting them instead of CityName1;
                                _cities[i] = new City(newCityName, newCityCenterX, newCityCenterY, newCentralStationX, newCentralStationY, numOfResidents, numOfNeighborhoods);
                                //delete the city with smallest residents from the array
                                for(int j = y; j < _nomOfCities - 1;j++)
                                {
                                    _cities[j] = _cities[j+1];
                                }
                                _cities[_nomOfCities-1] = null;
                                _nomOfCities--;
                            }
                            //checking if CityName2 number of residents bigger then cityName1
                            if (_cities[i].getNumOfResidents() < _cities[y].getNumOfResidents())
                            {
                                //unify the cities and putting them instead of CityName2;
                                _cities[y] = new City(newCityName, newCityCenterX, newCityCenterY, newCentralStationX, newCentralStationY, numOfResidents, numOfNeighborhoods);
                                //delete the city with smallest residents from the array
                                for(int h = i; h < _nomOfCities -1; h++)
                                {
                                    _cities[h] = _cities[h +1];
                                }
                                _cities[_nomOfCities - 1] = null;
                                _nomOfCities--;
                            }
                            //checking if CityName and CityName 2 has the same amount of residents 
                            if(_cities[i].getNumOfResidents() == _cities[y].getNumOfResidents())
                            {
                                for(int a = 0 ; a < _nomOfCities; a++)
                                {
                                    //finding cityName2 in the array
                                    if(_cities[a].getCityName().equals(cityName2)) 
                                    {
                                        //delete CityName2 from array
                                        for(int b = a; b< _nomOfCities -1; b++)
                                        {
                                            _cities[a] = _cities[a+1];
                                        }
                                        _cities[_nomOfCities - 1] = null;
                                        _nomOfCities--;
                                    }
                                }
                                //puting the unify city in cityName1 place in the array
                                _cities[i] = new City(newCityName, newCityCenterX, newCityCenterY, newCentralStationX, newCentralStationY, numOfResidents, numOfNeighborhoods);
                            }
                        }                    
                    }
                }
            }
            return new City(newCityName, newCityCenterX, newCityCenterY, newCentralStationX, newCentralStationY, numOfResidents, numOfNeighborhoods);
        }
        else
        {
            return null;
        }
    }

    /**
     * Returns a string representation of the cities in the country in the format:
     *  <p> Cities of Israel : 36 </p>
     *  <p> City Name: TelAviv </p>  
     *  <p> City Center: (10.0,10.0) </p> 
     *  <p> Central Station: (8.0,8.0) </p> 
     *  <p> Number of Residents: 10000 </p>
     *  <p> Number of Neighborhoods: 5 </p>
     *  <p></p>
     *  <p> City Name: Jerusalem </p> 
     *  <p> City Center: (3.0,20.0) </p>
     *  <p> Central Station: (4.0,18.0) </p> 
     *  <p> Number of Residents: 20000 </p>
     *  <p> Number of Neighborhoods: 8 </p>
     * @override toString in class java.lang.Object
     * @return A String representation of the Point
     */
    public String toString()
    {
        String toString = "";
        for(int i = 0; i < _nomOfCities; i++)
        {
            toString = toString + "\n" +_cities[i].toString() + "\n";

        }
        return "Cities of "+getCountryName()+": \n"+toString;
    }
}
// Comments - 
//Error in unifyCities: failed to add 997 cities after 4 cities were added at first and two cities were then unified. Minus 3 points
//Error in addcity: failed to add 101 cities to an empty array. Minus 3 points
//trying to add 1001 city
//Could not test adding city number 1001 to a FULL array, because addCity fails earlier (see previous error message) 3 points