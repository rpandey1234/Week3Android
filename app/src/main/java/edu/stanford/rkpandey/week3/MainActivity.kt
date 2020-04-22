package edu.stanford.rkpandey.week3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.activity_main.*

private const val STANFORD_IMAGE_URL = "https://pangea.stanford.edu/sites/default/files/Stanford%20Campus.jpg"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Glide.with(this).load(STANFORD_IMAGE_URL).transform(RoundedCorners(100)).into(imageView)
        // rvContacts.setBackgroundColor(Color.RED)

        //Add RecyclerView AndroidX library to the Gradle build file - DONE
        //Define a model class to use as the data source - DONE
        val contacts = createContacts()
        //Add a RecyclerView to your activity to display the items - DONE
        //Create a custom row layout XML file to visualize the item - DONE
        //Create a RecyclerView.Adapter and ViewHolder to render the item - DONE
        val adapter = ContactsAdapter(this, contacts)
        //Bind the adapter to the data source to populate the RecyclerView
        rvContacts.layoutManager = LinearLayoutManager(this)
        rvContacts.adapter = adapter

    }

    private fun createContacts(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        for (i in 1..150) contacts.add(Contact("Person $i", i))
        return contacts
    }
}
