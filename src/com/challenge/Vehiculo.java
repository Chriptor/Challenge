package com.challenge;

public class Vehiculo  {
int id;
String nombre;
int costHora;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getCostHora() {
	return costHora;
}
public void setCostHora(int costHora) {
	this.costHora = costHora;
}
public Vehiculo(int id, String nombre, int costHora) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.costHora = costHora;
}


}
