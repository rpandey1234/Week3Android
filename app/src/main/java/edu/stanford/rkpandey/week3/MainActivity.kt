package edu.stanford.rkpandey.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.activity_main.*

private const val STANFORD_IMAGE_URL = "https://pangea.stanford.edu/sites/default/files/Stanford%20Campus.jpg"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Glide.with(this).load(STANFORD_IMAGE_URL).transform(RoundedCorners(100)).into(imageView)
    }
}
