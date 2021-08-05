package com.challenge;

public class Orden implements Comparable<Orden>{
	int ciudad;
	int Total;
	public int getCiudad() {
		return ciudad;
	}
	public void setCiudad(int ciudad) {
		this.ciudad = ciudad;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	public Orden(int ciudad, int total) {
		super();
		this.ciudad = ciudad;
		Total = total;
	}
	
	@Override
	public int compareTo(Orden e) {
		if(e.getTotal()>Total) {
			return -1;
		}else if(e.getTotal()<Total) {
			return 0;
		}else{
			return 1;
		}
	}
	
}
