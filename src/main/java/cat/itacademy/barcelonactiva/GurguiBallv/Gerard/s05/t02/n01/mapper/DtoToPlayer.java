package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.mapper;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.DTO.PlayerDto;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/*
* Convertir de jugadorDto a JugadorEntidad
* implementamos la interfaz Imapper, recibe un jugadorDto (el que introduce el usuario)
* nos devuelve el jugador que guardaremos en BDD
* @component para poder inyectar en las clases donde necesitamos
* */

@Component
public class DtoToPlayer implements IMapper <PlayerDto, Player>{

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Player map(PlayerDto playerDto) {

        Player playerEntity = new Player();

        if (playerDto.getUsername().isEmpty()){
            playerEntity.setUsername("Anónimo");
        } else {
            playerEntity.setUsername(playerDto.getUsername());
        }

        playerEntity.setEmail(playerDto.getEmail());
        playerEntity.setPassword(encoder.encode(playerDto.getPassword()));
        playerEntity.setFechaRegistro(LocalDate.now());
        playerEntity.setPuntuacion(0);
        playerEntity.setVictoria(0);

        return playerEntity;
    }


}
