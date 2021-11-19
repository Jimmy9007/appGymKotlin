package jimmynunez.com.ui.database

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class DatabaseViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is database Fragment"
    }
    val text: LiveData<String> = _text
}