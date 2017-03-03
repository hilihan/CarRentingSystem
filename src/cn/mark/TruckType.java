package cn.mark;
/**
 * 载货类
 * @author hilih
 *
 */
public class TruckType extends Vehicle {

	public TruckType(String name, double price, int capacity){
		this.name = name;
		this.price = price;
		this.capacity = capacity;
	}
	
	@Override
	public String getCapacity() {
		return "载货："+capacity+"吨";
	}
	
}
