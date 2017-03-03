package cn.mark;

public class PickupType extends Vehicle {

	//皮卡独有两个容量，从父类取得载货，自身还有载客量
	protected int secondCapacity;
	
	public PickupType(String name, double price, int capacity, int secondCapacity){
		this.name = name;
		this.price = price;
		this.capacity = capacity;
		this.secondCapacity = secondCapacity;
	}
	
	@Override
	public String getCapacity() {
		
		return "载货："+capacity+"吨，载人："+secondCapacity+"人";
	}

}
