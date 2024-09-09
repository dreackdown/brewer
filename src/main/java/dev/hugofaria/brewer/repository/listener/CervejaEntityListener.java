package dev.hugofaria.brewer.repository.listener;

import dev.hugofaria.brewer.model.Cerveja;
import dev.hugofaria.brewer.storage.FotoStorage;

import javax.persistence.PostLoad;

public class CervejaEntityListener {

    //@Autowired
    //private FotoStorage fotoStorage;

    @PostLoad
    public void postLoad(final Cerveja cerveja) {
        //SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        cerveja.setUrlFoto(FotoStorage.URL + cerveja.getFotoOuMock());
        cerveja.setUrlThumbnailFoto(FotoStorage.URL + FotoStorage.THUMBNAIL_PREFIX + cerveja.getFotoOuMock());
    }
}