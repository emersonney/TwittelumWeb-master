package br.com.caelum.twittelumappweb.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.lista_tweets_fragment.*


class BuscadorDeTweetsFragment : Fragment() {


    private val viewModel: TweetViewModel by lazy {

        ViewModelProviders.of(activity!!,ViewModelFactory).get(TweetViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.lista_tweets_fragment,container,false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {

        inflater?.inflate(R.menu.buscador_menu, menu)

        val botaoBusca = menu?.findItem(R.id.barra_busca)

        val search = botaoBusca?.actionView as SearchView

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(texto: String?): Boolean {

                return false

            }

            override fun onQueryTextChange(texto: String?): Boolean {

                if (!texto.isNullOrEmpty()) {

                    val filtrados = filtraTweetsPelo(texto)

                    lista_tweets.adapter = TweetAdapter(filtrados)

                }

                return false

            }


        })




    }

    private fun filtraTweetsPelo(texto:String?):List<Tweet>{

        val tweets = viewModel.tweets()
        val tweetsFiltrados = tweets.filter{

        tweet -> tweet.mensagem.contains(texto!!,true)


        }

        return tweetsFiltrados

    }


}