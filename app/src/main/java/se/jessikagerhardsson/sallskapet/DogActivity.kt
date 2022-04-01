package se.jessikagerhardsson.sallskapet

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Animal {
    var imagenumber = 0
    var animalname = ""
}

class DogActivity : AppCompatActivity() {


    var animals = mutableListOf<Animal>()
    var animalsleft = mutableListOf<Animal>()
    var correctPosition = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)

        Log.i("HEJ", animalsleft.size.toString())
        Log.i("HEJ", "animals = ${animals.size.toString()}")



        var animal1 = Animal()
        animal1.imagenumber = R.drawable.dog1
        animal1.animalname = "1"
        animals.add(animal1)

        var animal2 = Animal()
        animal2.imagenumber = R.drawable.dog2
        animal2.animalname = "2"
        animals.add(animal2)
        var animal3 = Animal()
        animal3.imagenumber = R.drawable.dog3
        animal3.animalname = "3"
        animals.add(animal3)
        var animal4 = Animal()
        animal4.imagenumber = R.drawable.spider0
        animal4.animalname = "0"
        animals.add(animal4)
        var animal5 = Animal()
        animal5.imagenumber = R.drawable.dog4
        animal5.animalname = "4"
        animals.add(animal5)

        var animal6 = Animal()
        animal6.imagenumber = R.drawable.dog5
        animal6.animalname = "5"
        animals.add(animal6)
        var animal7 = Animal()
        animal7.imagenumber = R.drawable.dog6
        animal7.animalname = "6"
        animals.add(animal7)
        var animal8 = Animal()
        animal8.imagenumber = R.drawable.dog7
        animal8.animalname = "7"
        animals.add(animal8)
        var animal9 = Animal()
        animal9.imagenumber = R.drawable.dog8
        animal9.animalname = "8"
        animals.add(animal9)
        var animal10 = Animal()
        animal10.imagenumber = R.drawable.dog9
        animal10.animalname = "9"
        animals.add(animal10)
        var animal11 = Animal()
        animal11.imagenumber = R.drawable.dog10
        animal11.animalname = "10"
        animals.add(animal11)
        var animal12 = Animal()
        animal12.imagenumber = R.drawable.dog11
        animal12.animalname = "11"
        animals.add(animal12)
        var animal13 = Animal()
        animal13.imagenumber = R.drawable.dog12
        animal13.animalname = "12"
        animals.add(animal13)
        var animal14 = Animal()
        animal14.imagenumber = R.drawable.dog13
        animal14.animalname = "13"
        animals.add(animal14)
        var animal15 = Animal()
        animal15.imagenumber = R.drawable.dog14
        animal15.animalname = "14"
        animals.add(animal15)
        var animal16 = Animal()
        animal16.imagenumber = R.drawable.dog15
        animal16.animalname = "15"
        animals.add(animal16)
        var animal17 = Animal()
        animal17.imagenumber = R.drawable.dog16
        animal17.animalname = "16"
        animals.add(animal17)
        var animal18 = Animal()
        animal18.imagenumber = R.drawable.dog17
        animal18.animalname = "17"
        animals.add(animal18)
        var animal19 = Animal()
        animal19.imagenumber = R.drawable.dog18
        animal19.animalname = "18"
        animals.add(animal19)
        var animal20 = Animal()
        animal20.imagenumber = R.drawable.dog19
        animal20.animalname = "19"
        animals.add(animal20)
        var animal21 = Animal()
        animal21.imagenumber = R.drawable.dog20
        animal21.animalname = "20"
        animals.add(animal21)





        animals.shuffle()

        animalsleft = animals.toList().toMutableList()

        //var correctanswer = mutableListOf<Int>()
        //correctanswer.add((0..2).random())

        var bild1 = findViewById<ImageView>(R.id.bild)
        var ord1 = findViewById<TextView>(R.id.ord1)
        var ord2 = findViewById<TextView>(R.id.ord2)
        var ord3 = findViewById<TextView>(R.id.ord3)

        newword()

        ord1.setOnClickListener {
            if(correctPosition == 0)
            {
                // HURRA RÄTT
                correctword()
                score ++
            } else {
                // BU FEL
                wrongword()
                score --

            }
        }
        ord2.setOnClickListener {
            if(correctPosition == 1)
            {
                // HURRA RÄTT
                correctword()
                score ++
            } else {
                // BU FEL
                wrongword()
                score --

            }
        }
        ord3.setOnClickListener {
            if(correctPosition == 2)
            {
                // HURRA RÄTT
                correctword()
                score ++
            } else {
                // BU FEL
                wrongword()
                score --

            }
        }

        findViewById<Button>(R.id.newGameButton).setOnClickListener {
            newGame()
        }


    }

    fun correctword()
    {
        Log.i("PIXDEBUG", "RÄTT")

        //animalsleft.removeAt(0)
        Toast.makeText(this, "Rätt svar", Toast.LENGTH_SHORT).show()

        if (animalsleft.size == 0)
        {
            //Slut på djur
            Log.i("HEJ", "SLUT")
            //gameOver()
        } else {
            animalsleft.removeAt(0)
            newword()
        }
    }

    fun wrongword()
    {
        Log.i("PIXDEBUG", "FEL")

        animalsleft.removeAt(0)
        Toast.makeText(this, "Fel svar", Toast.LENGTH_SHORT).show()

        if (animalsleft.size == 0)
        {
            //Slut på djur
            Log.i("HEJ", "SLUT")
            gameOver()
        } else {
            //animalsleft.removeAt(0)
            newword()
        }


    }

    fun newword()
    {

        Log.i("HEJ", "newword: ${animalsleft.size.toString()}")
        Log.i("HEJ", "newword: animals = ${animals.size.toString()}")

        var bild1 = findViewById<ImageView>(R.id.bild)
        var ord1 = findViewById<TextView>(R.id.ord1)
        var ord2 = findViewById<TextView>(R.id.ord2)
        var ord3 = findViewById<TextView>(R.id.ord3)




        correctPosition = (0..2).random()

        var wrongAnimal1 = animals.filterNot { it.animalname == animalsleft[0].animalname } [0]
        var wrongAnimal2 = animals.filterNot { it.animalname == animalsleft[0].animalname }.filterNot {
            it.animalname == wrongAnimal1.animalname } [0]

        if(correctPosition == 0)
        {
            ord1.text = animalsleft[0].animalname
            ord2.text = wrongAnimal1.animalname
            ord3.text = wrongAnimal2.animalname
        }
        if(correctPosition == 1)
        {
            ord1.text = wrongAnimal1.animalname
            ord2.text = animalsleft[0].animalname
            ord3.text = wrongAnimal2.animalname
        }
        if(correctPosition == 2)
        {
            ord1.text = wrongAnimal1.animalname
            ord2.text = wrongAnimal2.animalname
            ord3.text = animalsleft[0].animalname
        }

        bild1.setImageResource(animalsleft[0].imagenumber)
    }

    fun gameOver()
    {
        if(animalsleft.size == 0)
        {
            //Pop up ruta som säger att spelet är slut, visar poängen, användaren
            // får välja nytt spel elelr startsidan

            var builder = AlertDialog.Builder(this)
            builder.setTitle("Spelet är slut")
            builder.setMessage("Dina poäng är: ${score.toString()}")
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
    }

    fun newGame()
    {
        animals.shuffle()

        animalsleft = animals.toList().toMutableList()

        newword()
    }



}