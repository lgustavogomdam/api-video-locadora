package io.github.lgustavogomdam.api_video_locadora.service;

import io.github.lgustavogomdam.api_video_locadora.model.dto.ItemModel;
import io.github.lgustavogomdam.api_video_locadora.repository.intf.ItemRepository;
import io.github.lgustavogomdam.api_video_locadora.utils.exception.ElementoJaCadastradoException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ItemService extends AbstractService<ItemModel,Long, ItemRepository> {

//    private Logger logger = Logger.getLogger(ItemService.class.getName());

    @Override
    public void saveValidation(ItemModel model) throws ElementoJaCadastradoException {

    }
}
