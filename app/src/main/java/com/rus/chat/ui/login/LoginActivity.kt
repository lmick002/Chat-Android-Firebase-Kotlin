package com.rus.chat.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rus.chat.R
import com.rus.chat.presenters.login.LoginPresenter
import com.rus.chat.presenters.login.LoginPresenterImpl
import com.rus.chat.ui.conversations.ConversationsActivity
import com.rus.chat.utils.Logger
import com.rus.chat.utils.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenterImpl(this)

        signInButton.setOnClickListener { loginPresenter.doLogin(email.text.toString(), password.text.toString()) }
    }

    override fun openConversationsActivity() {
        val intent = Intent(this, ConversationsActivity::class.java)
        startActivity(intent)
    }

    override fun onLoginError(t: Throwable) {
        toast(t.message ?: "Error")
    }
}