package cursoandroid.mapas.kotlingasolinaoualcool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

   // val botaoCalcular = findViewById<Button>(R.id.buttonCalcular)


    //apply plugin: 'kotlin-android-extensions'

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {

        var camposValidados: Boolean = true
        if (precoAlcool == null || precoAlcool.equals(""))
            camposValidados = false
        else if (precoGasolina == null || precoGasolina.equals(""))
            camposValidados = false

        return camposValidados
    }

    /*botaoCalcular.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {*/

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {

        //converte valores string para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /* Faz cálculo (precoAlcool / preco gasolina)
            * Se resultado >= 0.7 melhor utilizar gasolina
            * Se não, melhor utilizar Álcool */

        val resultadoPreco = valorAlcool / valorGasolina

        if (resultadoPreco >= 0.7) {
            textResultado.text = "Melhor utilizar Gasolina!"
        } else {
            textResultado.text = "Melhor utilizar Álcool!"
        }

    }


    fun calcularPreco(view: View) {


      /*  val usuario = Usuario()
        usuario.nome = "Gabriel Luconi"

        textResultado.text = usuario.nome*/


        //recuperar valores digitados
        //val precoAlcool = findViewById<EditText>(R.id.textAlcool)

        val precoAlcool = textAlcool.text.toString()
        val precoGasolina = textGasolina.text.toString()


        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if (validaCampos) {
            calcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            textResultado.text = "Preencha os preços primeiro!"
        }
    }

}


