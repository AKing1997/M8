package es.kankit.camkit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import es.kankit.camkit.DB.DBHelper

class Form(dbHelper: DBHelper) : Fragment() {
    val db: DBHelper = dbHelper;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        var view = inflater.inflate(R.layout.fragment_form, container, false);
        // Creando todas las variable para despues recibir con facilidad para insertar en base de datos
        val inputFormName: EditText = view.findViewById(R.id.inputFormName);
        val inputFormType: EditText = view.findViewById(R.id.inputFormType);
        val inputFormHash: EditText = view.findViewById(R.id.inputFormHash);
        // Ceando evento en el botton de guadar formulario
        val saveForm: Button = view.findViewById(R.id.saveForm);
        saveForm.setOnClickListener {
            // Haciendo alguanas validacion para antes de inserta en la base de datos en caso de error con su respectivos mensaje via "Toast"
            val nom :Boolean =  inputFormName.text.toString().trim().isEmpty();
            val type :Boolean = inputFormType.text.toString().trim().isEmpty();
            val hash :Boolean = inputFormHash.text.toString().trim().isEmpty();
            if(!nom && !type && !hash){
                db.insertCriptomoneda(Criptomoneda(0,inputFormName.text.toString(), inputFormType.text.toString(), inputFormHash.text.toString()));
                inputFormName.setText("");
                inputFormType.setText("");
                inputFormHash.setText("");
            }else if(nom && type && hash){
                Toast.makeText(context, "Rellene todos los campos.", Toast.LENGTH_SHORT).show();
            }else if(nom && type){
                Toast.makeText(context, "Rellene los campos Nombre y Tipo.", Toast.LENGTH_SHORT).show();
            }else if(nom && hash){
                Toast.makeText(context, "Rellene los campos Nombre y Hash.", Toast.LENGTH_SHORT).show();
            }else if(type && hash){
                Toast.makeText(context, "Rellene los campos Tipo y Hash.", Toast.LENGTH_SHORT).show();
            }else if(nom){
                Toast.makeText(context, "Rellene los campos Nombre.", Toast.LENGTH_SHORT).show();
            }else if(hash){
                Toast.makeText(context, "Rellene los campos Hash.", Toast.LENGTH_SHORT).show();
            }else if(type){
                Toast.makeText(context, "Rellene los campos Tipo.", Toast.LENGTH_SHORT).show();
            }

        }
        return view;
    }
}