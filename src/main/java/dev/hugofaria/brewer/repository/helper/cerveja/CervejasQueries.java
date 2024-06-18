package dev.hugofaria.brewer.repository.helper.cerveja;

import dev.hugofaria.brewer.model.Cerveja;
import dev.hugofaria.brewer.repository.filter.CervejaFilter;

import java.util.List;

public interface CervejasQueries {

	public List<Cerveja> filtrar(CervejaFilter filtro);
	
}