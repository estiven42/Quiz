package co.estiiven42.API_ONE.Servicios;

import co.estiiven42.API_ONE.Entidades.Usuarios;

public interface ServiciosUsuarios
{
    Usuarios guardarusUario(Usuarios usuarios);

    Usuarios obtenerUsuario(Long idUsuaio);

    Usuarios usuarioAModificar(Long id, Usuarios usuarioModificar);
    boolean eliminarUsuario(Long id);
}
