package CSB.BornToReborn.service;

import CSB.BornToReborn.model.UsersModel;
import CSB.BornToReborn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsersModel registerUser(String fullName,String username, String email, String password, String country, int age, String gender) {
        if(username != null && password != null && fullName != null && country != null && country != null && age > 12 && country != null){
            UsersModel usersModel = new UsersModel();
            usersModel.setFullName(username);
            usersModel.setUsername(username);
            usersModel.setEmail(email);
            usersModel.setPassword(password);
            usersModel.setCountry(country);
            usersModel.setAge(age);
            usersModel.setGender(gender);
            return userRepository.save(usersModel);
        }
        else {
            return null;
        }
    }

    public UsersModel authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
}
