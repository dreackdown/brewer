package dev.hugofaria.brewer.service;

import dev.hugofaria.brewer.repository.Usuarios;

public enum StatusUsuario {

    ATIVAR {
        @Override
        public void executar(Long[] codigos, Usuarios usuarios) {
            usuarios.findByCodigoIn(codigos).forEach(u -> u.setAtivo(true));
        }
    },

    DESATIVAR {
        @Override
        public void executar(Long[] codigos, Usuarios usuarios) {
            usuarios.findByCodigoIn(codigos).forEach(u -> u.setAtivo(false));
        }
    };

    public abstract void executar(Long[] codigos, Usuarios usuarios);

}