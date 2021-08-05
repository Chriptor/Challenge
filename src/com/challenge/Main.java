package com.challenge;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dec=0;
		ArrayList <Vehiculo> Vehiculos= new ArrayList <Vehiculo>();
		ArrayList <Ciudad> Ciudad = new ArrayList <Ciudad>();
		Ciudad.add(new Ciudad(1, "Guadalajara"));
		Ciudad.add(new Ciudad(2, "Tijuana"));
		Ciudad.add(new Ciudad(3, "Culiacan"));
		Ciudad.add(new Ciudad(4, "Toluca"));
		Ciudad.add(new Ciudad(5, "Merida"));
		
		Vehiculos.add(new Vehiculo(1,"Bicicleta",4));
		Vehiculos.add(new Vehiculo(2,"Moto",6));
		Vehiculos.add(new Vehiculo(3,"Cuatrimoto",15));
		Vehiculos.add(new Vehiculo(4,"Carro de Golf",18));
		
		
		while(dec != 3) {
		dec=0;
		System.out.println("\nEscribe 1 para registrar \n2 para reportes \n3 para salir");
		dec=new Scanner(System.in).nextInt();
		
		if(dec==1) {
			Alquiler.registrar();
			
		}else if(dec==2) {
			Alquiler.reportes(Vehiculos, Ciudad);
		}
			
					
		}
	}
}

