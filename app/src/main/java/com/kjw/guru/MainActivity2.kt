package com.kjw.guru
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        oh.setOnClickListener{
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "adolphin")
            }
            startActivity(intent)
        }
        ohmy.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "adolphin")
            }
            startActivity(intent)
        }

        tae.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "ahappy")
            }
            startActivity(intent)
        }
        tay.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "ahappy")
            }
            startActivity(intent)
        }

        car.setOnClickListener { val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "abushwick")
            }
            startActivity(intent)
        }
        kade.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "abushwick")
            }
            startActivity(intent)
        }

        gimary.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "abirthday")
            }
            startActivity(intent)
        }
        anne.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "abirthday")
            }
            startActivity(intent)
        }


    }
}