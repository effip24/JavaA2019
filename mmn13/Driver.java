import java.util.Scanner;
//Ephraim Phil - 
//class Driver checks the methods of class Pen

// Comment - you should check the methods isSamePrice isSameMade   -4 points
public class Driver
{
    public static void main(String [] args)
    {
        //variable declaration
        Scanner scan = new Scanner(System.in);
        String color;
        String made;
        int price;
        double weight;

        //getting values from user and creating penA
        System.out.println("Please insert Pen's A color: ");
        color = scan.next();
        System.out.println("Please insert the manufacture name of Pen A: ");
        made = scan.next();
        System.out.println("Please insert Pen's A price: ");
        price = scan.nextInt();
        System.out.println("Please insert Pen's A weight: ");
        weight = scan.nextDouble();
        Pen penA = new Pen(color, made, price, weight);

        //getting values from user and creating penB
        System.out.println("Please insert pen's B color: ");
        color = scan.next();
        System.out.println("Please insert the manufacture name of pen B: ");
        made = scan.next();
        System.out.println("Please insert Pen's B price: ");
        price = scan.nextInt();
        System.out.println("Please insert the Pen's B weight: ");
        weight = scan.nextDouble();
        Pen penB =new Pen(color, made, price, weight);

        //printing penA and penB information to the screen;
        System.out.println("");
        System.out.println("penA toString:");
        System.out.println(penA.toString());
        System.out.println("penB toString:");
        System.out.println(penB.toString()+"\n");

        //checking the method getColor()  on penA and penB;
        System.out.println("checking the method getColor()  on penA and penB");
        System.out.println("penA color is: "+penA.getColor());
        System.out.println("penB color is: "+penB.getColor()+"\n");

        //checking the method getMade()  on penA and penB;
        System.out.println("checking the method getMade()  on penA and penB");
        System.out.println("penA made by: "+penA.getMade());
        System.out.println("penB made by: "+penB.getMade()+"\n");

        //checking the method isSameMade()  on penA and penB;
        System.out.println("checking the method isSameMade()  on penA and penB and the opposite");
        System.out.println("penA was made by the same manufacturer as penB: "+penA.isSameMade(penB));
        System.out.println("penB was made by the same manufacturer as penA: "+penA.isSameMade(penB)+"\n");

        //checking the method isSamePrice() on penA and penB
        System.out.println("checking the method isSamePrice() on penA and penB");
        System.out.println("penA is the same price as penB: "+penA.isSamePrice(penB));
        System.out.println("penB is the same price as penA: "+penB.isSamePrice(penA)+"\n");

        //checking the method isBluePen() on penA and penB;
        System.out.println("checking the method isBluePen() on penA and penB");
        System.out.println("penA is blue: "+penA.isBluePen());
        System.out.println("penB is blue: "+penB.isBluePen()+"\n");

        //checking the method getPrice() on penA and penB;
        System.out.println("checking the method getPrice() on penA and penB");
        System.out.println("penA price is: "+penA.getPrice());
        System.out.println("penB price is: "+penB.getPrice()+"\n");

        //checking the method setPrice() on penA and penB;
        System.out.println("checking the method setPrice() on penA and penB\npenA.setPrice(7)\npenB.setPrice(8)\n");
        penA.setPrice(7);
        penB.setPrice(8);

        //checking if setPrice() method worked
        System.out.println("checking if setPrice() method worked");
        System.out.println("penA new price is (should be 7): "+penA.getPrice());
        System.out.println("penB new price is (should be 8): "+penB.getPrice()+"\n");

        //checking if setPrice() method worked when x is less or equal to 0
        System.out.println("checking if setPrice() method worked when x is less or equal to 0\n"
            +"penA.setPrice(-1);\npenB.setPrice(0)\n");
        penA.setPrice(-1);
        penB.setPrice(0);
        System.out.println("penA new price is(price should stay 7): "+penA.getPrice());
        System.out.println("penB new price is, (price should stay 8): "+penB.getPrice()+"\n");

        //checking getWeight() method 
        System.out.println("checking getWeight() method ");
        System.out.println("penA weight is: "+penA.getWeight());
        System.out.println("penB weight is: "+penB.getWeight());
    }
}