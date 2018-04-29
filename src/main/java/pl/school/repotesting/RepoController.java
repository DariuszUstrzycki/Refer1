package pl.school.repotesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepoController<MyRepo> {
	
	@Autowired
	private PersonRepository repo;
	
	public String testRepo() {
		
		repo.findByName("darek"); // PersonRepository has 3 methods
		
		return "done";
	}

}

/*
public interface CrudRepository<T, ID> extends Repository<T, ID> {

<S extends T> S save(S entity);
<S extends T> Iterable<S> saveAll(Iterable<S> entities);
boolean existsById(ID id);
Iterable<T> findAll();
Iterable<T> findAllById(Iterable<ID> ids);
Optional<T> findById(ID id);
long count();
void deleteById(ID id);
void delete(T entity);
void deleteAll(Iterable<? extends T> entities);
void deleteAll(); }
*/