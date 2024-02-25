package com.aprendendo.curso.entitis.enuns;

public enum PedidoStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int codigo;

	private PedidoStatus(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;

	}

	public static PedidoStatus ValueOf(int codigo) {
		for (PedidoStatus value : PedidoStatus.values()) {
			if(value.getCodigo() == codigo) {
			return value;
		}
	}
	throw new IllegalArgumentException("Inalid OrderStatus code");
	
}

}
