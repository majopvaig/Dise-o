///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package daos;
//
//import Entitys.Usuario;
//import com.mongodb.client.result.InsertOneResult;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author Kaleb
// */
//public class UsuarioDAOTest {
//    
//    public UsuarioDAOTest() {
//    }
//
//    /**
//     * Test of obtenerUsuario method, of class UsuarioDAO.
//     */
//    @Test
//    public void testObtenerUsuario() throws Exception {
//        System.out.println("obtenerUsuario");
//        
//    }
//
//    /**
//     * Test of guardarUsuario method, of class UsuarioDAO.
//     */
//    @Test
//    public void testGuardarUsuario() throws Exception {
//        UsuarioDAO dao = UsuarioDAO.getInstance();
//        
//        Usuario usuario = new Usuario("Brian", "Sandoval", "Rodriguez", "brian@mail.com", "1234", 0);
//        
//        Usuario usuarioGuardado = dao.guardarUsuario(usuario);
//        
//        assertNotNull(usuarioGuardado);
//        
//    }
//    
//}
