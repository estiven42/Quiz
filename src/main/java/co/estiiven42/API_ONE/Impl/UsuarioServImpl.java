package co.estiiven42.API_ONE.Impl;

import co.estiiven42.API_ONE.Entidades.Usuarios;
import co.estiiven42.API_ONE.Repositorios.RepositorioUsuario;
import co.estiiven42.API_ONE.Servicios.ServiciosUsuarios;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioServImpl implements ServiciosUsuarios {
    private final RepositorioUsuario repositorioUsuario;
    @Override
    public Usuarios guardarusUario(Usuarios usuarios) {
        return repositorioUsuario.save(usuarios);
    }

    @Override
    public Usuarios obtenerUsuario(Long idUsuario) {
        return repositorioUsuario.findById(idUsuario).orElseThrow(() ->{throw new RuntimeException();});
    }

    @Override
    public Usuarios usuarioAModificar(Long id, Usuarios usuarioModificar) {
        Usuarios usuarioBuscado = repositorioUsuario.findById(id).get();
        usuarioBuscado.setDireccion(usuarioBuscado.getDireccion());
        usuarioBuscado.setTelefono(usuarioBuscado.getTelefono());
        return repositorioUsuario.save(usuarioBuscado);
    }

    @Override
    public boolean eliminarUsuario(Long id)
    {
        try {
            repositorioUsuario.deleteById(id);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }
}
