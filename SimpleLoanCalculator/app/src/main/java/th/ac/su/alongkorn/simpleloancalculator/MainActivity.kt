package th.ac.su.alongkorn.simpleloancalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Money = findViewById<EditText>(R.id.edtmoney)
        val Loan = findViewById<EditText>(R.id.edtloan)
        val Year = findViewById<EditText>(R.id.edtyear)
        val Cal = findViewById<Button>(R.id.Btcal)
        val btnSug = findViewById<Button>(R.id.Btsuggest)

        Cal.setOnClickListener(){

            var money:Double = Money.text.toString().toDouble()
            var loan:Double = Loan.text.toString().toDouble()
            var year:Double = Year.text.toString().toDouble()

            var Sum: Double
            var allmoney:Double
            var loanperyear:Double
            var lengthspend:Double


            loanperyear = money*(loan/100)*year;
            lengthspend = year*12;
            allmoney = money+loanperyear;

            Sum = allmoney/lengthspend;

            var intent = Intent(this@MainActivity,LoanActivity::class.java)
            intent.putExtra("Summary",Sum.toString())
            startActivity(intent)

        }

        btnSug.setOnClickListener {
            var intent = Intent(this@MainActivity,SuggestActivity::class.java)
        }
    }


}