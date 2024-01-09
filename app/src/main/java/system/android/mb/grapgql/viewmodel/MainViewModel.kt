package system.android.mb.grapgql.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import system.android.mb.grapgql.MainActivity

class MainViewModel : ViewModel() {

    fun getApiData(act :MainActivity) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        try {
            viewModelScope.launch(Dispatchers.IO +coroutineExceptionHandler) {
                try {
                    Repo().countriesListRepo(act)

                } catch (e: Exception) {
                    e.printStackTrace()
                    Log.e("graphql2321",e.toString())
                }

            }
        } catch (e: Exception) {
            Log.e("graphql232",e.toString())

        }
    }


    fun getApiDataForCountriesCode(act :MainActivity, c_code:String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
        try {
            viewModelScope.launch(Dispatchers.IO +coroutineExceptionHandler) {
                try {
                    Repo().gg22(act, c_code)
                } catch (e: Exception) {
                    e.printStackTrace()
                    Log.e("graphql2321",e.toString())
                }

            }
        } catch (e: Exception) {
            Log.e("graphql232",e.toString())

        }
    }



}