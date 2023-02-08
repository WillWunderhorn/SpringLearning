package controller.internal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.horn.book.BookDto;

import java.util.List;

@RestController
public class InternalBookController {

    @GetMapping
    public List<BookDto> getBookList() {
        return null;
    }
}
