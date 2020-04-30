package edu.stanford.rkpandey.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView steps: https://guides.codepath.com/android/using-the-recyclerview#using-the-recyclerview
        // 1. Add RecyclerView AndroidX library to the Gradle build file - DONE
        // 2. Define a model class to use as the data source - DONE
        val contacts = createContacts()
        // 3. Add a RecyclerView to your activity to display the items - DONE
        // 4. Create a custom row layout XML file to visualize the item - DONE
        // 5. Create a RecyclerView.Adapter and ViewHolder to render the item
        val adapter = ContactAdapter(this, contacts)
        // 6. Bind the adapter to the data source to populate the RecyclerView
        rvContacts.adapter = adapter
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

    private fun createContacts(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        for (i in 1..150) contacts.add(Contact("Person $i", i))
        return contacts
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_add) {
            // Navigate to the new activity
            Log.i(TAG, "Tapped on add menu option")
            val addContactIntent = Intent(this, AddContactActivity::class.java)
            startActivity(addContactIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}
