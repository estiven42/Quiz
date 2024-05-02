package co.estiiven42.API_ONE.Repositorios;

import co.estiiven42.API_ONE.Entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuarios,Long> {
}
