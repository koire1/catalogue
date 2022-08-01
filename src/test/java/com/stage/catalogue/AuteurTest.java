package com.stage.catalogue;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.stage.catalogue.controller.AuteurController;
import com.stage.catalogue.service.AuteurService;

/**
 *
 * @author cellule
 */
@WebMvcTest(controllers = AuteurController.class)
public class AuteurTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AuteurService auteur;
    
    @Test
    public void testGetAuteur() throws Exception{
        mockMvc.perform(get("/auteurs/all"))
                .andExpect(status().isOk());
    }
}
