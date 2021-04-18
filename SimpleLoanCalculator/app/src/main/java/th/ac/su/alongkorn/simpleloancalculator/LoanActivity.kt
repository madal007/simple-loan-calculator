package th.ac.su.alongkorn.simpleloancalculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan)


        val Summary = findViewById<TextView>(R.id.tvmoney)
        val btnBack = findViewById<Button>(R.id.Btback)


        val summary = intent.getStringExtra("Summary")
        Summary.setText(summary)


//        -------------------------------------------

        btnBack.setOnClickListener{

            var intent = Intent()
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}