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



            val animal1 = Animal()
            animal1.imagenumber = R.drawable.dog1
            animal1.animalname = "1"
            animals.add(animal1)
            val animal2 = Animal()
            animal2.imagenumber = R.drawable.dog2
            animal2.animalname = "2"
            animals.add(animal2)
            val animal3 = Animal()
            animal3.imagenumber = R.drawable.dog3
            animal3.animalname = "3"
            animals.add(animal3)
            val animal4 = Animal()
            animal1.imagenumber = R.drawable.spider0
            animal1.animalname = "0"
            animals.add(animal4)
            val animal5 = Animal()
            animal2.imagenumber = R.drawable.dog4
            animal2.animalname = "4"
            animals.add(animal5)

            val animal6 = Animal()
            animal3.imagenumber = R.drawable.dog5
            animal3.animalname = "5"
            animals.add(animal6)
            val animal7 = Animal()
            animal1.imagenumber = R.drawable.dog6
            animal1.animalname = "6"
            animals.add(animal7)
            val animal8 = Animal()
            animal2.imagenumber = R.drawable.dog7
            animal2.animalname = "7"
            animals.add(animal8)
            val animal9 = Animal()
            animal3.imagenumber = R.drawable.dog8
            animal3.animalname = "8"
            animals.add(animal9)
            val animal10 = Animal()
            animal1.imagenumber = R.drawable.dog9
            animal1.animalname = "9"
            animals.add(animal10)
            val animal11 = Animal()
            animal2.imagenumber = R.drawable.dog10
            animal2.animalname = "10"
            animals.add(animal11)
            val animal12 = Animal()
            animal3.imagenumber = R.drawable.dog11
            animal3.animalname = "11"
            animals.add(animal12)
            val animal13 = Animal()
            animal1.imagenumber = R.drawable.dog12
            animal1.animalname = "12"
            animals.add(animal13)
            val animal14 = Animal()
            animal2.imagenumber = R.drawable.dog13
            animal2.animalname = "13"
            animals.add(animal14)
            val animal15 = Animal()
            animal3.imagenumber = R.drawable.dog14
            animal3.animalname = "14"
            animals.add(animal15)
            val animal16 = Animal()
            animal1.imagenumber = R.drawable.dog15
            animal1.animalname = "15"
            animals.add(animal16)
            val animal17 = Animal()
            animal2.imagenumber = R.drawable.dog16
            animal2.animalname = "16"
            animals.add(animal17)
            val animal18 = Animal()
            animal3.imagenumber = R.drawable.dog17
            animal3.animalname = "17"
            animals.add(animal18)
            val animal19 = Animal()
            animal1.imagenumber = R.drawable.dog18
            animal1.animalname = "18"
            animals.add(animal19)
            val animal20 = Animal()
            animal2.imagenumber = R.drawable.dog19
            animal2.animalname = "19"
            animals.add(animal20)
            val animal21 = Animal()
            animal2.imagenumber = R.drawable.dog20
            animal2.animalname = "20"
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
            animalsleft.removeAt(0)
            Toast.makeText(this, "Rätt svar", Toast.LENGTH_LONG).show()

            if (animalsleft.size == 0)
            {
                //Slut på djur
                Log.i("HEJ", "SLUT")
                //gameOver()
            } else {
                newword()
            }
        }

        fun wrongword()
        {
            Log.i("PIXDEBUG", "FEL")

            animalsleft.removeAt(0)
            Toast.makeText(this, "Fel svar", Toast.LENGTH_LONG).show()

            if (animalsleft.size == 0)
            {
                //Slut på djur
                Log.i("HEJ", "SLUT")
                gameOver()
            } else {
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