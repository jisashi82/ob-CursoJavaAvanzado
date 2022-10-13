package io.codemalone.pattern.mediator;

import java.util.ArrayList;

public class MediadorConcreto extends Mediator{
	
	private ArrayList<Colega> colegas = new ArrayList<>();

	@Override
	void registra(Colega colega) {
		if(!colegas.contains(colega)) {
			colegas.add(colega);
			colega.setMediator(this);
		}
	}

	@Override
	void reenvia(Colega colega) {
		colegas.forEach(actual ->{
			if(!actual.equals(colega)) {
				actual.recibe();
			}
		});		
	}

}
