package searchbar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchbar.ResultDTO;
import searchbar.entity.Actors;
import searchbar.entity.Content;
import searchbar.entity.Directors;
import searchbar.enumeration.SearchByEnum;
import searchbar.repository.ActorRepository;
import searchbar.repository.ContentRepository;
import searchbar.repository.DirectorsRepository;

@Service
public class SearchbarService {

    private static final Logger log = LoggerFactory.getLogger(SearchbarService.class);

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private DirectorsRepository directorsRepository;
    @Autowired
    private ContentRepository contentRepository;

    public ResultDTO getMenu(SearchByEnum searchBy, String term) {
        ResultDTO resultDTO = new ResultDTO();

        if (SearchByEnum.TITLE.equals(searchBy)) {

            log.info("Busqueda por titulo");
            Content contentResult = contentRepository.finContent(term);

            if (contentResult != null) {
                log.info("contentResult : " + contentResult.getTitle());
                resultDTO.setResult(contentResult);
                return resultDTO;
            }

        } else if (SearchByEnum.DIRECTOR.equals(searchBy)) {

            log.info("Busqueda por director");
            Directors director = directorsRepository.findDirector(term);

            if (director != null) {
                log.info("director : " + director.getName());
                resultDTO.setResult(director);
                return resultDTO;
            }

        } else if (SearchByEnum.ACTOR.equals(searchBy)) {
            log.info("Busqueda por actor");
            Actors actor = actorRepository.findActor(term);

            if (actor != null) {
                log.info("actor : " + actor.getName());
                resultDTO.setResult(actor);
                return resultDTO;
            }

        } else {
            throw new IllegalArgumentException("Opcion invalida!");
        }

        return resultDTO;
    }

}
