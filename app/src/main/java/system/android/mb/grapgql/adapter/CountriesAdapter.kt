package system.android.mb.grapgql.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.grapgql_schema.CountriesQuery
import system.android.mb.grapgql.R


class CountriesAdapter(val data: List<CountriesQuery.Country>) :
    RecyclerView.Adapter<CountriesAdapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        fun setData(data: CountriesQuery.Country)
        {

            val title = itemView.findViewById<TextView>(R.id.title)
            val sb = StringBuilder()
            sb.append(data.code).append(">").append(data.name).append(">").append(data.emoji).append(">").append(data.currency)

            title.text = sb
            // "${data.name} > ${data.emoji} > ${data.code} > ${data.currency}"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.custom, parent, false)
        )
    }

    override fun getItemCount(): Int {
      return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.setData(item)
    }


}