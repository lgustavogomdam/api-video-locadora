package io.github.lgustavogomdam.api_video_locadora.utils.exception;

import java.sql.SQLDataException;

public class ElementoJaCadastradoException extends SQLDataException {

    private static final long serialVersionUID = 1L;

    public ElementoJaCadastradoException(String message) {
        super(message);
    }
}
