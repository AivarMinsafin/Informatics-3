package ru.itis.aivar.repository;

import ru.itis.aivar.models.User;

public interface UserRepository{
    void add(User user);
    void delete();
    void update();
    void findByName();
}
