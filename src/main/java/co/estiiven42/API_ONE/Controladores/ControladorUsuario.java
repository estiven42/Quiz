package co.estiiven42.API_ONE.Controladores;

import co.estiiven42.API_ONE.Entidades.Usuarios;
import co.estiiven42.API_ONE.Servicios.ServiciosUsuarios;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/Usuarios")
@RequiredArgsConstructor
public class ControladorUsuario
{
    private final ServiciosUsuarios serviciosUsuarios;
    @PostMapping
    public ResponseEntity guardarUsuario(@RequestBody Usuarios usuario)
    {
        return new ResponseEntity(serviciosUsuarios.guardarusUario(usuario), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity obtenerUsuario(@PathVariable("id")Long idUsuario)
    {
        return new ResponseEntity(serviciosUsuarios.obtenerUsuario(idUsuario),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity modificarUsuario(@PathVariable("id")Long idUsuario, @RequestBody Usuarios usuario)
    {
        return new ResponseEntity(serviciosUsuarios.usuarioAModificar(idUsuario,usuario),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable("id") Long idUsuario)
    {
        boolean respuesta= serviciosUsuarios.eliminarUsuario(idUsuario);
        if(respuesta==true)
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
