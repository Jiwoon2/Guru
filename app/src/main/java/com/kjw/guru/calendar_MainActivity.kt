package com.kjw.guru


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_calendar__main.*
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlinx.android.synthetic.main.activity_calendar__main.cha_Btn as cha_Btn1
import kotlinx.android.synthetic.main.activity_calendar__main.contextEditText as contextEditText1
import kotlinx.android.synthetic.main.activity_calendar__main.del_Btn as del_Btn1
import kotlinx.android.synthetic.main.activity_calendar__main.diaryTextView as diaryTextView1

var db = FirebaseFirestore.getInstance()

class calendar_MainActivity : AppCompatActivity() {

    var emotion: Int = 0
    val RC_SIGN_IN = 1000

    //CalendarView 인스턴스 만들기 **************
    var calendar: CalendarView? = null
    var feelingsbutton: RelativeLayout? = null //모든 기분 버튼을 나타내는 뷰 인스턴스

    var happybutton: Button? = null
    var sadbutton: Button? = null
    var angrybutton: Button? = null
    var depressedbutton: Button? = null
    var showfeelingView: Button? = null
    var showdiary: Button? = null
    var diaryView: View? = null

    //다이어리 요소
    var fname: String = ""
    var str: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar__main)

        //로그인이 안됨
        if (FirebaseAuth.getInstance().currentUser == null) {
            login()
        }

        //CalendarView 인스턴스 만들기
        calendar = findViewById<View>(R.id.calendar) as CalendarView
        feelingsbutton = findViewById<View>(R.id.feelings) as RelativeLayout?//모든 기분 버튼을 나타내는 뷰 인스턴스

        happybutton = findViewById<View>(R.id.happybutton) as Button
        sadbutton = findViewById<View>(R.id.sadbutton) as Button
        angrybutton = findViewById<View>(R.id.angrybutton) as Button
        depressedbutton = findViewById<View>(R.id.depressedbutton) as Button
        showfeelingView = findViewById<View>(R.id.showfeelingsbutton) as Button
        showdiary = findViewById<View>(R.id.showdiaryButton) as Button
        diaryView = findViewById<View>(R.id.diaryTextView) as View


        //리스너 등록(날짜가 바뀌면)
        calendar!!.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // TODO Auto-generated method stub
            Toast.makeText( //토스트 메세지를 표시
                this, "" + year + "/" + (month + 1) + "/"
                        + dayOfMonth, Toast.LENGTH_SHORT
            ).show()
        }

        showfeelingView!!.setOnClickListener {   //기분을 고르는 버튼을 눌렀을때
            feelingsbutton!!.setVisibility(View.VISIBLE) // 모든 기분 버튼을 보여주는 relativeLayout이 보이게
            diaryView!!.setVisibility(View.INVISIBLE) //다이어리를 보여주는 LinearLayout이 안보이게

            del_Btn1!!.setVisibility(View.GONE)
            cha_Btn1!!.setVisibility(View.GONE)
            diarysave_Btn!!.setVisibility(View.GONE)

        }

        showdiary!!.setOnClickListener {
            feelingsbutton!!.setVisibility(View.GONE)
            diaryView!!.setVisibility(View.GONE)

            calendar!!.setOnDateChangeListener { view, year, month, dayOfMonth ->
        // 달력 날짜가 선택되면
                diaryTextView1.visibility = View.VISIBLE // 해당 날짜가 뜨는 textView가 Visible
                diarysave_Btn.visibility = View.VISIBLE // 저장 버튼이 Visible
                contextEditText1.visibility = View.VISIBLE // EditText가 Visible
                textView2.visibility = View.INVISIBLE // 저장된 일기 textView가 Invisible
                cha_Btn1.visibility = View.INVISIBLE // 수정 Button이 Invisible
                del_Btn1.visibility = View.INVISIBLE // 삭제 Button이 Invisible

                diaryTextView1.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
        // 날짜를 보여주는 텍스트에 해당 날짜를 넣는다.
                contextEditText1.setText("") // EditText에 공백값 넣기

                checkedDay(year, month, dayOfMonth) // checkedDay 메소드 호출

            }
        }
        diarysave_Btn.setOnClickListener { // 저장 Button이 클릭되면
            Toast.makeText(this, fname + "데이터를 저장했습니다.", Toast.LENGTH_SHORT)
                .show()
            str = contextEditText1.getText().toString() // str 변수에 edittext내용을 toString형으로 저장
            textView2.text = "${str}" // textView에 str 출력
            diarysave_Btn.visibility = View.INVISIBLE
            cha_Btn1.visibility = View.VISIBLE
            del_Btn1.visibility = View.VISIBLE
            contextEditText1.visibility = View.INVISIBLE
            textView2.visibility = View.VISIBLE

            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                var updatedb = db.collection(user.uid).document().id
                var line = Line(fname, str)
                FirebaseAuth.getInstance().currentUser?.let { user ->

                    db.collection(user.uid)
                        .document(fname)
                        .set(line)
                }
            }
        }

        happybutton?.setOnClickListener {
            this.emotion = 1
            happybutton?.setBackgroundColor(getColor(R.color.happy));
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        sadbutton?.setOnClickListener {
            this.emotion = 2
            sadbutton?.setBackgroundColor(getColor(R.color.sad));
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        angrybutton?.setOnClickListener {
            this.emotion = 3
            angrybutton?.setBackgroundColor(getColor(R.color.angry));
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        depressedbutton?.setOnClickListener {
            this.emotion = 4
            depressedbutton?.setBackgroundColor(getColor(R.color.depressed));
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                // ...
            } else {
                //로그인실패
                finish()
            }
        }
    }

    fun login() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
        )

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN
        )
    }

    fun logout() {
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener {

                login()
            }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.acition_log_out -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun checkedDay(cYear: Int, cMonth: Int, cDay: Int) {

        fname = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt"
        // 저장할 파일 이름 설정. Ex) 2019-01-20.txt

        contextEditText1.visibility = View.INVISIBLE
        textView2.visibility = View.VISIBLE
        textView2.text = "${str}" // textView에 str 출력

        diarysave_Btn.visibility = View.INVISIBLE
        cha_Btn1.visibility = View.VISIBLE
        del_Btn1.visibility = View.VISIBLE

        val liveData = MutableLiveData<String>()
        db = FirebaseFirestore.getInstance()

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            db.collection(user.uid)
                .addSnapshotListener { value, e ->
                    if (e != null) {
                        Log.w("tagg", "Listen failed.", e)
                        return@addSnapshotListener
                    }

                    for (document in value!!) {
                        Log.d("tagg", "${document.id} => ${document.data}")
                        val line = Line(
                            document.getString("fname") ?: "",
                            document.getString("str") ?: ""
                        )

                        if (fname == line.fname) {
                            str = line.str
                            fname = line.fname
                        }
                        else if (fname == null) {
                            str = ""
                            fname = ""
                        }
                    }
                    liveData.value = str
                }
        }

        cha_Btn1.setOnClickListener { // 수정 버튼을 누를 시
            contextEditText1.visibility = View.VISIBLE
            textView2.visibility = View.INVISIBLE
            contextEditText1.setText(str) // editText에 textView에 저장된 내용을 출력

            diarysave_Btn.visibility = View.VISIBLE
            cha_Btn1.visibility = View.INVISIBLE
            del_Btn1.visibility = View.INVISIBLE
            textView2.text = "${contextEditText1.getText()}"
        }

        del_Btn1.setOnClickListener {
            textView2.visibility = View.INVISIBLE
            contextEditText1.setText("")
            contextEditText1.visibility = View.VISIBLE
            diarysave_Btn.visibility = View.VISIBLE
            cha_Btn1.visibility = View.INVISIBLE
            del_Btn1.visibility = View.INVISIBLE

            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                FirebaseAuth.getInstance().currentUser?.let { user ->

                    db.collection(user.uid)
                        .document(fname)
                        .delete()
                }
            }

            Toast.makeText(this, fname + "데이터를 삭제했습니다.", Toast.LENGTH_SHORT)
                .show()
        }

        if (textView2.getText() == "") {
            textView2.visibility = View.INVISIBLE
            diaryTextView1.visibility = View.VISIBLE
            diarysave_Btn.visibility = View.VISIBLE
            cha_Btn1.visibility = View.INVISIBLE
            del_Btn1.visibility = View.INVISIBLE
            contextEditText1.visibility = View.VISIBLE
        }
    }
}
data class Line(
    var fname: String = "",
    var str: String = ""
)