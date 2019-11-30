package br.com.caelum.twittelumappweb.viewmodel

import androidx.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.modelo.Usuario

class TweetViewModel(private val repository: TweetRepository) : ViewModel() {


    fun salva(tweet: Tweet) = repository.salva(tweet)

    fun falha() = repository.excecao

    fun novoTweet() = repository.tweetCriado

    private val dono : Usuario = Usuario("Maria","Maria","123")

    fun tweets(): List<Tweet> = listOf(
            Tweet("bla",null,dono),
            Tweet("ble",null,dono),
            Tweet("bli",null,dono),
            Tweet("blo",null,dono),
            Tweet("blu",null,dono)
    )


}