package com.oss.beellage.user.collection;

import com.oss.beellage.user.domain.User;
import java.util.List;
import lombok.Data;

@Data
public class UserCollection {
    private List<User> users;
}
