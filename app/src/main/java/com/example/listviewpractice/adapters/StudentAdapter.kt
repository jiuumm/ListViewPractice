package com.example.listviewpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listviewpractice.R
import com.example.listviewpractice.datas.Student


//context:지금 내가 보고 있는 화면
class StudentAdapter(val mContext : Context,
                     val resId: Int,
                     val mList: ArrayList<Student>) : ArrayAdapter<Student>(mContext,resId, mList){
//목록을 뿌려주는 작업을 해보자

                         val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow==null){
            tempRow= inf.inflate(R.layout.student_list_item, null)
        }

        //tempRow는 채워짐!
        val row = tempRow!!//코틀린 문법임..

        val studuentData = mList[position]
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val birthYearTxt = row.findViewById<TextView>(R.id.birthYearTxt)

        nameTxt.text = studuentData.name

        //출생년도를 가지고 -> 나이로 변환해서 보여주기

        val koreanAge = 2024-studuentData.birthYear+1
        birthYearTxt.text = "(${koreanAge}세)"
        return row
    }

}