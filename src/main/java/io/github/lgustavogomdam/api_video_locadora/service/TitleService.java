package io.github.lgustavogomdam.api_video_locadora.service;

import io.github.lgustavogomdam.api_video_locadora.model.dto.TitleModel;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.TitleRepository;
import io.github.lgustavogomdam.api_video_locadora.utils.exception.ElementoJaCadastradoException;
import org.springframework.stereotype.Service;

@Service
public class TitleService extends AbstractService<TitleModel, Long, TitleRepository> {
    @Override
    public void saveValidation(TitleModel model) throws ElementoJaCadastradoException {

    }
}
