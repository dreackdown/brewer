package dev.hugofaria.brewer.controller.converter;

import dev.hugofaria.brewer.model.Cidade;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CidadeConverter implements Converter<String, Cidade> {

    @Override
    public Cidade convert(String codigo) {
        if (!StringUtils.isEmpty(codigo)) {
            Cidade cidade = new Cidade();
            cidade.setCodigo(Long.valueOf(codigo));
            return cidade;
        }

        return null;
    }
}