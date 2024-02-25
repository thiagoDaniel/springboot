package com.aprendendo.curso.entitis;

import java.io.Serializable;

import com.aprendendo.curso.entitis.pk.PedidoItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido_item")
public class PedidoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoItemPK id = new PedidoItemPK();

	private Integer quantity;
	private Double price;

	public PedidoItem() {

	}

	public PedidoItem(Pedido pedido, Produto produto, Integer quantity, Double price) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantity = quantity;
		this.price = price;
	}
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}

	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PedidoItem other = (PedidoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
