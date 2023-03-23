package ni.edu.uca.jsonprocessing

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    data class Person(
        val name: String,
        val age: Int,
        val email: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = Gson()

        // Ejemplo de contenido JSON
        val json = """
            {
                "name": "John Doe",
                "age": 30,
                "email": "johndoe@example.com"
            }
        """.trimIndent()

        // Deserializar el contenido JSON en una instancia de la clase Person
        val person = gson.fromJson(json, Person::class.java)

        // Acceder a las propiedades de la instancia de Person
        Log.d("MainActivity", "Name: ${person.name}")
        Log.d("MainActivity", "Age: ${person.age}")
        Log.d("MainActivity", "Email: ${person.email}")

        // Serializar una instancia de la clase Person en un objeto JSON
        val person2 = Person("Jane Doe", 25, "janedoe@example.com")
        val json2 = gson.toJson(person2)

        // Imprimir el objeto JSON serializado
        Log.d("MainActivity", "JSON: $json2")
    }
}
