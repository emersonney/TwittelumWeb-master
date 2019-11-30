package br.com.caelum.twittelumappweb.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.viewmodel.UsuarioViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val viewModel :UsuarioViewModel by lazy {
        ViewModelProviders.of(this,ViewModelFactory).get(UsuarioViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_criar.setOnClickListener{
            viewModel.cria( usuarioDaTela() )
        }

        login_entrar.setOnClickListener{
            viewModel.logar( usuarioDaTela() )
        }

        viewModel.usuarioEstaLogado().observe(this, Observer { estaLogado ->
            estaLogado?.let {
                if(estaLogado){
                    vaiParaMain()
                }
            }
        })
    }

    private fun vaiParaMain() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    private fun usuarioDaTela(): Usuario {

        val nome = login_campoNome.text.toString()
        val username = login_campoUsername.text.toString()
        val senha = login_campoSenha.text.toString()

        return Usuario(nome,username,senha)

    }


}