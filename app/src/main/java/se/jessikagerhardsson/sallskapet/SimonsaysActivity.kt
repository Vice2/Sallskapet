package se.jessikagerhardsson.sallskapet

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class SimonsaysActivity : AppCompatActivity() {
    var correctSeq = mutableListOf<Int>()
    var playerSeq = mutableListOf<Int>()
    var hej = 0
    var playerTurn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simonsays)


        var infotext = findViewById<TextView>(R.id.infoTextView)

        if (playerTurn)
        {
            infotext.text = "DIN TUR"
        } else {
            infotext.text = "VÄNTA"
        }



        newGame()


        findViewById<Button>(R.id.restartBtn).setOnClickListener {
            newGame()
        }

        val green = findViewById<Button>(R.id.greenBtn)
        val yellow = findViewById<Button>(R.id.yellowBtn)
        val blue = findViewById<Button>(R.id.blueBtn)
        val red = findViewById<Button>(R.id.redBtn)


        green.setOnClickListener {

            //onCorrect("Green",0)
            if(playerTurn)
            {
                playerSeq.add(0)
                checkCorrect()
            }

        }

        yellow.setOnClickListener {

            //onCorrect("Yellow", 1)

            if(playerTurn)
            {
                playerSeq.add(1)
                checkCorrect()
            }
        }

        blue.setOnClickListener {
            //onCorrect("Blue", 2)

            if(playerTurn)
            {
                playerSeq.add(2)
                checkCorrect()
            }
        }

        red.setOnClickListener {
            //onCorrect("Red", 3)

            if(playerTurn)
            {
                playerSeq.add(3)
                checkCorrect()
            }
        }



    }

    fun checkCorrect()
    {
        Log.i("PIAXDEBUG", "*************")
        Log.i("PIAXDEBUG", correctSeq.toString())
        Log.i("PIAXDEBUG", playerSeq.toString())
        var allcorrect = true
        playerSeq.forEachIndexed { index, i ->
            if(playerSeq[index] != correctSeq[index])
            {
                allcorrect = false
            }
        }

        if(allcorrect == true)
        {

            if(playerSeq.size == correctSeq.size)
            {
                hej ++
                findViewById<TextView>(R.id.scoreText).text = hej.toString()
                Log.i("HEJ", "hej = $hej")
                playerSeq.clear()
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()

                var random: Int = (0..3).random()



                correctSeq.add(random)
                doHighlight(0)

            }

        } else {
            // VISA FÖRLORA
            gameOver()
            Toast.makeText(this, "YOU LOSE", Toast.LENGTH_SHORT).show()
            hej = 0
            findViewById<TextView>(R.id.scoreText).text = hej.toString()
        }

    }

    fun doHighlight(animnumber : Int)
    {
        if(animnumber == correctSeq.size)
        {
            // Visa text "din tur"
            // playerturn = true
            playerTurn = true

            findViewById<TextView>(R.id.infoTextView).text = "Din tur"

            return
        } else {
            playerTurn = false
            findViewById<TextView>(R.id.infoTextView).text = "Vänta"
        }



        var animButton : Button? = null

        if(correctSeq[animnumber] == 0)
        {
            animButton = findViewById<Button>(R.id.greenBtn)
        }
        if(correctSeq[animnumber] == 1)
        {
            animButton = findViewById<Button>(R.id.yellowBtn)
        }
        if(correctSeq[animnumber] == 2)
        {
            animButton = findViewById<Button>(R.id.blueBtn)
        }
        if(correctSeq[animnumber] == 3)
        {
            animButton = findViewById<Button>(R.id.redBtn)
        }


        animButton!!.animate().apply {
            alpha(0f)
            duration = 500
        }.withEndAction {
            animButton!!.animate().apply {
                alpha(1f)
                duration = 500
            }.withEndAction {
                doHighlight(animnumber +1)
            }.start()

        }.start()








    }

    fun gameOver()
    {
        Log.i("HEJ", "Spelet är slut")
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Du förlorade")
        builder.setMessage("Du tryckte på fel färg \nDin poäng blev: ${hej.toString()}")
        builder.setPositiveButton("Nytt spel", DialogInterface.OnClickListener { dialogInterface, i ->
            newGame()

        })
        builder.setNegativeButton("Meny", DialogInterface.OnClickListener { dialogInterface, i ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        var alert = builder.create()
        alert.show()
    }







    fun newGame() {
        hej = 0

        playerSeq.clear()
        correctSeq.clear()

        //Fetch buttons and textviews

        val scoreText = findViewById<TextView>(R.id.scoreText)







        scoreText.text = hej.toString()





        correctSeq.add((0..3).random())

        doHighlight(0)

        //infotext.text = "DIN TUR"


    }
}







