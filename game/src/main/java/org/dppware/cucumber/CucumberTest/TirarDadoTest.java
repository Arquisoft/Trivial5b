package org.dppware.cucumber.CucumberTest;

import logica.Juego;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TirarDadoTest {
	
	private int numero;
	private Juego juego;
	
	
	@Given("^Un dado con seis caras$")
	public void un_dado_con_seis_caras() throws Throwable {
		setNumero(0);
	    throw new PendingException();
	}

	@When("^Lanzo el dado$")
	public void lanzo_el_dado() throws Throwable {
		juego = new Juego();
		setNumero(juego.tirarDado());
	    throw new PendingException();
	}

	@Then("^Devuelve un n?mero aleatorio entre (\\d+) y (\\d+)$")
	public void devuelve_un_n_mero_aleatorio_entre_y(int arg1, int arg2) throws Throwable {
		Assert.assertTrue(numero >= arg1 || numero <=arg2);
	    throw new PendingException();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	

}
