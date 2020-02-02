package com.krisitown.newsaggregator.services;

import com.krisitown.newsaggregator.models.User;
import com.krisitown.newsaggregator.repositories.UsersRepository;
import com.krisitown.newsaggregator.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User createUser(User user) {
        user.setToken(generateHash());
        user.setPassword(hashPassword(user.getPassword()));
        usersRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        User oldUser = usersRepository.findById(user.getToken()).get();
        if(user.getEmail() != null && !user.getEmail().isEmpty()){
            oldUser.setEmail(user.getEmail());
        }

        if(user.getName() != null && !user.getName().isEmpty()){
            oldUser.setName(user.getName());
        }

        usersRepository.save(oldUser);
        return oldUser;
    }

    @Override
    public User deleteUser(String token) {
        User user = usersRepository.findById(token).get();
        usersRepository.deleteById(token);
        return user;
    }

    @Override
    public User authenticateUser(String email, String password) throws Exception {
        User user = usersRepository.findFirstByEmail(email);
        if(user == null){
            throw new Exception("Invalid email/password.");
        }
        if(BCrypt.checkpw(password, user.getPassword())){
            return user;
        }
        throw new Exception("Invalid email/password.");
    }

    @Override
    public User getUser(String token) {
        return usersRepository.findById(token).get();
    }

    private String generateHash(){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private String hashPassword(String plainPassword){
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }
}
