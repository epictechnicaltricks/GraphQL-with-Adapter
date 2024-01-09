package system.android.mb.grapgql.viewmodel


import com.apollographql.apollo3.ApolloClient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.grapgql_schema.CountriesQuery
import com.grapgql_schema.CountryQuery
import system.android.mb.grapgql.MainActivity

class Repo {

    private val apolloClient: ApolloClient =
        ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()

    suspend fun countriesListRepo(act : MainActivity)
    {

        try {
            val response = apolloClient.query(CountriesQuery()).execute().data?.countries
            val listType = object : TypeToken<List<CountriesQuery.Country>>() {}.type
            val g = Gson()
            val data: List<CountriesQuery.Country> = g.fromJson(Gson().toJson(response), listType)
            act.resultList(data)


        }catch (e : Exception) {
            act.result("no_internet!")
            e.printStackTrace()
        }




    }


    suspend fun gg22(act : MainActivity, c_code:String)
    {
        try {
        val response = apolloClient.query(CountryQuery(c_code)).execute().data?.country
            val listType = object : TypeToken<CountryQuery.Country>() {}.type
            val g = Gson()
            val data: CountryQuery.Country = g.fromJson(Gson().toJson(response), listType)
            act.result(Gson().toJson(data))
        }catch (e : Exception) {
            act.result("no_internet!")
        }



    }



}