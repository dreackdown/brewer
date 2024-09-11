package dev.hugofaria.brewer.repository.listener;

import dev.hugofaria.brewer.BrewerApplication;
import dev.hugofaria.brewer.model.Cerveja;
import dev.hugofaria.brewer.storage.FotoStorage;

import javax.persistence.PostLoad;

public class CervejaEntityListener {

    @PostLoad
    public void postLoad(final Cerveja cerveja) {
        FotoStorage fotoStorage = BrewerApplication.getBean(FotoStorage.class);

        cerveja.setUrlFoto(fotoStorage.getUrl(cerveja.getFotoOuMock()));
        cerveja.setUrlThumbnailFoto(fotoStorage.getUrl(FotoStorage.THUMBNAIL_PREFIX + cerveja.getFotoOuMock()));
    }
}