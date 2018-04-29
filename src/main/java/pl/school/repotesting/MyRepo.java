package pl.school.repotesting;

import java.io.Serializable;

import org.springframework.data.repository.Repository;

//public interface MyRepo extends CrudRepository<Person, Long> {
// daje dostęp do generic methods

//public interface MyRepo extends Repository<Person, Long> {
	
	// Domain repositories extending this interface can selectively 
	//expose CRUD methods by simply declaring methods of the same signature 
	//as those declared in CrudRepository.


/*
Fine-tuning repository definition

Typically, your repository interface will extend Repository, CrudRepository 
or PagingAndSortingRepository. Alternatively, if you do not want to extend 
Spring Data interfaces, you can also annotate your repository interface 
with @RepositoryDefinition. Extending CrudRepository exposes a complete 

set of methods to manipulate your entities. If you prefer to be selective 
about the methods being exposed, simply copy paste the ones you want to expose 
from CrudRepository into your domain repository.
	*/

interface MyBaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
	  T findOne(ID id);
	  T save(T entity);
	}
	
interface PersonRepository extends MyBaseRepository<Person, Long> {

	Person findByName(String name);
}

/*
In this first step you defined a common base interface for all your domain repositories 
and exposed findOne(…) as well as save(…).These methods will be routed into the base 
repository implementation of the store of your choice provided by Spring Data because 
they are matching the method signatures in CrudRepository. So the PersonRepository will 
now be able to save persons, and find single ones by id, as well as triggering a query 
to find Persons by their name.
*/

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


PagingAndSortingRepository dorzuca do metod CRUD jeszcze te dwie:

Iterable<T> findAll(Sort sort);
Page<T> findAll(Pageable pageable)





*/
