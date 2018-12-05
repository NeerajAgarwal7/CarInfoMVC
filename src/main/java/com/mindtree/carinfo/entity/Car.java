package com.mindtree.carinfo.entity;

public class Car implements Comparable<Car> {

	@Override
	public String toString() {
		return "Car [modelNum=" + modelNum + ", modelName=" + modelName + ", price=" + price + "]\n";
	}

	private int modelNum;
	private String modelName;
	private double price;

	public Car() {
		super();
	}

	public Car(int num, String name, double price) {
		this.modelNum = num;
		this.modelName = name;
		this.price = price;
	}

	public int getModelNum() {
		return modelNum;
	}

	public void setModelNum(int modelNum) {
		this.modelNum = modelNum;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Car c) {

		if (price == c.price) {
			int i = modelName.compareToIgnoreCase(c.getModelName());
			if (i > 0)
				return 1;
			else if (i < 0)
				return -1;
			else
				return 0;

		} else if (price > c.price)
			return 1;
		else
			return -1;
	}

}
