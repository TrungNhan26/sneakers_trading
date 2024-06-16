package Model.Bean;

public class cart {
	public int uID;
	public String name;
	public double price;
	public String image;
	
	public cart(int uID, String name, double price, String image) {
		super();
		this.uID = uID;
		this.name = name;
		this.price = price;
		this.image = image;
	}
	
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "cart [uID=" + uID + ", name=" + name + ", price=" + price + ", image=" + image + "]";
	}
	
	
}
