package one.digitalinnovation.gof;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.singleton.SingletonLazy;
import one.digitalinnovation.gof.singleton.SingletonLazyHolder;
import one.digitalinnovation.gof.strategy.Posicao;
import one.digitalinnovation.gof.strategy.PosicaoFive;
import one.digitalinnovation.gof.strategy.PosicaoFour;
import one.digitalinnovation.gof.strategy.PosicaoOne;
import one.digitalinnovation.gof.strategy.PosicaoSix;
import one.digitalinnovation.gof.strategy.PosicaoThree;
import one.digitalinnovation.gof.strategy.PosicaoTwo;
import one.digitalinnovation.gof.strategy.Dado;

public class Test {

	public static void main(String[] args) {
		
		// Singleton
		
		SingletonLazy lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		lazy = SingletonLazy.getInstancia();
		System.out.println(lazy);
		
		SingletonEager eager = SingletonEager.getInstancia();
		System.out.println(eager);
		eager = SingletonEager.getInstancia();
		System.out.println(eager);
		
		SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		lazyHolder = SingletonLazyHolder.getInstancia();
		System.out.println(lazyHolder);
		
		// Strategy
		List<Posicao> list = new ArrayList<>();
		Random random = new Random();
		Posicao um = new PosicaoOne();
		list.add(um);
		Posicao dois = new PosicaoTwo();
		list.add(dois);
		Posicao tres = new PosicaoThree();
		list.add(tres);
		Posicao quatro = new PosicaoFour();
		list.add(quatro);
		Posicao cinco = new PosicaoFive();
		list.add(cinco);
		Posicao seis = new PosicaoSix();
		list.add(seis);
		
		
		
		Dado dado = new Dado();

		for(int i = 0;i<10;i++){
			int numeroAleatorio = random.nextInt(list.size());
			dado.setPosicao(list.get(numeroAleatorio));
			dado.exporPosPraCima();
		}
		
		// Facade
		
		Facade facade = new Facade();
		facade.migrarCliente("Venilton", "14801788");
	}

}
