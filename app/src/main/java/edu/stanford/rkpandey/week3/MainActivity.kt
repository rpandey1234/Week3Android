package edu.stanford.rkpandey.week3

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.activity_main.*

private const val STANFORD_IMAGE_URL = "https://pangea.stanford.edu/sites/default/files/Stanford%20Campus.jpg"
private const val ADD_CONTACT_REQUEST_CODE = 1234
class MainActivity : AppCompatActivity() {

    private lateinit var contacts: MutableList<Contact>
    private lateinit var adapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Glide.with(this).load(STANFORD_IMAGE_URL).transform(RoundedCorners(100)).into(imageView)
        // rvContacts.setBackgroundColor(Color.RED)

        //Add RecyclerView AndroidX library to the Gradle build file - DONE
        //Define a model class to use as the data source - DONE
        contacts = createContacts()
        //Add a RecyclerView to your activity to display the items - DONE
        //Create a custom row layout XML file to visualize the item - DONE
        //Create a RecyclerView.Adapter and ViewHolder to render the item - DONE
        adapter = ContactsAdapter(this, contacts)
        //Bind the adapter to the data source to populate the RecyclerView
        rvContacts.layoutManager = LinearLayoutManager(this)
        rvContacts.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_add) {
            val addContactIntent = Intent(this, AddContactActivity::class.java)
            startActivityForResult(addContactIntent, ADD_CONTACT_REQUEST_CODE)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_CONTACT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                val personName = data.getStringExtra("name")
                val personAge = data.getIntExtra("age", -1)
                val newContact = Contact(personName, personAge)
                Log.i("rkprkp", "new contact $newContact")
                contacts.add(0, newContact)
                // adapter.notifyDataSetChanged()
                adapter.notifyItemInserted(0)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun createContacts(): MutableList<Contact> {
        val contacts = mutableListOf<Contact>()
        for (i in 1..150) contacts.add(Contact("Person $i", i))
        return contacts
    }
}
