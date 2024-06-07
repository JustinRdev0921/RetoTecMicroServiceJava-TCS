//package com.example.RTMicroServiceJava;
//
//import com.example.RTMicroServiceJava.controller.CuentaController;
//import com.example.RTMicroServiceJava.entity.Cuenta;
//import com.example.RTMicroServiceJava.service.CuentaService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(controllers = CuentaController.class)
//public class CuentaControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private CuentaService cuentaService;
//
//    @Test
//    void createCuenta() throws Exception {
//        Cuenta cuenta = new Cuenta();
//        cuenta.setId(1L);
//        cuenta.setNumeroCuenta(123456L);
//        cuenta.setTipoCuenta("Ahorros");
//        cuenta.setSaldoInicial(1000.0);
//        cuenta.setEstado("Activa");
//
//        when(cuentaService.saveCuenta(cuenta)).thenReturn(cuenta);
//
//        mockMvc.perform((RequestBuilder) post("/cuentas")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.valueOf("{\"numeroCuenta\": \"123456\", \"tipoCuenta\": \"Ahorros\", \"saldoInicial\": 1000.0, \"estado\": \"Activa\"}")))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.numeroCuenta").value("123456"))
//                .andExpect(jsonPath("$.tipoCuenta").value("Ahorros"))
//                .andExpect(jsonPath("$.saldoInicial").value(1000.0))
//                .andExpect(jsonPath("$.estado").value("Activa"));
//    }
//
//    @Test
//    void updateCuenta() throws Exception {
//        Cuenta cuenta = new Cuenta();
//        cuenta.setId(1L);
//        cuenta.setNumeroCuenta(123456L);
//        cuenta.setTipoCuenta("Ahorros");
//        cuenta.setSaldoInicial(1000.0);
//        cuenta.setEstado("Activa");
//
//        Cuenta updatedCuenta = new Cuenta();
//        updatedCuenta.setId(1L);
//        updatedCuenta.setNumeroCuenta(654321L);
//        updatedCuenta.setTipoCuenta("Corriente");
//        updatedCuenta.setSaldoInicial(2000.0);
//        updatedCuenta.setEstado("Inactiva");
//
//        when(cuentaService.getCuentaById(1L)).thenReturn(Optional.of(cuenta));
//        when(cuentaService.saveCuenta(updatedCuenta)).thenReturn(updatedCuenta);
//
//        mockMvc.perform(put("/cuentas/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"numeroCuenta\": \"654321\", \"tipoCuenta\": \"Corriente\", \"saldoInicial\": 2000.0, \"estado\": \"Inactiva\"}"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Cuenta actualizada con éxito"));
//    }
//}
