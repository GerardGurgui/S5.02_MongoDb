package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Player;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.mapper.DtoToPlayer;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.LaunchRepository;
import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.repositories.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.parameters.P;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


class PlayerServiceTest {


    //DEPENDENCIAS NECESARIAS QUE INTERVIENEN EN EL TEST
    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private DtoToPlayer mapper;

    @Mock
    private LaunchRepository launchRepository;

    @InjectMocks
    private PlayerService playerService;

    //VARIABLES NECESARIAS
    private Player player;


    //INICIALIZAMOS MOCKITO
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        player = new Player();
        player.setId("6374aba1ffd1866dce7bc6ca");
        player.setUsername("gonzalo");
        player.setEmail("gonzalo@gmail.com");
        player.setPassword("gerard");

    }

    @Test
    void create() {
    }

    @Test
    void getAll() {

        //METODO DE OBTENER TODOS LOS JUGADOR
        when(playerRepository.findAll()).thenReturn(Arrays.asList(player));

        assertNotNull(playerService.getAll());

    }

    @Test
    void getOne() {

//        assertEquals(player,playerService.getOne("6374aba1ffd1866dce7bc6ca"));
    }

    @Test
    void getDadosOnePlayer() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteOnePlayer() {
    }

    @Test
    void deleteTiradasOnePlayer() {
    }

    @Test
    void realizarTirada() {
    }

    @Test
    void comprobarTirada() {
    }

    @Test
    void asignarTirada() {
    }

    @Test
    void porcentajeJugadores() {
    }

    @Test
    void porcentajeMediaTotal() {
    }

    @Test
    void porcentajeJugadorLoser() {
    }

    @Test
    void porcentajeJugadorWinner() {
    }
}