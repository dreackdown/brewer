package dev.hugofaria.brewer.repository.helper.cerveja;

import dev.hugofaria.brewer.dto.CervejaDTO;
import dev.hugofaria.brewer.model.Cerveja;
import dev.hugofaria.brewer.repository.filter.CervejaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CervejasQueries {

    public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);

    public List<CervejaDTO> porSkuOuNome(String skuOuNome);

}