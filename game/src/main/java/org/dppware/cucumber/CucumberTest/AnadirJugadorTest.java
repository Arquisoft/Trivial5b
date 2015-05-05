package org.dppware.cucumber.CucumberTest;

import logica.Jugada;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AnadirJugadorTest {

	private Jugada jugada;

	@Given("^Una lista de jugadores$")
	public void una_lista_de_jugadores() throws Throwable {
		jugada = new Jugada();
		throw new PendingException();
	}

	@When("^Anado uno o mas$")
	public void a_ado_uno_o_m_s() throws Throwable {
//		Jugador j = new Jugador("pepe", new PanelQuesitos(0));
//		Jugador k = new Jugador("pepe", new PanelQuesitos(1));
//		Jugador l = new Jugador("pepe", new PanelQuesitos(2));
//		jugada.addJugador(j);
//		jugada.addJugador(k);
//		jugada.addJugador(l);
//		throw new PendingException();
	}

	@Then("^El tamano de la lista se corresponde con el n?mero de jugadores$")
	public void el_tama_o_de_la_lista_se_corresponde_con_el_n_mero_de_jugadores()
			throws Throwable {
		Assert.assertTrue(jugada.getJugadores().size() == 3);
		throw new PendingException();
	}

}
