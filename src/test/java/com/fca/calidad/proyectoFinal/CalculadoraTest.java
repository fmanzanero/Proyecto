package com.fca.calidad.proyectoFinal;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CalculadoraTest {
	
	public Calculadora miCalculadora;

	//paso 1: inicializacion
	@Before
	public void setUp() throws Exception {
		miCalculadora = new Calculadora();
	}
	
	
	//paso 2: ejercicio llamada del codigo que se va a probar
	@Test
	public void sumaTest() {
		
		double resultadoEjecucion = miCalculadora.suma(1,3);
		double resultadoEsperado=4;
		
		//verificar, comparar restultadoEjecucuion
		assertThat(resultadoEjecucion, is(resultadoEsperado)); 
	}

	@Test(expected=ArithmeticException.class)//se espera una excepcion
	public void divisionCeroTest() {
		
		double resultadoEjecucion = miCalculadora.division(10,0);
	}
	

}
