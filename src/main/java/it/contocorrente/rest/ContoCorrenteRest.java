package it.contocorrente.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.contocorrente.entity.ContoCorrente;
import it.contocorrente.entity.Movimento;
import it.contocorrente.entity.Operazione;

@Path("/conto")
public class ContoCorrenteRest {



	private static ArrayList<ContoCorrente> conti = new ArrayList<>();
	private static ArrayList<Movimento> movimenti = new ArrayList<>();

	// http://localhost:8080/Ewallet/rest/conto


	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertConto(ContoCorrente c) {

		conti.add(c);
		return Response.status(200).entity("Crezione del conto avvenuta con successo").build();

	}


	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteConto(ContoCorrente c) {

		for(ContoCorrente con : conti) {

			if(con.getIban().equals(c.getIban())) {

				conti.remove(con);
				return Response.status(200).entity("Rimozione del conto avvenuta con successo").build();

			}

		}
		return Response.status(404).entity("Conto non presente").build();


	}


	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateConto(ContoCorrente c) {

		for(ContoCorrente con : conti) {

			if(con.getIban().equals(c.getIban())) {

				int index = conti.lastIndexOf(con);

				conti.set(index, c);
				return Response.status(200).entity("Modifica avvenuta con successo").build();

			}

		}
		return Response.status(404).entity("Conto non presente").build();


	}


	@PUT
	@Path("/movimento")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response movimento(Movimento m) {

		for(ContoCorrente con : conti) {

			if(m.getIban().equals(m.getIban())) {

				if(m.getTipo().equals(Operazione.PRELIEVO)) {

					if(m.getImporto() > con.getSaldo()) {
						return Response.status(406).entity("L'importo inserito è maggiore del saldo disponibile").build();
					}
					if(m.getImporto() < 0) {
						return Response.status(406).entity("Non è possibile inserire un importo negativo").build();
					}

					double nuovoSaldo = con.getSaldo() - m.getImporto();
					con.setSaldo(nuovoSaldo);
					movimenti.add(m);
					return Response.status(200).entity("Il saldo aggiornato è: " + nuovoSaldo).build();


				}
				else if(m.getTipo().equals(Operazione.VERSAMENTO)) {
					if(m.getImporto() < 0) {
						return Response.status(406).entity("Non è possibile inserire un importo negativo").build();
					}
					double nuovoSaldo = con.getSaldo() + m.getImporto();
					con.setSaldo(nuovoSaldo);
					movimenti.add(m);
					return Response.status(200).entity("Il saldo aggiornato è: " + nuovoSaldo).build();
				}

			}

		}
		return Response.status(404).entity("Qualcosa è andato storto").build();




	}



	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimento> getAllMovimenti() {

		return movimenti;

	}

	@GET
	@Path("/tutticonti")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContoCorrente> getAllConti() {

		return conti;

	}


}
