package com.stage.catalogue;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

//import com.stage.catalogue.controller.AuteurController;
//import com.stage.catalogue.service.AuteurService;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
/**
 *
 * @author cellule
 */
//@WebMvcTest(controllers = AuteurController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuteurTest {
    
    @Autowired
    private MockMvc mockMvc;
    
  /*  @MockBean
    private AuteurService auteur;*/
    
    @Test
    public void testPutAuteur() throws Exception{
        mockMvc.perform(put("/auteurs/edit?id:1"))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$[0].nomAuteur", is("koire")));
    }
}
