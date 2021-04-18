package th.ac.su.alongkorn.simpleloancalculator.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item_loan.view.*
import th.ac.su.alongkorn.simpleloancalculator.R
import java.util.zip.Inflater
import javax.sql.CommonDataSource

class LoanAdapter(private val context: Context,private val dataSource:ArrayList<Loan>) : BaseAdapter(){

    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_loan,null)

        rowView.tvTitle.text = dataSource[position].promo_name
        rowView.tvSubtitle.text = dataSource[position].promo_code.toString()
        rowView.tvDetail.text = dataSource[position].promo_description

        val res = context.resources
        val drawableId:Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)

        rowView.imgThumbnail.setImageResource(drawableId)

        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

}