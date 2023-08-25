package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Integrante {
    
    private @Id @GeneratedValue Long id;

    @ManyToOne()
    @JoinColumn(name = "id_banda")
    private Detalle banda;

    @ManyToOne()
    @JoinColumn(name = "id_musico")
    private Venta musico;

    @ManyToOne()
    @JoinColumn(name = "id_instrumento")
    private Producto instrumento;

    public Integrante() {}

    public Integrante(Detalle banda, Venta musico, Producto instrumento) {
        this.banda = banda;
        this.musico = musico;
        this.instrumento = instrumento;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Detalle getBanda() {
		return banda;
	}

	public void setBanda(Detalle banda) {
		this.banda = banda;
	}

	public Venta getMusico() {
		return musico;
	}

	public void setMusico(Venta musico) {
		this.musico = musico;
	}

	public Producto getInstrumento() {
		return instrumento;
	}

	public void setInstrumento(Producto instrumento) {
		this.instrumento = instrumento;
	}

    

}
