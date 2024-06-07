//package com.example.RTMicroServiceJava;
//
//
//import com.example.RTMicroServiceJava.controller.MovimientoController;
//import com.example.RTMicroServiceJava.entity.Movimiento;
//import com.example.RTMicroServiceJava.service.MovimientoService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(MovimientoController.class)
//public class MovimientoControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private MovimientoService movimientoService;
//
//    @Test
//    void createMovimiento() throws Exception {
//        Movimiento movimiento = new Movimiento();
//        movimiento.setId(1L);
//        movimiento.setTipoMovimiento("Deposito");
//        movimiento.setValor(100.0);
//        movimiento.setSaldo(100.0);
//
//        when(movimientoService.saveMovimiento(movimiento)).thenReturn(movimiento);
//
//        mockMvc.perform(post("/movimientos")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"tipoMovimiento\": \"Deposito\", \"valor\": 100.0, \"saldo\": 100.0}"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Movimiento registrado con éxito"));
//    }
//
//    @Test
//    void createMovimientoInsufficientFunds() throws Exception {
//        Movimiento movimiento = new Movimiento();
//        movimiento.setId(1L);
//        movimiento.setTipoMovimiento("Retiro");
//        movimiento.setValor(-200.0);
//        movimiento.setSaldo(-100.0);
//
//        when(movimientoService.saveMovimiento(movimiento)).thenThrow(new Exception("Saldo no disponible"));
//
//        mockMvc.perform(post("/movimientos")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"tipoMovimiento\": \"Retiro\", \"valor\": -200.0, \"saldo\": -100.0}"))
//                .andExpect(status().isBadRequest())
//                .andExpect(content().string("Saldo no disponible"));
//    }
//}
