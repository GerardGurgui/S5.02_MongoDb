//package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.models;
//
//import cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.entities.Tirada;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//public class Dado implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private int numero;
//
////    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    private Tirada tirada;
//
//    public Dado() {
//
//    }
//
//    public Dado(int numero){
//        this.numero = numero;
//    }
//
//    public int getNumero() {
//        return numero;
//    }
//
//    public void setNumero(int numero) {
//        this.numero = numero;
//    }
//
////    public Tirada getTirada() {
////        return tirada;
////    }
////
////    public void setTirada(Tirada tirada) {
////        this.tirada = tirada;
////    }
//
//
//
//    public int randomDado() {
//
//        int tirada = (int) ((Math.random() * ((6 - 1) + 1)) + 1);
//        this.setNumero(tirada);
//
//        return tirada;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Dado{" +
//                "numero=" + numero +
//                '}';
//    }
//
//
//}
