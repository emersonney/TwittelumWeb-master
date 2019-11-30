package br.com.caelum.twittelumappweb.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.fragment.BuscadorDeTweetsFragment
import br.com.caelum.twittelumappweb.fragment.ListaTweetsFragment
import br.com.caelum.twittelumappweb.fragment.MapaFragment
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.UsuarioViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private	val	tweetViewModel: TweetViewModel by	lazy	{
        ViewModelProviders.of(this,	ViewModelFactory).get(TweetViewModel::class.java)
    }

    private	val	viewModel: UsuarioViewModel by	lazy	{
        ViewModelProviders.of(this,	ViewModelFactory).get(UsuarioViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tweetViewModel.carregaLista()

        bottom_navigation.selectedItemId = R.id.menu_tweets

        listenerBottonNavigation()

        main_fab.setOnClickListener{
            val intent  = Intent(this,TweetActivity::class.java)
            startActivity(intent)
        }

    }

    private fun exibe(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_principal, fragment)
        transaction.commit()

    }

    override	fun	onCreateOptionsMenu(menu:	Menu?):	Boolean	{
        menuInflater.inflate(R.menu.main_menu,	menu)
        return	true
    }
    override	fun	onOptionsItemSelected(item:	MenuItem?):	Boolean	{
        if	(item?.itemId	==	R.id.menu_sair)	{
            viewModel.desloga()
            voltaProLogin()
        }
        return	super.onOptionsItemSelected(item)
    }
    private	fun	voltaProLogin()	{
        finish()
        startActivity(Intent(this,	LoginActivity::class.java))
    }

    private fun listenerBottonNavigation() {


        bottom_navigation.setOnNavigationItemSelectedListener {

            item -> when (item.itemId) {

                R.id.menu_tweets -> {
                    exibe(ListaTweetsFragment())
                    true
                }

                R.id.menu_busca -> {
                    exibe(BuscadorDeTweetsFragment())
                    true
                }

                R.id.menu_mapa	->	{
                    exibe( MapaFragment() )
                    true
                }

                else -> {

                    false

                }

            }

        }

        bottom_navigation.selectedItemId = R.id.menu_tweets


    }



}