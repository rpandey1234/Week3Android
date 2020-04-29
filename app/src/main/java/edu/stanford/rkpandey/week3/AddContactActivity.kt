package edu.stanford.rkpandey.week3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_contact.*

class AddContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val data = Intent()
            data.putExtra("name", name)
            data.putExtra("age", age)
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}
