package jimmynunez.com.ui.evento

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.widget.Button
import android.widget.Toast
import jimmynunez.com.R

class EventoFragment : Fragment() {

    private lateinit var eventoViewModel: EventoViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        eventoViewModel =
                ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(EventoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_evento, container, false)
        val button: Button = root.findViewById(R.id.btnGuardarEvento)
        button.setOnClickListener {
            Toast.makeText(getActivity(), "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
        }
        val textView: TextView = root.findViewById(R.id.text_gallery)
        eventoViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}