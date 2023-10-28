package com.joseleonardo.emissaodepedidos.domain.entities.enums;

public enum StatusPedido {

	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);

	private int codigo;

	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public static StatusPedido valueOf(int codigo) {
		for (StatusPedido statusPedido : StatusPedido.values()) {
			if (statusPedido.getCodigo() == codigo) {
				return statusPedido;
			}
		}

		throw new IllegalArgumentException("Código do StatusPedido inválido");
	}

}
