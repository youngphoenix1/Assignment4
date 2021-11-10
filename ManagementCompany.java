
import java.util.Arrays;

import javafx.scene.layout.Region;

public class ManagementCompany {
	
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MAX_WIDTH = 10, count = 0;
	private int MAX_DEPTH = 10;
	private Plot plot;

	
  public ManagementCompany() {
    properties = new Property[MAX_PROPERTY];
    this.name = "";
    this.taxID = "";
    this.plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
  }

  
  
  public ManagementCompany(String name, String taxID, double mgmFeePer) {
    properties = new Property[MAX_PROPERTY];
    this.name = name;
    this.taxID = taxID;
    this.mgmFeePer = mgmFeePer;
    this.plot = new Plot(0, 0, MAX_WIDTH, MAX_DEPTH);
  }

  /**
   * Copy constructor creates a ManagementCompany object using another ManagementComapany object..
   * @param otherCompany otherCompany is an object that is a copy
   */
  public ManagementCompany(ManagementCompany otherCompany) {
    properties = new Property[MAX_PROPERTY];
    name = otherCompany.name;
    taxID = otherCompany.taxID;
    mgmFeePer = otherCompany.mgmFeePer;
    plot = otherCompany.plot;
  }

  
  public ManagementCompany(
    String name,
    String taxID,
    double mgmFeePer,
    int x,
    int y,
    int width,
    int depth
  ) 
  {
    properties = new Property[MAX_PROPERTY];
    this.name = name;
    this.taxID = taxID;
    this.mgmFeePer = mgmFeePer;
    this.plot = new Plot(x, y, width, depth);
  }

  
  public int getMAX_PROPERTY() {
    return MAX_PROPERTY;
  }

  public int addProperty(Property property) {
    int i;

    for (i = 0; i < count; i++) {
      if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
    }
    
    
    if (count == MAX_PROPERTY) {
      return -1;
    }
    if (property == null) {
      return -2;
    }
    if (this.plot.encompasses(property.getPlot())) {
      return -3;
    } else {
      properties[count] = property;
      count++;
      return count;
    }
  }
  
  
  public int addProperty(String name, String city, double rent, String owner) {
	  
    Property property = new Property(name, city, rent, owner, 0, 0, 1, 1);
    
    //property object into the properties array.
    properties[count] = property;
    count++;
    
    
    int i;
    
    
    for (i = 0; i < count; i++) 
    {
      if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
    }

    if (count == MAX_PROPERTY) 
    {
      return -1;
    }
    if (this.plot.encompasses(property.getPlot())) {
      return -3;
    } else {
      properties[count] = property;
      count++;
      return count;
    }
  }

  public int addProperty(
    String name,
    String city,
    double rent,
    String owner,
    int x,
    int y,
    int width,
    int depth
  ) 
  
  {
    int i;
   
    
    
    Property property = new Property(
      name,
      city,
      rent,
      owner,
      x,
      y,
      width,
      depth
    );
    
    
    properties[count]=property;

    
    for (i = 0; i < count; i++)
    {
      if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
    }
    
    
    if (count == MAX_PROPERTY)
    {
      return -1;
      
    } else if (this.plot.encompasses(property.getPlot()))
    {
      return -3;
    } else {
      properties[count] = property;
      count++;
      
      return count;
    }
  }

  
  public double totalRent() {
    double totalRent = 0.0;

    for (int i = 0; i < count; i++) {
      if (properties[i] != null) {
        totalRent += properties[i].getRentAmount();
      }
    }
    
    return totalRent;
  }

  
  
  public double maxPropertyRent() {
    double maxRentAmount = 0.0;

    maxRentAmount = properties[maxPropertyRentIndex()].getRentAmount();

    return maxRentAmount;
  }

  
  public int maxPropertyRentIndex() {
    int indexOFMaxRent = 0;

    for (int i = 0; i < count; i++) {
      if (properties[i] != null) {
        if (
          properties[indexOFMaxRent].getRentAmount() <
          properties[i].getRentAmount()
        ) {
          indexOFMaxRent = i;
        }
      }
    }

    return indexOFMaxRent;
  }

  public String displayPropertyAtIndex(int i) 
  {
	 String str = "";
    
    
    if (properties[i] != null) {
      str =
        (
          "Owner: " + properties[i].getOwner() +
          "City: " + properties[i].getCity() + "Property Name: " + properties[i].getPropertyName() +
          "Rent Amount: " + properties[i].getRentAmount() + "Plot: " + properties[i].getPlot()
        );
    }

    return str;
  }

  public String toString() 
  {
    String printContent = "";
    
    System.out.println("List of the properties for Alliance, taxID: " + taxID);

    System.out.println("____________");

    for (int i = 0; i < count; i++)
    {
      if (properties[i] != null) printContent =
        (
          " Property Name: " + properties[i].getPropertyName() +
          "\n" + " Located in: " + properties[i].getCity() + "\n" + " Belonging to: " + properties[i].getOwner() 
          + "\n" + " Rent Amount: " + properties[i].getRentAmount()
        );
    }

    System.out.println("______________");
    
    System.out.println("Total management Fee: " + mgmFeePer);

    return printContent;
  }



public String getName() {
	// TODO Auto-generated method stub
	return null;
}



public String maxRentProp() {
	// TODO Auto-generated method stub
	return null;
}



public Region getPlot() {
	// TODO Auto-generated method stub
	return null;
}
}
