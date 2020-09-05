package com.kjw.guru
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        
        two.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "bbreathe")
            }
            startActivity(intent)
        }
        iha.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "bbreathe")
            }
            startActivity(intent)
        }
        
        paulkim.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "brain")
            }
            startActivity(intent)
        }
        paul.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "brain")
            }
            startActivity(intent)
        }
        
        yangyang.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "byangda2")
            }
            startActivity(intent)
        }
        yang.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "byangda2")
            }
            startActivity(intent)
        }
        
        snowsnow.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "bsnow")
            }
            startActivity(intent)
        }
        snow.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "bsnow")
            }
            startActivity(intent)
        }

    }


}