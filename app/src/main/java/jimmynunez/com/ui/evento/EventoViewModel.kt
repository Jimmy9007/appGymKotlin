package jimmynunez.com.ui.evento

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class EventoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is evento Fragment"
    }
    val text: LiveData<String> = _text
}