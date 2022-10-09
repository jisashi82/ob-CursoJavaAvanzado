package io.codemalone.pattern.bridge;

import io.codemalone.pattern.bridge.device.Device;
import io.codemalone.pattern.bridge.device.Radio;
import io.codemalone.pattern.bridge.device.Tv;
import io.codemalone.pattern.bridge.remotes.AdvanceRemote;
import io.codemalone.pattern.bridge.remotes.BasicRemote;

/*
 * Bridge es un patrón de diseño estructural que divide la lógica de negocio o una clase muy grande en jerarquías de clases separadas 
 * que se pueden desarrollar independientemente.
 * 
 * Ejemplos de uso: El patrón Bridge es de especial utilidad a la hora de tratar con aplicaciones multiplataforma, soportar varios tipos de servidores 
 * de bases de datos o trabajar con varios proveedores de API de un cierto tipo (por ejemplo, plataformas en la nube, redes sociales, etc.).
 * 
 * Identificación: El patrón Bridge se puede reconocer por una distinción clara entre alguna entidad controladora y varias plataformas diferentes 
de las que depende.
 */
public class Demo {
	
	public static void main(String[] args) {
		testDevice(new Tv());
		testDevice(new Radio());
	}
	
	public static void testDevice(Device device) {
		System.out.println("----Testing with Basic remote----");
		BasicRemote basicRemote = new BasicRemote(device);
		basicRemote.power();
		device.printStatus();
		
		System.out.println("----Testing with Advance remote----");
		AdvanceRemote advanceRemote = new AdvanceRemote(device);
		advanceRemote.power();
		advanceRemote.mute();		
		device.printStatus();
	}

}
