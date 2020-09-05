package com.kjw.guru
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        hundred.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "dbyebye")
            }
            startActivity(intent)
        }
        bye.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "dbyebye")
            }
            startActivity(intent)
        }
        
        eded.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "dbeautifulpeople")
            }
            startActivity(intent)
        }
        ed.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "dbeautifulpeople")
            }
            startActivity(intent)
        }
        
        ash2.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "derror")
            }
            startActivity(intent)
        }
        error.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "derror")
            }
            startActivity(intent)
        }
        
        ash.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "dnightmare")
            }
            startActivity(intent)
        }
        night.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "dnightmare")
            }
            startActivity(intent)
        }

    }
}