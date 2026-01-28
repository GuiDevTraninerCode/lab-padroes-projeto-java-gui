package one.digitalinnovation.gof.strategy;

public class Dado {
	
	private Posicao posicaoDado;

	public void setPosicao(Posicao posicaoDado) {
		this.posicaoDado = posicaoDado;
	}
	
	public void exporPosPraCima() {
		posicaoDado.exporPosPraCima();
	}
}
