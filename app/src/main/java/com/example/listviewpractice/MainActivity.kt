package com.example.listviewpractice
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.listviewpractice.adapters.StudentAdapter
import com.example.listviewpractice.databinding.ActivityMainBinding
import com.example.listviewpractice.datas.Student

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()
    //바로대입할 것이 아니라 나중에 넣어줄것이다.
    lateinit var  mAdapter :StudentAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //데이터를 추가해주는 기능
        mStudentList.add(Student("chabchab", 2000))
        mStudentList.add(Student("seyeon"  , 1999))
        mStudentList.add(Student("minseo", 2001))
        mStudentList.add(Student("chab2", 1998))

        mAdapter=StudentAdapter(this,R.layout.student_list_item, mStudentList)

        binding.studentListView.adapter =mAdapter
    
        binding.studentListView.setOnItemClickListener { parent, view, position, id ->

            val clickedStudent = mStudentList[position]

            Toast.makeText(this, "${clickedStudent.name}이 클릭 됨", Toast.LENGTH_SHORT).show()

        }
        binding.studentListView.setOnItemLongClickListener { parent, view, position, id ->

            mStudentList.removeAt(position)
            //새로고침 같은 기능을 해줘야함(리스트뷰의 목록 변경 반영하기)

            mAdapter.notifyDataSetChanged()
            return@setOnItemLongClickListener true
        }


    }
}