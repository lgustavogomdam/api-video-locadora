package io.github.lgustavogomdam.api_video_locadora.utils.exception;

import java.sql.SQLException;

public class ElementoNaoEncontradoException extends SQLException {
    private static final long serialVersionUID = 1L;

    public ElementoNaoEncontradoException(String message) {
        super(message);
    }
}
