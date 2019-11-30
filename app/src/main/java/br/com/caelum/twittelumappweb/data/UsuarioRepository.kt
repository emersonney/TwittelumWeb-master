package br.com.caelum.twittelumappweb.data

import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioRepository{


    fun	cadastra(usuario:	Usuario)	{
        Log.i("criaConta",	"$usuario")
    }

    fun	entra(usuario: Usuario)	{
        Log.i("loginConta",	"$usuario")
    }

}