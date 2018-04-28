package pl.school.repository;

import org.springframework.data.repository.CrudRepository;

import pl.school.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}