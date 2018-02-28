import java.util.*;
public class Assignment8
{
	public static void main(String[] arg)
	{
		PentHouse ForestDrive1 = new PentHouse();
		ForestDrive1.addValuables(new Cash(4000));
		ForestDrive1.addValuables(new Diamond(10000));
		ForestDrive1.addValuables(new Bond(20000));
		ForestDrive1.addValuables(new China(7000));
		ForestDrive1.addValuables(new Jade(3000));
		ForestDrive1.addValuables(new Diamond(40000));
		ForestDrive1.addValuables(new Antique(3000));
		ForestDrive1.addValuables(new Gold(15000));
		ForestDrive1.inventoryValuables();
		System.out.println();
		
		Theif CatBurgler = new Theif();
		CatBurgler.getBag().addLoot(ForestDrive1.rob());
		ForestDrive1.inventoryValuables();
		
		System.out.println();
		CatBurgler.getBag().drop();
		CatBurgler.getBag().checkGoods();
	}
}

class PentHouse
{
	private Valuable[] valuables;
	private final int maxVal = 8;
	private int counter;
	
	public PentHouse()
	{
		valuables = new Valuable[maxVal];
		counter = 0;
	}
	
	public void addValuables(Valuable v)
	{
		if(counter < maxVal)
		{
			valuables[counter++] = v;
		}
	}
	
	public void inventoryValuables()
	{
		System.out.println("The Penthouse has:");
		int count = 0;
		for(count = 0; count < maxVal; count++)
		{
			if(valuables[count] != null)
			{
				System.out.println(valuables[count]);
			}
		}
	}
	
	public Valuable[] rob()
	{
		Random rnd = new Random();
		int items = rnd.nextInt(maxVal);
		Valuable[] release = new Valuable[items];
		for(int count = 0; count < items;)
		{
			int it = rnd.nextInt(items);
			while(valuables[it] != null)
			{
				release[count] = valuables[it];
				valuables[it] = null;
				count++;
			}
		}
		
		return release;
	}
}

class Theif
{
	LootBag myBag = new LootBag();
	
	public LootBag getBag()
	{
		return myBag;
	}
}

class LootBag
{
	private Valuable[] stolenVal;
	int index;
	
	public LootBag()
	{
		stolenVal = new Valuable[8];
		index = 0;
	}
	
	public void addLoot(Valuable[] v)
	{
		for(index = 0; index < v.length; index++)
		{
			stolenVal[index] = v[index];
		}
	}
	
	public void checkGoods()
	{
		System.out.println("The bag has:");
		for(int count = 0; count < 8; count++)
		{
			if(stolenVal[count] != null)
			{
				System.out.println(stolenVal[count]);
			}
		}
	}
	
	public void drop()
	{
		for(int i = 0; i < index; i++)
		{
			if(stolenVal[i] instanceof Breakable)
			{
				Breakable b = (Breakable)stolenVal[i];
				b.breakIt();
			}
		}
	}
}

abstract class Valuable
{
	public double worth;
	public abstract double getWorth();
}

class Cash extends Valuable
{
	Cash(double wrth)
	{
		worth = wrth;
	}
	
	public double getWorth()
	{
		return worth;
	}
	
	public String toString()
	{
		String iAm = "I am Cash and I'm worth $" + getWorth();
		return iAm;
	}
}

class Bond extends Valuable
{
	Bond(double wrth)
	{
		worth = wrth;
	}
	
	public double getWorth()
	{
		return worth;
	}
	
	public String toString()
	{
		String iAm = "I am a Bond and I'm worth $" + getWorth();
		return iAm;
	}
}

class Gold extends Valuable
{
	Gold(double wrth)
	{
		worth = wrth;
	}
	
	public double getWorth()
	{
		return worth;
	}
	
	public String toString()
	{
		String iAm = "I am Gold and I'm worth $" + getWorth();
		return iAm;
	}
}

class China extends Valuable implements Breakable
{
	China(double wrth)
	{
		worth = wrth;
	}
	
	public double getWorth()
	{
		return worth;
	}
	
	public String toString()
	{
		String iAm = "I am Fine China and I'm worth $" + getWorth();
		return iAm;
	}
	
	public void breakIt()
	{
		worth = 0.0;
	}
}

class Antique extends Valuable implements Breakable
{
	Antique(double wrth)
	{
		worth = wrth;
	}
	
	public double getWorth()
	{
		return worth;
	}
	
	public String toString()
	{
		String iAm = "I am an Antique and I'm worth $" + getWorth();
		return iAm;
	}
	
	public void breakIt()
	{
		worth = 0.0;
	}
}

class Diamond extends Valuable implements Breakable
{
	Diamond(double wrth)
	{
		worth = wrth;
	}
	
	public double getWorth()
	{
		return worth;
	}
	
	public String toString()
	{
		String iAm = "I am a Diamond and I'm worth $" + getWorth();
		return iAm;
	}
	
	public void breakIt()
	{
		worth = 0.0;
	}
}

class Jade extends Valuable implements Breakable
{
	Jade(double wrth)
	{
		worth = wrth;
	}
	
	public double getWorth()
	{
		return worth;
	}
	
	public String toString()
	{
		String iAm = "I am Jade and I'm worth $" + getWorth();
		return iAm;
	}
	
	public void breakIt()
	{
		worth = 0.0;
	}
}

interface Breakable
{
	void breakIt();
}