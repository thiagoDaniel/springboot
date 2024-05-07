package com.aprendendo.curso.entitis;

import java.io.Serializable;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.aprendendo.curso.entitis.enuns.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T':mm:ss'Z'", timezone = "GMT")
	private Instant moment;

	private Integer pedidoStatus;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	@OneToMany(mappedBy = "id.pedido")
	private Set<PedidoItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;

	public Pedido() {
	}

	public Pedido(Long id, Instant moment, PedidoStatus pedidoStatus, Usuario cliente) {
		super();
		this.id = id;
		this.moment = moment;
		setPedidoStatus(pedidoStatus);
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.ValueOf(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if (pedidoStatus != null) {
			this.pedidoStatus = pedidoStatus.getCodigo();
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setClient(Usuario cliente) {
		this.cliente = cliente;
	}
	

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<PedidoItem> getItems() {
		return items;
	}
	public Double getTotal() {
		double sum = 0.0;
		for (PedidoItem x : items) {
			sum += x.getSubTotal();
		}
		return sum;
		
	}
		
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
