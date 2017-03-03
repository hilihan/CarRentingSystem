package cn.mark;

import java.util.Scanner;

public class Rent {
	private static Vehicle[] vehicles;

	static{
		//一运行租车系统就开始创建租车列表
		vehicles = new Vehicle[]{
				new BusType("奥迪A4",500,4),
				new BusType("马自达6",400,4),
				new PickupType("皮卡雪6",450,2,4),
				new BusType("金旅客车",800,20),
				new TruckType("松花江", 400, 4),
				new TruckType("依维柯", 1000, 20)
		};
	}
	
	public static void main(String[] args) {
		System.out.println("欢迎使用大鑫租车系统：\n您是否要租车：1.是 0.否");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if ( input == 1 ){
			//为1才进行租车
			showRentList();
			System.out.println("请输入您要租车的数量：");
			input = sc.nextInt();
			int[] userRent =createUserRentList(input , sc);//初始化用户租车列表
			System.out.println("请输入租车天数：");
			int rentDay = sc.nextInt();
			bill(userRent, rentDay );//账单结算
			
		}
		System.out.println("欢迎下次使用~~客官再见！");
		sc.close();

	}

	/**
	 * 可租车列表展示
	 */
	public static void showRentList() {
		System.out.println("您可租车的类型及其价目表：");
		System.out.println("\t序号       汽车名称                 租金                        容量");
		for( int i = 0; i < vehicles.length; i++ ){
			System.out.print("\t  "+(i+1)+".");
			System.out.print("\t        "+vehicles[i].getName());
			System.out.print("\t        "+vehicles[i].getPrice());
			System.out.println("\t       "+vehicles[i].getCapacity());
		}
	}
	
	/**
	 * 生成用户租车列表
	 * @param num 用户租车数量
	 * @return 租车列表序号
	 */
	public static int[] createUserRentList(int num , Scanner sc){
		//TODO 输入合法性判断
		int[] userRent = new int[num];//用户租车列表
		for( int i = 0; i < userRent.length; i++ ){
			System.out.println("请输入第"+(i+1)+"辆车的序号：");
			userRent[i] = sc.nextInt()-1;
		}
		return userRent;
	}

	/**
	 * 租车账单
	 * @param userRent 租车列表
	 * @param rentDay 租车天数
	 */
	public static void bill( int[] userRent, int rentDay ){
		String rentTruckName = "";
		String rentBusName = "";
		String pickName = "";
		int truckCapacity = 0;
		int busCapacity = 0;
		int[] pickupCapacity = new int[2];//第一位为载客，第二位为载货
		int truckSum = 0;
		int busSum = 0;
		int pickupSum = 0;
		
		//取车
		Vehicle[] rentCar = new Vehicle[userRent.length];
		for( int i = 0; i < userRent.length; i++ ){
			rentCar[i] = vehicles[ userRent[i] ];//从车库提车
		}
		//按照不同类型计算
		for( int i = 0; i < rentCar.length; i++ ){
			Vehicle v = rentCar[i];
			if( v instanceof TruckType){
				TruckType t = (TruckType)v;
				rentTruckName =rentTruckName+ t.getName()+"  ";
				truckCapacity += t.capacity;
				truckSum += t.price;
			}else if(  v instanceof BusType ){
				BusType b = (BusType)v;
				rentBusName = rentBusName+b.getName()+"  ";
				busCapacity += b.capacity;
				busSum += b.price;
			}else{
				PickupType p = (PickupType)v;
				pickName = pickName+p.getName()+"  ";
				pickupCapacity[0] = p.capacity;
				pickupCapacity[1] = p.secondCapacity;
				pickupSum+=p.price;
			}
		}
		System.out.println("您的账单：");
		if(!rentTruckName.equals("")){
			System.out.println("***可载货的车有：");
			System.out.print(rentTruckName);
			System.out.println("总共载货："+ truckCapacity+"吨");
		}
		if(!rentBusName.equals("")){
			System.out.println("***可载人的车有：");
			System.out.print(rentBusName);
			System.out.println("总共载人："+ busCapacity+"人");
		}
		if(!pickName.equals("")){
			System.out.println("***皮卡车有：");
			System.out.print(pickName);
			System.out.print("总共载货："+ pickupCapacity[0]+"吨，");
			System.out.println("总共载人："+ pickupCapacity[1]+"人");
		}
		System.out.println("***租车总价格："+((truckSum+busSum+pickupSum)*rentDay)+"元");
	}
}
