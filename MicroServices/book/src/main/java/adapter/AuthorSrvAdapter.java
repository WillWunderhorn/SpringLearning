package adapter;

import author.AuthorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorSrvAdapter {

    public List<AuthorDto> getAuthorListByIdList(List<Long> authorIdList) {
        return null;
    }
}
