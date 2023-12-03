package Xadrez.pecas;

import Tabuleiro.Tabuleiro;
import Xadrez.Cor;
import Xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possivelMovimento() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		return mat;
	}

}
