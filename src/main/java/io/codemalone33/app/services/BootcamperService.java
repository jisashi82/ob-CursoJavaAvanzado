package io.codemalone33.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.codemalone33.app.models.Bootcamper;

@Service
public class BootcamperService {
	private List<Bootcamper> lista= new ArrayList<>();
	
	public BootcamperService() {
		lista.add(new Bootcamper("Abel"));
		lista.add(new Bootcamper("Mavi"));
		lista.add(new Bootcamper("Ana"));
		lista.add(new Bootcamper("Said"));
	}

	public List<Bootcamper> getAll(){
		return lista;
	}
	
	public void add(Bootcamper b) {
		lista.add(b);
	}
	
	public Bootcamper getBootcamper(String nombre) {
		Bootcamper bootcamper=this.lista.stream().filter(x->x.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
		return bootcamper;
	}
}
