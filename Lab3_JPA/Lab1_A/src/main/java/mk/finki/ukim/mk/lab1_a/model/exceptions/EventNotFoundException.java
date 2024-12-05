package mk.finki.ukim.mk.lab1_a.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EventNotFoundException  extends  RuntimeException{
    public EventNotFoundException(Long id) {
        super(String.format("Location with id: %d not found",id));
    }
}
