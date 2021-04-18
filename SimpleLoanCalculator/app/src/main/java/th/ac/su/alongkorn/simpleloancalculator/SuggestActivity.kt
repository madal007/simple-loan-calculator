package th.ac.su.alongkorn.simpleloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_suggest.*
import th.ac.su.alongkorn.simpleloancalculator.Utils.getJsonDataFromAsset
import th.ac.su.alongkorn.simpleloancalculator.data.Loan
import th.ac.su.alongkorn.simpleloancalculator.data.LoanAdapter

class SuggestActivity : AppCompatActivity() {

    var itemList:ArrayList<Loan> = ArrayList<Loan>()
    lateinit var arrayAdapter:ArrayAdapter<Loan>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggest)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"promotion.json")

        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Loan>>(){}.type

        val loanList : ArrayList<Loan> = gson.fromJson(jsonFileString,listItemType)

        itemList = loanList

        val adapter = LoanAdapter(this@SuggestActivity,itemList)

        listView.adapter = adapter


    }
}