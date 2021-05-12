package kg.tutorialapp.signinup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constance.REQUEST_CODE_SIGN_UP){

            login = data?.getStringExtra(Constance.LOGIN)!!
            password = data?.getStringExtra(Constance.PASSWORD)!!
            name = data?.getStringExtra(Constance.NAME)!!
            firstName = data?.getStringExtra(Constance.FIRST_NAME)!!
            secondName = data?.getStringExtra(Constance.SECOND_NAME)!!

            bindingClass.imAvatar.visibility = View.VISIBLE
            avatarImageId = data?.getIntExtra(Constance.AVATAR_ID, 0)

            val textInfo = "$name $firstName $secondName"
            bindingClass.tvInfo.text = textInfo

            bindingClass.bHide.visibility = View.GONE
            bindingClass.bExit.text = "Exit"

        }
    }

    fun onClickSignUp(v: View){
        val intent = Intent(this, SignInUpAct::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)

    }
}