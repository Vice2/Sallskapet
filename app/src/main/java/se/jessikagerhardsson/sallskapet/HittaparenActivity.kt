package se.jessikagerhardsson.sallskapet

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class MemoryCard(var cardnumber : Int = 0, val identifier: Int, var isFacedUp: Boolean = false, var isMatched: Boolean = false)

class HittaparenActivity : AppCompatActivity() {

    lateinit var cards: List<MemoryCard>


    var myAdapter = rowAdapter()

    var currentFaceUp : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hittaparen)

        myAdapter.act = this

        val memoryRV = findViewById<RecyclerView>(R.id.myRV)

        memoryRV.layoutManager = GridLayoutManager(this, 5)
        memoryRV.adapter = myAdapter

        //myAdapter.hej.shuffle()

        newGame()
        //gameFinished()




        myAdapter.notifyDataSetChanged()

        findViewById<Button>(R.id.newGameButtonmemory).setOnClickListener {

            newGame()
            myAdapter.notifyDataSetChanged()
        }

    }

    fun newGame()
    {
        val images = mutableListOf<Int>(R.drawable.animallettera, R.drawable.animalletterb, R.drawable.animalletterc,
            R.drawable.animalletterd, R.drawable.animallettere, R.drawable.animalletterf,
            R.drawable.animalletterh, R.drawable.animalletteri, R.drawable.animalletterj, R.drawable.animalletterk,
            R.drawable.animalletterl, R.drawable.animalletterm, R.drawable.animallettern, R.drawable.animallettero,
            R.drawable.animalletterp, R.drawable.animalletterq, R.drawable.animalletterr, R.drawable.animalletters,
            R.drawable.animalletteru, R.drawable.animalletterv, R.drawable.animalletterw,
            R.drawable.animalletterx, R.drawable.animallettery, R.drawable.animalletterz, R.drawable.animalletterdonkey,
            R.drawable.animalletterhej, R.drawable.animalletterlizard, R.drawable.animallettert)

        val images2 = mutableListOf<Int>(R.drawable.animallettera, R.drawable.animalletterb, R.drawable.animalletterc,
            R.drawable.animalletterd, R.drawable.animallettere, R.drawable.animalletterf,
            R.drawable.animalletterh, R.drawable.animalletteri, R.drawable.animalletterj, R.drawable.animalletterk,
            R.drawable.animalletterl, R.drawable.animalletterm, R.drawable.animallettern, R.drawable.animallettero,
            R.drawable.animalletterp, R.drawable.animalletterq, R.drawable.animalletterr, R.drawable.animalletters,
            R.drawable.animalletteru, R.drawable.animalletterv, R.drawable.animalletterw,
            R.drawable.animalletterx, R.drawable.animallettery, R.drawable.animalletterz, R.drawable.animalletterdonkey,
            R.drawable.animalletterhej, R.drawable.animalletterlizard, R.drawable.animallettert)

        val images3 = mutableListOf<Int>(R.drawable.animala, R.drawable.animalb, R.drawable.animalc,
            R.drawable.animald, R.drawable.animale, R.drawable.animalf, R.drawable.animalg, R.drawable.animalh,
            R.drawable.animali, R.drawable.animalj, R.drawable.animalk, R.drawable.animall, R.drawable.animalm,
            R.drawable.animaln, R.drawable.animalo, R.drawable.animalp, R.drawable.animalq, R.drawable.animalr,
            R.drawable.animals, R.drawable.animalt, R.drawable.animalu, R.drawable.animalv, R.drawable.animalw,
            R.drawable.animalx, R.drawable.animaly, R.drawable.animalz, R.drawable.animaldonkey, R.drawable.animalhej,
            R.drawable.animallizard)

        val images4 = mutableListOf<Int>(R.drawable.lettera, R.drawable.letterb, R.drawable.letterc, R.drawable.letterd,
            R.drawable.lettere, R.drawable.letterf, R.drawable.letterg, R.drawable.letterh, R.drawable.letteri,
            R.drawable.letterj, R.drawable.letterk, R.drawable.letterl, R.drawable.letterm, R.drawable.lettern,
            R.drawable.lettero, R.drawable.letterp, R.drawable.letterq, R.drawable.letterr, R.drawable.letters,
            R.drawable.lettert, R.drawable.letteru, R.drawable.letterv, R.drawable.letterw, R.drawable.letterx,
            R.drawable.lettery, R.drawable.letterz, R.drawable.letterdonkey, R.drawable.letterhej, R.drawable.letterlizard)



        val images5 = mutableListOf<Int>(R.drawable.spider0, R.drawable.spider1, R.drawable.spider2, R.drawable.spider3,
            R.drawable.spider4, R.drawable.spider5, R.drawable.spider6, R.drawable.spider7, R.drawable.spider8,
            R.drawable.spider9, R.drawable.spider10)

        val images6 = mutableListOf<Int>(R.drawable.number0, R.drawable.number1, R.drawable.number2, R.drawable.number3,
            R.drawable.number4, R.drawable.number5, R.drawable.number6, R.drawable.number7, R.drawable.number8,
            R.drawable.number9, R.drawable.number10)

        var knapptryck = intent.getIntExtra("knapp", 0)

        if (knapptryck == 1)
        {
            var tempCardList = mutableListOf<MemoryCard>()

            images.forEachIndexed { index, img ->
                var tempCard = MemoryCard(index, images[index])
                tempCardList.add(tempCard)
                var tempCard2 = MemoryCard(index, images2[index])
                tempCardList.add(tempCard2)

            }

            tempCardList.shuffle()
            cards = tempCardList
        }
        if (knapptryck == 2)
        {
            var tempCardList = mutableListOf<MemoryCard>()

            images3.forEachIndexed { index, img ->
                var tempCard = MemoryCard(index, images3[index])
                tempCardList.add(tempCard)
                var tempCard2 = MemoryCard(index, images4[index])
                tempCardList.add(tempCard2)

            }

            tempCardList.shuffle()
            cards = tempCardList
        }
        if (knapptryck == 3)
        {

            var tempCardList = mutableListOf<MemoryCard>()

            images5.forEachIndexed { index, img ->
                var tempCard = MemoryCard(index, images5[index])
                tempCardList.add(tempCard)
                var tempCard2 = MemoryCard(index, images6[index])
                tempCardList.add(tempCard2)

            }

            tempCardList.shuffle()
            cards = tempCardList




        }



    }


    fun clickCard(cardnumber : Int)
    {
        if(currentFaceUp == null)
        {
            restoreCards()
            currentFaceUp = cardnumber
            cards[cardnumber].isFacedUp = true
        } else {
            if(cards[cardnumber].cardnumber == cards[currentFaceUp!!].cardnumber)
            {
                cards[cardnumber].isMatched = true
                cards[currentFaceUp!!].isMatched = true

            } else {
                cards[cardnumber].isFacedUp = true
                //gameFinished()
            }
            currentFaceUp = null
        }
        gameFinished()





        myAdapter.notifyDataSetChanged()


    }

    fun gameFinished() {

        var gameWon = true

        for (card in cards)
        {
            if (card.isMatched == false)
            {
                gameWon = false
            }
        }

        if(gameWon)
        {
            Log.i("HEJ", "Spelet är slut")
            var builder = AlertDialog.Builder(this)
            builder.setTitle("GRATTIS!!!")
            builder.setMessage("Du har hittat alla paren")
            builder.setPositiveButton("Nytt spel", DialogInterface.OnClickListener { dialogInterface, i ->
                newGame()
                myAdapter.notifyDataSetChanged()
            })
            builder.setNegativeButton("Meny", DialogInterface.OnClickListener { dialogInterface, i ->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            })
            var alert = builder.create()
            alert.show()

        }

    }






    private fun restoreCards() {
        for (card in cards) {
            if (!card.isMatched) {
                card.isFacedUp = false
            }
        }

    }


}