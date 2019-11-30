package br.com.caelum.twittelumappweb.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.webservices.UsuarioWebClient

class UsuarioRepository(private val client: UsuarioWebClient){

    val usuarioDaSessao : MutableLiveData<Usuario?> = MutableLiveData()
    val estaLogado: MutableLiveData<Boolean> = MutableLiveData()
    val erro: MutableLiveData<Throwable> = MutableLiveData()

    fun	cadastra(usuario:	Usuario)	{
        Log.i("criaConta",	"$usuario")
        client.registra(usuario,sucesso,falha)
    }

    fun	entra(usuario: Usuario)	{
        client.fazLogin(usuario,	sucesso,	falha)
        Log.i("loginConta",	"$usuario")
    }

    fun	desloga(){
        estaLogado.value	=	false
        usuarioDaSessao.value =	null
    }

    private val sucesso = { usuario: Usuario ->

        estaLogado.value = true
        usuarioDaSessao.value = usuario

    }

    private val falha = { excecao: Throwable ->
        estaLogado.value = false
        erro.value = excecao

    }



}