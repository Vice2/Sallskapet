package se.jessikagerhardsson.sallskapet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Simon says
        //Anka
        val game = findViewById<ImageView>(R.id.gameImageView)
        game.setOnClickListener {
            val intent = Intent(this, SimonsaysActivity::class.java)
            startActivity(intent)
            Log.i("HEJ", "simon says")
        }



        //bokstav mot ord
        //Chinchilla
        val match = findViewById<ImageView>(R.id.matchImageView)
        match.setOnClickListener {
            val intent = Intent(this, ChoosehittaparenActivity::class.java)
            startActivity(intent)
        }



        //hur många hundar
        //Ekorre
        val dog = findViewById<ImageView>(R.id.dogsImageView)
        dog.setOnClickListener {
            val intent = Intent(this, DogActivity::class.java)
            startActivity(intent)
            Log.i("HEJ", "hundar")
        }

        //Hänga gubbe
        //Älg
        val hangman = findViewById<ImageView>(R.id.hangmanButton)
        hangman.setOnClickListener {
            val intent = Intent(this, HangmanActivity::class.java)
            startActivity(intent)
        }

    }
}

