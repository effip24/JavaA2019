// Comment -Good work!


/**
 * class Pen creates a pen methods and values.
 * @author (Ephraim Phil -)
 * @version (4/12/2018)
 */
public class Pen
{
    //variables and constants declaration.
    private String _color;
    private String _made;
    private int _price;
    private double _weight;
    private final int DEFAULT_VALUE = 10;

    /*
     * Constructor of class Pen, creates a new pen object.
     * parameter color is the color of a pen.
     * parameter made is the manufacturer name of a pen.
     * parameter price is the price of a pen.
     * parameter weight is the weight of a pen.
     */
    public Pen(String color, String made, int price,double weight)
    {
        _color = color;
        _made = made;
        //if price or weight less or equal to zero they will get DEFAULT_VALUE which is 0
        if(price <= 0 )
        {
            _price = DEFAULT_VALUE;
            _weight = weight;
        }
        else if(weight <= 0)
        {
            _price = price;
            _weight = DEFAULT_VALUE;
        }
        else
        {
            _price = price;
            _weight = weight;
        }
    }

    /*
     * getColor - returns the pen's color.
     */
    public String getColor()
    {
        return _color;
    }

    /*
     * getMade - return the manufacturer name.
     */
    public String getMade()
    {
        return _made;
    }

    /*
     * isSameMade - checks if two different pens were made by the same manufacturer.
     * parameter other is the other pen to equal to.
     * returns true if two different pens were made by the same manufacturer.
     */
    public boolean isSameMade(Pen other)
    {
        if(_made.equals(other._made))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
     * isSamePrice - checks if two different pens cost the same price.
     * parameter other is the other pen to equal to.
     * returns true if two different pens cost the same price.
     */
    public boolean isSamePrice(Pen other)
    {
        if(_price == other._price)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
     * isBluePen - check if the pen color is blue.
     * and returns true if the pen color is blue.
     */
    public boolean isBluePen()
    {
        if(_color.equals("blue"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
     * getPrice - return the price of a pen.
     */
    public int getPrice()
    {
        return _price;
    }

    /*
     * setPrice - set the price of a pen to a new price.
     * parameter x is the new price of a pen, if x less or equals to 0 the price stays as it was.
     */
    public void setPrice(int x)
    {
        if(x > 0)
        {
            _price = x;
        }
        else
        {
            _price = _price;
        }
    }

    /*
     * getWeight - returns the weight of a pen.
     */
    public double getWeight()
    {
        return _weight;
    }

    /*
     * toString - returns a string that describes a pen.
     */
    public String toString()
    {
        return _color+" pen, made by "+_made+", weights "+_weight+" grams, price: "+_price+" Shekels";
    }

}
