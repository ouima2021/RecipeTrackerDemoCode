package org.example.Models.data;




import org.example.Models.Search;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface SearchRepository extends CrudRepository<Search, Integer> {

}
