package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final InstrumentoRepository repositoryI;
	private final MusicoRepository repositoryM;
	private final BandaRepository repositoryB;
	private final IntegranteRepository repositoryN;

	@Autowired
	public DatabaseLoader(
		InstrumentoRepository repositoryI,
		MusicoRepository repositoryM,
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

		this.repositoryI.save(new Instrumento("Leche", "4.00", "."));
		this.repositoryI.save(new Instrumento("Arroz","4.50","."));
		this.repositoryI.save(new Instrumento("Melódica","Viento","."));
		Instrumento iVoz = new Instrumento("poets","3",".");
		this.repositoryI.save(iVoz);
		Instrumento iGuitarraElectrica = new Instrumento("azucar","4.00", ".");
		this.repositoryI.save(iGuitarraElectrica);
		this.repositoryI.save(new Instrumento("Batería","Percusión","."));

		this.repositoryM.save(new Musico("10"));
		Musico mFreddy = new Musico("20");
		this.repositoryM.save(mFreddy);
		Musico mBrian = new Musico("15");
		this.repositoryM.save(mBrian);

		Banda bQueen = new Banda("1");
		this.repositoryB.save(bQueen);

		this.repositoryN.save(new Integrante(bQueen, mFreddy, iVoz));
		this.repositoryN.save(new Integrante(bQueen, mBrian, iGuitarraElectrica));


	}
}