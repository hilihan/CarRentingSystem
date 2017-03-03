package cn.mark;
/**
 * 载客类
 * @author hilih
 *
 */
public class BusType extends Vehicle {

	public BusType(String name, double price, int capacity){
		this.name = name;
		this.price = price;
		this.capacity = capacity;
	}
	
	@Override
	public String getCapacity() {
		return "载人："+capacity+"人";
	}
	
}
