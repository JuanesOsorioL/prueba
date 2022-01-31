package co.com.sofka.ElParche.Repositories;

import co.com.sofka.ElParche.Collections.Parche;
import co.com.sofka.ElParche.Collections.Usuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, String> {
}
