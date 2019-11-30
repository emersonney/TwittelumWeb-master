package br.com.caelum.twittelumappweb.viewmodel

import androidx.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioViewModel(private val repository: UsuarioRepository):ViewModel() {

    fun cria(usuario: Usuario) = repository.cadastra(usuario)

    fun logar(usuario: Usuario) = repository.entra(usuario)

    fun usuarioEstaLogado() = repository.estaLogado

    fun falha() = repository.erro

    fun usuarioDaSessao() = repository.usuarioDaSessao

    fun	desloga()	=	repository.desloga()

}