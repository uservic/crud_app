package com.andersen.javatrainee.service;

import com.andersen.javatrainee.model.User;
import com.andersen.javatrainee.repository.UserRepository;
import com.andersen.javatrainee.util.ValidationUtil;
import com.andersen.javatrainee.util.exception.DuplicateFoundException;
import com.andersen.javatrainee.web.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository repository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    public User save(User user) throws DuplicateFoundException {
        ValidationUtil.checkDuplicateLoginId(
                repository.getByLogin(user.getLogin()), user.getLogin(), user.getId());
        String encryptedPassword = encoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return repository.save(user);
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User getByLogin(String login) {
        return repository.getByLogin(login);
    }

    @Override
    public AuthorizedUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Login " + username + " is not found");
        }
        return new AuthorizedUser(user);
    }
}