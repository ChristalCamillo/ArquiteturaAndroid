package br.com.zup.movieflix

import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.repositorio.RegisterRepository
import junit.framework.Assert.assertEquals
import org.junit.Test


class RegisterUserTest {

    @Test
    fun registerUser(){
        val registerRepository = RegisterRepository()
        val user = RegisterModel(
            "Felipe",
            "felipe.dearaujo@zup.com.br",
            "melhorProfessorDoMundo"
        )

        val resultado = registerRepository.registerUser(user)

        assertEquals(resultado.userName, "Felipe")
        assertEquals(resultado.email, "felipe.dearaujo@zup.com.br")
        assertEquals(resultado.password, "melhorProfessorDoMundo")
    }
}