package edu.stanford.rkpandey.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add RecyclerView AndroidX library to the Gradle build file - DONE
        //Define a model class to use as the data source - DONE
        val contacts = createContacts()
        //Add a RecyclerView to your activity to display the items - DONE
        //Create a custom row layout XML file to visualize the item - DONE
        //Create a RecyclerView.Adapter and ViewHolder to render the item
        //Bind the adapter to the data source to populate the RecyclerView
    }

    private fun createContacts(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        for (i in 1..150) contacts.add(Contact("Person $i", i))
        return contacts
    }
}
