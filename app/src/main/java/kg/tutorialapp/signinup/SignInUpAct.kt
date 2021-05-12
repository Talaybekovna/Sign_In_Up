package kg.tutorialapp.signinup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kg.tutorialapp.signinup.databinding.SignInUpBinding

class SignInUpAct: AppCompatActivity() {

    lateinit var bindingClass: SignInUpBinding
    private var signState = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = SignInUpBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE)!!

        if (signState == Constance.SIGN_IN_STATE){

            bindingClass.edName.visibility = View.GONE
            bindingClass.edFirstName.visibility = View.GONE
            bindingClass.edSecondName.visibility = View.GONE
            bindingClass.bAvatar.visibility = View.INVISIBLE
        }
    }

    fun onClickDone(v: View) {

        if (signState == Constance.SIGN_UP_STATE) {

            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            intent.putExtra(Constance.NAME, bindingClass.edName.text.toString())
            intent.putExtra(Constance.FIRST_NAME, bindingClass.edFirstName.text.toString())
            intent.putExtra(Constance.SECOND_NAME, bindingClass.edSecondName.text.toString())
            if (bindingClass.imAvatar.isVisible) intent.putExtra(Constance.AVATAR_ID, R.drawable.profil)
            setResult(Activity.RESULT_OK, intent)
            finish()

        } else if (signState == Constance.SIGN_IN_STATE){

            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    fun onClickAvatar(v:View){
        bindingClass.imAvatar.visibility = View.VISIBLE
    }
}