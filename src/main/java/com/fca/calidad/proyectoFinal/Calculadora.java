package com.fca.calidad.proyectoFinal;

public class Calculadora{
	private double ultimoResultado;
	
	double suma(double primerSumando, double segundoSumando) {
		return ultimoResultado=primerSumando+segundoSumando;
	}
	
	private double resta(double minuendo, double sustraendo) {
		return ultimoResultado=minuendo-sustraendo;
	}
	
	private double multiplicacion(double primerFactor, double segundoFactor) {
		return ultimoResultado=primerFactor*segundoFactor;
	}
	
	double division(double dividendo, double divisor)throws ArithmeticException  {
		if(divisor==0) {
			throw new ArithmeticException();
		}else
		return ultimoResultado=dividendo/divisor;
	}
	
	private double getUltimoResultado() {
		return ultimoResultado;
	}
	
}