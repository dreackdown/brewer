package dev.hugofaria.brewer.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

    String salvarTemporariamente(MultipartFile[] files);

    byte[] recuperarFotoTemporaria(String nome);

    void salvar(String foto);

    byte[] recuperar(String foto);

    byte[] recuperarThumbnail(String fotoCerveja);
}