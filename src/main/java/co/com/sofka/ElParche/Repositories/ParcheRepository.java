
package co.com.sofka.ElParche.Repositories;
import co.com.sofka.ElParche.Collections.Parche;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParcheRepository extends ReactiveMongoRepository<Parche, String> {
/*    public Flux<Parche> findAllByCategoria(Categoria categoria);
    public Flux<Parche> findAllByFechaRealizacion(Fecha fecha);*/
}

