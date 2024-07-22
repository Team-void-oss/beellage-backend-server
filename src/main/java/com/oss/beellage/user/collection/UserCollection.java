package com.oss.beellage.user.collection;

import com.oss.beellage.user.User;
import lombok.Data;

import java.util.List;

@Data
public class UserCollection {
    private List<User> users;
}
