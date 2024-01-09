package system.android.mb.grapgql


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grapgql_schema.CountriesQuery
import system.android.mb.grapgql.adapter.CountriesAdapter
import system.android.mb.grapgql.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    private var btn : Button? = null
    private var getCode : Button? = null
    private var model : MainViewModel? = null
    private var result: TextView? = null
    private var cCode: EditText? = null
    private var recyclerView11: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.call)
        getCode = findViewById(R.id.getcode)
        cCode = findViewById(R.id.c_Code_value)
        result = findViewById(R.id.result)
        recyclerView11 = findViewById(R.id.recyclerView)


        model = MainViewModel()

        btn!!.setOnClickListener {
            model!!.getApiData(this)
        }

        getCode!!.setOnClickListener {
            model!!.getApiDataForCountriesCode(this,cCode!!.text.toString())
        }


    }

    fun result(data : String)
    {
        runOnUiThread {
            result!!.text = data
            Log.e("sss22",data)

        }

    }

    fun resultList(data : List<CountriesQuery.Country>)
    {
        runOnUiThread {
            if(data.isNotEmpty())
            {
                recyclerView11!!.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                //   Collections.reverse(data)
                val adapter = CountriesAdapter(data)
                recyclerView11!!.adapter = adapter

            }

            Log.e("sss22_list",data.toString())
        }

    }

}



