package Xadrez;

import Tabuleiro.Tabuleiro;
import Xadrez.pecas.Rei;
import Xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez () {
		tabuleiro = new Tabuleiro(8, 8);
		InicioPartida();
	}
	
	public PecaXadrez[][] getPecas() {
		
		PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for (int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	private void colocandoNovaPeca (char coluna, int linha, PecaXadrez peca) {
		tabuleiro.posicaoPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void InicioPartida() {
		colocandoNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
		colocandoNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		colocandoNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
	}
}
