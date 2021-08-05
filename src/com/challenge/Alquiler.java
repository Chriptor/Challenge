package com.challenge;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;





public class Alquiler {
	int cd;
	int vh;
	int conVh;
	int conHrs;
	static String ruta = "C:\\Users\\Public\\Data.txt";
	
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public int getVh() {
		return vh;
	}
	public void setVh(int vh) {
		this.vh = vh;
	}
	public int getConVh() {
		return conVh;
	}
	public void setConVh(int conVh) {
		this.conVh = conVh;
	}
	public int getConHrs() {
		return conHrs;
	}
	public void setConHrs(int conHrs) {
		this.conHrs = conHrs;
	}
	public Alquiler(int cd, int vh, int conVh, int conHrs) {
		super();
		this.cd = cd;
		this.vh = vh;
		this.conVh = conVh;
		this.conHrs = conHrs;
	}
	public Alquiler() {
		// TODO Auto-generated constructor stub
	}
	public static void revisarDB() {
		try {
            
            String contenido = "1,1,1,1;";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static String LeerDB() {
	    String line = "";
	        try {
	            Scanner input = new Scanner(new File(ruta));
	            while (input.hasNextLine()) {
	                line = input.nextLine();
	                
	                
	            }
	            input.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
			return line;
	    }
	
	public static void registrar() {
		Alquiler alq=new Alquiler();
		String reg2="";
		System.out.println("Ingresa el numero para registrar la Ciudad");
		System.out.println(" 1 Guadalajara \n 2 Tiuana \n 3 Culiacan \n 4 Toluca  \n 5 Merida");
		Scanner leer1=new Scanner(System.in);
		alq.setCd(leer1.nextInt());
		System.out.println("Ingresa el numero para registrar el Vehiculo");
		System.out.println(" 1 Bicicleta \n 2 Moto \n 3 Cuatrimoto \n 4 Carro de Golf");
		Scanner leer2=new Scanner(System.in);
		alq.setVh(leer2.nextInt());
		System.out.println("Ingresa numero de vehiculos");
		Scanner leer3=new Scanner(System.in);
		alq.setConVh(leer3.nextInt());
		System.out.println("Ingresa el numero de horas");
		Scanner leer4=new Scanner(System.in);
		alq.setConHrs(leer4.nextInt());
		revisarDB();
		String data=LeerDB();
		reg2=Integer.toString(alq.getCd()).concat(",")+Integer.toString(alq.getVh()).concat(",")+Integer.toString(alq.getConVh()).concat(",")+Integer.toString(alq.getConHrs()).concat(";");
        String contenido = data.concat(reg2);
        FileWriter fichero = null;
        PrintWriter pw= null;
        try {
        	fichero=new FileWriter(ruta, true);
        	pw = new PrintWriter(fichero);
        	pw.print(contenido);
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}finally {
			if(null != fichero) {
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		        	
	}
	public static void reportes(ArrayList<Vehiculo> vh, ArrayList<Ciudad> cdArray) {
		ArrayList <Alquiler> Alqu= new ArrayList <Alquiler>();
		
		String data=LeerDB();
		String[] parts=data.split(";");
		String ciudad = null;
		String vehi = null;
		String numVehi = null;
		String numHrs = null;
		int facCd1=0;
		int facCd2=0;
		int facCd3=0;
		int facCd4=0;
		int facCd5=0;
		int contCd=0;
		int facVh1Cd1=0;
		int facVh2Cd1=0;
		int facVh3Cd1=0;
		int facVh4Cd1=0;
		int facVh1Cd2=0;
		int facVh2Cd2=0;
		int facVh3Cd2=0;
		int facVh4Cd2=0;
		int facVh1Cd3=0;
		int facVh2Cd3=0;
		int facVh3Cd3=0;
		int facVh4Cd3=0;
		int facVh1Cd4=0;
		int facVh2Cd4=0;
		int facVh3Cd4=0;
		int facVh4Cd4=0;
		int facVh1Cd5=0;
		int facVh2Cd5=0;
		int facVh3Cd5=0;
		int facVh4Cd5=0;
		int contVh=0;
		
		for (int x=0; x<parts.length; x++) { 
			ciudad=parts[x].substring(0,1);
			vehi=parts[x].substring(2,3);
			numVehi=parts[x].substring(4,5);
			numHrs=parts[x].substring(6,7);
			Alqu.add(new Alquiler(Integer.parseInt(ciudad),
					Integer.parseInt(vehi),
					Integer.parseInt(numVehi),
					Integer.parseInt(numHrs)));
				}
		for(int i=0; i<Alqu.size(); i++) {
			if(Alqu.get(i).getCd()==1) { 
				if(Alqu.get(i).getVh()==1) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(0).getCostHora();
					contCd=contVh;
					facVh1Cd1=facVh1Cd1+contVh;
				}else if(Alqu.get(i).getVh()==2) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(1).getCostHora();
					contCd=contVh;
					facVh2Cd1=facVh2Cd1+contVh;
				}else if(Alqu.get(i).getVh()==3) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(2).getCostHora();
					contCd=contVh;
					facVh3Cd1=facVh3Cd1+contVh;
				}else {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(3).getCostHora();
					contCd=contVh;
					facVh4Cd1=facVh4Cd1+contVh;
				}
				facCd1=facCd1+contCd;
			}else if(Alqu.get(i).getCd()==2) {
				if(Alqu.get(i).getVh()==1) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(0).getCostHora();
					contCd=contVh;
					facVh1Cd2=facVh1Cd2+contVh;
				}else if(Alqu.get(i).getVh()==2) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(1).getCostHora();
					contCd=contVh;
					facVh2Cd2=facVh2Cd2+contVh;
				}else if(Alqu.get(i).getVh()==3) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(2).getCostHora();
					contCd=contVh;
					facVh3Cd2=facVh3Cd2+contVh;
				}else {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(3).getCostHora();
					contCd=contVh;
					facVh4Cd2=facVh4Cd2+contVh;
				}
				facCd2=facCd2+contCd;
			}else if(Alqu.get(i).getCd()==3) {
				if(Alqu.get(i).getVh()==1) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(0).getCostHora();
					contCd=contVh;
					facVh1Cd3=facVh1Cd3+contVh;
				}else if(Alqu.get(i).getVh()==2) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(1).getCostHora();
					contCd=contVh;
					facVh2Cd3=facVh2Cd3+contVh;
				}else if(Alqu.get(i).getVh()==3) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(2).getCostHora();
					contCd=contVh;
					facVh3Cd3=facVh3Cd3+contVh;
				}else {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(3).getCostHora();
					contCd=contVh;
					facVh4Cd3=facVh4Cd3+contVh;
				}
				facCd3=facCd3+contCd;
			}else if(Alqu.get(i).getCd()==4) {
				if(Alqu.get(i).getVh()==1) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(0).getCostHora();
					contCd=contVh;
					facVh1Cd4=facVh1Cd4+contVh;
				}else if(Alqu.get(i).getVh()==2) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(1).getCostHora();
					contCd=contVh;
					facVh2Cd4=facVh2Cd4+contVh;
				}else if(Alqu.get(i).getVh()==3) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(2).getCostHora();
					contCd=contVh;
					facVh3Cd4=facVh3Cd4+contVh;
				}else {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(3).getCostHora();
					contCd=contVh;
					facVh4Cd4=facVh4Cd4+contVh;
				}
				facCd4=facCd4+contCd;
			}else {
				if(Alqu.get(i).getVh()==1) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(0).getCostHora();
					contCd=contVh;
					facVh1Cd5=facVh1Cd5+contVh;
				}else if(Alqu.get(i).getVh()==2) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(1).getCostHora();
					contCd=contVh;
					facVh2Cd5=facVh2Cd5+contVh;
				}else if(Alqu.get(i).getVh()==3) {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(2).getCostHora();
					contCd=contVh;
					facVh3Cd5=facVh3Cd5+contVh;
				}else {
					contVh=Alqu.get(i).getConVh()*
							Alqu.get(i).getConHrs()*
							vh.get(3).getCostHora();
					contCd=contVh;
					facVh4Cd5=facVh4Cd5+contVh;
				}
				facCd5=facCd5+contCd;
			}
		}
		int[][] vhsCds= {{facVh1Cd1,facVh2Cd1,facVh3Cd1,facVh4Cd1},
						{facVh1Cd2,facVh2Cd2,facVh3Cd2,facVh4Cd2},
						{facVh1Cd3,facVh2Cd3,facVh3Cd3,facVh4Cd3},
						{facVh1Cd4,facVh2Cd4,facVh3Cd4,facVh4Cd4},
						{facVh1Cd5,facVh2Cd5,facVh3Cd5,facVh4Cd5}};
		//Reporte 1
		for(int i=0; i<cdArray.size(); i++) {
			System.out.println("La Ciudad: " + cdArray.get(i).getNombre() + " reporta");
			for(int j=0; j<vh.size(); j++) {
			System.out.println(vh.get(j).getNombre() + " " + vhsCds[i][j] + " USD");
			}
			System.out.println("\n");
		}
		int sumCd1=facVh1Cd1+facVh2Cd1+facVh3Cd1+facVh4Cd1;
		int sumCd2=facVh1Cd2+facVh2Cd2+facVh3Cd2+facVh4Cd2;
		int sumCd3=facVh1Cd3+facVh2Cd3+facVh3Cd3+facVh4Cd3;
		int sumCd4=facVh1Cd4+facVh2Cd4+facVh3Cd4+facVh4Cd4;
		int sumCd5=facVh1Cd5+facVh2Cd5+facVh3Cd5+facVh4Cd5;
		// orden = {sumCd1,sumCd2,sumCd3,sumCd4,sumCd5};
		ArrayList<Orden> Orden= new ArrayList <Orden>();
		Orden.add(new Orden(1, sumCd1));
		Orden.add(new Orden(2, sumCd2));
		Orden.add(new Orden(3, sumCd3));
		Orden.add(new Orden(4, sumCd4));
		Orden.add(new Orden(5, sumCd5));
		Collections.sort(Orden);
		
		//Reporte 2
		System.out.println("La ciudad con menor facturacion es: " + cdArray.get(Collections.min(Orden).ciudad-1).getNombre() + "\n");
		
		int sumTotCds=sumCd1+sumCd2+sumCd3+sumCd4+sumCd5;
		double[] porcentaje= {100*sumCd1/sumTotCds,
							  100*sumCd2/sumTotCds,
							  100*sumCd3/sumTotCds,
							  100*sumCd4/sumTotCds,
							  100*sumCd5/sumTotCds};
		//Reporte 3
		for(int i=0; i<cdArray.size(); i++) {
			System.out.println("La Ciudad: " + cdArray.get(i).getNombre()
								+ " tiene % de " + porcentaje[i] + "facturacion total");
		}
		System.out.println();
		//Reporte 4
		System.out.println("No. Cd \t Nombre Cd \t Total");
		for (Orden aux: Orden) {
			System.out.println("  " + aux.ciudad + "\t" + cdArray.get(aux.ciudad-1).getNombre() + "\t\t"+ + aux.Total);
		}
		
		
		

	}
	
}