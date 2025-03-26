package vcmsa.ci.gencheck

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var yearInput : TextView? =  null
    private var genText : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        yearInput = findViewById(R.id.yearInput)
        genText = findViewById(R.id.genTxt)

        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val clrBtn = findViewById<Button>(R.id.clrBtn)
        val extBtn = findViewById<Button>(R.id.extBtn)

        btnCheck.setOnClickListener {
            checkGeneration()
        }
       clrBtn.setOnClickListener{
        yearInput?.text?.clear()
          genText?.text=""}

        extBtn.setOnClickListener{
            moveTaskToBack(true)
          android.os.Process.killProcess( android.os.Process.myPid())
            exitProcess(1)
        }

    }

    private fun checkGeneration(){

        when (yearInput?.text.toString().trim().toInt()){
            in 1901 .. 1927 -> genText?.text = "The Greatest Generation"
            in 1928 .. 1945 -> genText?.text = "The Silent Generation"
            in 1946 .. 1964 -> genText?.text = "The Baby Boomer Generation"
            in 1965 .. 1980 -> genText?.text = "Generation X"
            in 1981 .. 1996 -> genText?.text = "Millennials "
            in 1997 .. 2012 -> genText?.text = "Generation Z"
            in 2013 .. 2025 -> genText?.text = "Generation Alpha"

            else ->{
                genText?.text = "Alien! (your birth year is not valid)"
            }
        }
    }
}

private fun Any?.clear() {
    TODO("Not yet implemented")
}

