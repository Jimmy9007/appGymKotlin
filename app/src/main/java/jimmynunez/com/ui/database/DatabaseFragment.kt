package jimmynunez.com.ui.database

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import jimmynunez.com.R
import org.json.JSONArray
import org.json.JSONObject

class DatabaseFragment : Fragment() {

    private lateinit var databaseViewModel: DatabaseViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        databaseViewModel =
                ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DatabaseViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_database, container, false)
        val tvNombre: TextView = root.findViewById(R.id.tvNombre)
        val tvLogin: TextView = root.findViewById(R.id.tvLogin)
        val tvGenero: TextView = root.findViewById(R.id.tvGenero)
        val imagen =  root.findViewById<ImageView>(R.id.imageView3)
        val queue= Volley.newRequestQueue(this.context)
        val url ="http://192.168.164.63/spartanswebservice/listaUsuarios.php"
        val stringRequest= StringRequest(Request.Method.GET,url,Response.Listener { response ->
            val jsonArray = JSONArray(response)
            for (i in 0 until jsonArray.length()){
                val jsonObject= JSONObject(jsonArray.getString(i))
                var text =jsonObject.get("nombreApellido")
                tvNombre.text=jsonObject.get("nombreApellido").toString()
                tvLogin.text=jsonObject.get("login").toString()
                tvGenero.text=jsonObject.get("genero").toString()
                val rutaFoto ="http://192.168.164.63/gimnasio/public/img/profile/"+jsonObject.get("rutaFotoPerfil").toString()
                Glide.with(this).load(rutaFoto).into(imagen)
                Toast.makeText(this.context,text.toString(),Toast.LENGTH_LONG).show()
            }
        },Response.ErrorListener { error ->

        })
        queue.add(stringRequest)
        val textView: TextView = root.findViewById(R.id.text_database)
        databaseViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it


        })
        return root
    }



    }