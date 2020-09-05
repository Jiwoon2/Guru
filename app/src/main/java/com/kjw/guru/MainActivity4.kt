package com.kjw.guru
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        nctnct.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "cnct")
            }
            startActivity(intent)
        }
        nct.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "cnct")
            }
            startActivity(intent)
        }
        
        gang.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "cinternetwar")
            }
            startActivity(intent)
        }
        jaypack.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "cinternetwar")
            }
            startActivity(intent)
        }
        
        loopy.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "cgang")
            }
            startActivity(intent)
        }
        rupi.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "cgang")
            }
            startActivity(intent)
        }
        
        changchang.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "cselfmadeorange")
            }
            startActivity(intent)
        }
        chang.setOnClickListener {
            val intent = Intent(this, musicplayer::class.java)
            //val intent = Intent(this@Test, musicplayer::class.java)
            intent.apply {
                this.putExtra("name", "cselfmadeorange")
            }
            startActivity(intent)
        }


    }
}