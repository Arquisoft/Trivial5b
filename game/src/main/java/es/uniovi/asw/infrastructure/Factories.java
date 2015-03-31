package es.uniovi.asw.infrastructure;

import es.uniovi.asw.persistence.PersistenceFactory;
import es.uniovi.asw.persistence.impl.SimplePersistenceFactory;

public class Factories {

	public static PersistenceFactory persistence= new SimplePersistenceFactory();
}
