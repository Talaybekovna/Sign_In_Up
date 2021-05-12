package kg.tutorialapp.signinup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.tutorialapp.signinup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding
    private var login: String = "empty"
    private var password: String = "empty"
    private var name: String = "empty"
    private var firstName: String = "empty"
    private var secondName: String = "empty"
    private var avatarImageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

}