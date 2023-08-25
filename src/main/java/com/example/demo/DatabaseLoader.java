package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ProductoRepository repositoryI;
	private final VentaRepository repositoryM;
	private final BandaRepository repositoryB;
	private final IntegranteRepository repositoryN;

	@Autowired
	public DatabaseLoader(
		ProductoRepository repositoryI,
		VentaRepository repositoryM,
		BandaRepository repositoryB,
		IntegranteRepository repositoryN
		) {
		this.repositoryI = repositoryI;
		this.repositoryM = repositoryM;
		this.repositoryB = repositoryB;
		this.repositoryN = repositoryN;
	}

	@Override
	public void run(String... strings) throws Exception {

		this.repositoryI.save(new Producto("Leche", "4.00", "."));
		this.repositoryI.save(new Producto("Arroz","4.50","."));
		Producto iVoz = new Producto("poets","3",".");
		this.repositoryI.save(iVoz);
		Producto iGuitarraElectrica = new Producto("azucar","4.00", ".");
		this.repositoryI.save(iGuitarraElectrica);
		this.repositoryM.save(new Venta("10"));
		Venta mFreddy = new Venta("20");
		this.repositoryM.save(mFreddy);
		Venta mBrian = new Venta("15");
		this.repositoryM.save(mBrian);

		Detalle bQueen = new Detalle("1");
		this.repositoryB.save(bQueen);

		this.repositoryN.save(new Integrante(bQueen, mFreddy, iVoz));
		this.repositoryN.save(new Integrante(bQueen, mBrian, iGuitarraElectrica));


	}
}