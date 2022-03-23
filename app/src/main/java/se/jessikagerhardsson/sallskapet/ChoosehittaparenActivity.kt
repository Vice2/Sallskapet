package se.jessikagerhardsson.sallskapet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

class ChoosehittaparenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosehittaparen)




        findViewById<ImageView>(R.id.spiderImageview2).setOnClickListener {
            val intent = Intent(this, HittaparenActivity::class.java)
            intent.putExtra("knapp", 3)
            startActivity(intent)
            Log.i("HEJ", "spindlar")
        }

        findViewById<ImageView>(R.id.bokstavsdjurImageview).setOnClickListener {
            val intent = Intent(this, HittaparenActivity::class.java)
            intent.putExtra("knapp", 2)
            startActivity(intent)
            Log.i("HEJ", "bokstav mot djur")
        }

        findViewById<ImageView>(R.id.hittaparenImageview).setOnClickListener {
            val intent = Intent(this, HittaparenActivity::class.java)
            intent.putExtra("knapp", 1)
            startActivity(intent)
            Log.i("HEJ", "hitta paren")
        }

    }
}