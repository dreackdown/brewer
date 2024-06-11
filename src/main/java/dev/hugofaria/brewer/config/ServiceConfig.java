package dev.hugofaria.brewer.config;

import dev.hugofaria.brewer.service.CadastroCervejaService;
import dev.hugofaria.brewer.storage.FotoStorage;
import dev.hugofaria.brewer.storage.local.FotoStorageLocal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {

    @Bean
    public FotoStorage fotoStorage() {
        return new FotoStorageLocal();
    }

}