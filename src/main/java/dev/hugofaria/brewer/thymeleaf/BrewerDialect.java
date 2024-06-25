package dev.hugofaria.brewer.thymeleaf;

import dev.hugofaria.brewer.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import dev.hugofaria.brewer.thymeleaf.processor.MessageElementTagProcessor;
import dev.hugofaria.brewer.thymeleaf.processor.OrderElementTagProcessor;
import dev.hugofaria.brewer.thymeleaf.processor.PaginationElementTagProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

public class BrewerDialect extends AbstractProcessorDialect {

    public BrewerDialect() {
        super("AlgaWorks Brewer", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processadores = new HashSet<>();
        processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
        processadores.add(new MessageElementTagProcessor(dialectPrefix));
        processadores.add(new OrderElementTagProcessor(dialectPrefix));
        processadores.add(new PaginationElementTagProcessor(dialectPrefix));
        return processadores;
    }
}