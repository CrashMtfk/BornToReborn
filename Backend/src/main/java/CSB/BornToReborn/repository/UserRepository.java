package CSB.BornToReborn.repository;

import CSB.BornToReborn.model.UsersModel;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface UserRepository extends JpaRepositoryImplementation<UsersModel, Integer> {

    Optional<UsersModel> findByUsernameAndPassword(String username, String password);

}