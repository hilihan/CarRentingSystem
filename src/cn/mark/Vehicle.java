package cn.mark;
/**
 * 车类
 * 所有的汽车都具有该类的属性和方法
 * @author hilih
 *
 */
public abstract class Vehicle {
	//车名
	protected String name;
	//租金价格
	protected double price;
	//载货容量
	protected int capacity;
	
	//获取车辆车型
	public String getName(){
		return name;
	}
	
	//获取车辆容量
	public abstract String getCapacity();
	
	//获取车辆租金
	public String getPrice(){
		return price+"元/天";
	}
	
	
}
