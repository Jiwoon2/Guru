package com.kjw.guru

import android.R
import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_musicplayer.*
import java.lang.Exception
import com.kjw.guru.musicplayer as musicplayer


class musicplayer : AppCompatActivity() {
    var playBtn: Button? = null
    var positionBar: SeekBar? = null
    var volumeBar: SeekBar? = null
    var elapsedTimeLabel: TextView? = null
    var remainingTimeLabel: TextView? = null
    var mp: MediaPlayer? = null
    var totalTime = 0

    var finpath=com.kjw.guru.R.raw.brain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.kjw.guru.R.layout.activity_musicplayer)
        playBtn = findViewById<View>(com.kjw.guru.R.id.playBtn) as Button
        elapsedTimeLabel = findViewById<View>(com.kjw.guru.R.id.elapsedTimeLabel) as TextView
        remainingTimeLabel = findViewById<View>(com.kjw.guru.R.id.remainingTimeLabel) as TextView

        // Media Player
        val name = intent.getStringExtra("name")
        if (name == "abirthday") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.abirthday)
            music_name.text = "Birthday"
            artist_name.text="Anne-Marie"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.birthday)
        }
        if (name == "ahappy") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.ahappy)
            music_name.text = "Happy"
            artist_name.text="태연"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.happy)
        }
        if (name == "abushwick") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.abushwick)
            music_name.text = "Bushwick"
            artist_name.text="카더가든"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.bushwick)
        }
        if (name == "adolphin") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.adolphin)
            music_name.text = "Dolphin"
            artist_name.text="오마이걸"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.dolphin)
        }

        if (name == "brain") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.brain)
            music_name.text = "비"
            artist_name.text="폴킴"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.rain)
        }
        if (name == "byangda2") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.byangda2)
            music_name.text = "너를 잊으면"
            artist_name.text="양다일"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.yangda)
        }
        if (name == "bsnow") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.bsnow)
            music_name.text = "눈"
            artist_name.text="설"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.snow)
        }
        if (name == "bbreathe") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.bbreathe)
            music_name.text = "한숨"
            artist_name.text="이하이"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.breathe)
        }

        if (name == "cselfmadeorange") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.cselfmadeorange)
            music_name.text = "Selfmadeorange"
            artist_name.text="창모"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.selfmade)
        }
        if (name == "cgang") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.cgang)
            music_name.text = "Gang"
            artist_name.text="식케이 (Sik-K), pH-1, 박재범, 김하온(HAON)"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.gang)
        }
        if (name == "cinternetwar") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.cinternetwar)
            music_name.text = "인터넷전쟁"
            artist_name.text="루피(Loopy), 나플라 (nafla)"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.internetwar)
        }
        if (name == "cnct") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.cnct)
            music_name.text = "영웅"
            artist_name.text="NCT 127"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.nct)
        }

        if (name == "dbyebye") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.dbyebye)
            music_name.text = "Bye bye my blue"
            artist_name.text="백예린"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.byebye)
        }
        if (name == "dbeautifulpeople") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.dbeautifulpeople)
            music_name.text = "Beautiful People"
            artist_name.text="Ed Sheeran"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.beautiful)
        }
        if (name == "derror") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.derror)
            music_name.text = "Birthday"
            artist_name.text="ASH ISLAND"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.error)
        }
        if (name == "dnightmare") {
            mp = MediaPlayer.create(this, com.kjw.guru.R.raw.dnigthmare)
            music_name.text = "악몽"
            artist_name.text="ASH ISLAND"
            imgcenter.setImageResource(com.kjw.guru.R.drawable.nightmare)
        }


        mp!!.isLooping = true
        mp!!.seekTo(0)
        mp!!.setVolume(0.5f, 0.5f)
        totalTime = mp!!.duration


        // Position Bar
        positionBar = findViewById<View>(com.kjw.guru.R.id.positionBar) as SeekBar
        positionBar!!.max = totalTime
        positionBar!!.setOnSeekBarChangeListener(
            object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    if (fromUser) {
                        mp!!.seekTo(progress)
                        positionBar!!.progress = progress
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}
                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            }
        )


        // Volume Bar
        volumeBar = findViewById<View>(com.kjw.guru.R.id.volumeBar) as SeekBar
        volumeBar!!.setOnSeekBarChangeListener(
            object : OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    val volumeNum = progress / 100f
                    mp!!.setVolume(volumeNum, volumeNum)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}
                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            }
        )

        // Thread (Update positionBar & timeLabel)
        Thread(Runnable {
            while (mp != null) {
                try {
                    val msg = Message()
                    msg.what = mp!!.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                }
            }
        }).start()



    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle","onStart")

    }
    override fun onResume() {
        super.onResume()
        Log.d("life_cycle","onResume")

    }

    override fun onPause() {
        mp?.pause()
        super.onPause()
        Log.d("life_cycle","onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle","onStop")

    }



    private val handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            val currentPosition = msg.what
            // Update positionBar.
            positionBar!!.progress = currentPosition

            // Update Labels.
            val elapsedTime = createTimeLabel(currentPosition)
            elapsedTimeLabel!!.text = elapsedTime
            val remainingTime = createTimeLabel(totalTime - currentPosition)
            remainingTimeLabel!!.text = "- $remainingTime"
        }
    }

    fun createTimeLabel(time: Int): String {
        var timeLabel: String? = ""
        val min = time / 1000 / 60
        val sec = time / 1000 % 60
        timeLabel = "$min:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec
        return timeLabel
    }

    fun playBtnClick(view: View?) {

        if (!mp!!.isPlaying) {

            // Stopping
            mp!!.start()
            playBtn!!.setBackgroundResource(com.kjw.guru.R.drawable.stop)

        } else {
            // Playing
            mp!!.pause()
            playBtn!!.setBackgroundResource(com.kjw.guru.R.drawable.play)
        }

    }

}
