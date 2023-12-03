package Xadrez;

import Tabuleiro.Peca;
import Tabuleiro.Posicao;
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
	
	public PecaXadrez moverUmaPeca(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.toPosicao();
		Posicao destino = posicaoDestino.toPosicao();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Peca pecaCapturada = moverPeca(origem, destino);
		return (PecaXadrez)pecaCapturada;
	}
	
	private Peca moverPeca(Posicao origem,Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		tabuleiro.colocarPeca(p, destino);
		return pecaCapturada;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.temUmaPeca(posicao)) {
			throw new XadrezException("Não existe uma peça nessa posição.");
		}
		if (!tabuleiro.peca(posicao).existeMovimentoPossivel()) {
			throw new XadrezException("Não existe movimentos possíveis para a peça escolhida.");
		}
	}
	
	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peca(origem).podeMover(destino)) {
			throw new XadrezException("A peça escolhida não pode se mover para a posição de destino");
		}
	}
	
	private void colocandoNovaPeca (char coluna, int linha, PecaXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
	}
	
	private void InicioPartida() {
		colocandoNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocandoNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocandoNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocandoNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocandoNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocandoNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

        colocandoNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
        colocandoNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
        colocandoNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
        colocandoNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
        colocandoNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
        colocandoNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
}
