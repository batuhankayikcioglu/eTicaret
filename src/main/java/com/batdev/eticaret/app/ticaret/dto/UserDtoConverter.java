package com.batdev.eticaret.app.ticaret.dto;

import com.batdev.eticaret.app.ticaret.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public UserDto convert(User from){
        return new UserDto(from.getMail(), from.getFirstName(), from.getLastName(), from.getMiddleName());

    }
}
