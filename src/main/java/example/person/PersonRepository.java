package example.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, String> {

    Optional<Person> findByLastName(String lastName);

    Optional<Person> findByFirstName(String firstName);

    Optional<Person> findById(Integer id);

    @Transactional
    void deleteById(Integer id);

}
