package com.example.datawarehouseproject

import CustomAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import com.example.retrofittest.model.Post

class SelectionScreenActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_screen)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        val submit= findViewById<Button>(R.id.Submit)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<ArrayList<String>>()
        //Obje oluşturarak datayı doldur
        val school = arrayListOf("School","GB","MS")
        val sex = arrayListOf("Sex","F","M")
        val age = arrayListOf("Age","15","16","17","18","19","20","21","22")
        val address = arrayListOf("Address","U","R")
        val famsize = arrayListOf("Famsize","LE3","GT3")
        val Pstatus = arrayListOf("Pstatus","T","A")
        val Medu = arrayListOf("Medu","0","1","2","3","4")
        val Fedu = arrayListOf("Fedu","0","1","2","3","4")
        val Mjob = arrayListOf("Mjob","teacher","health","services","at home","other")
        val Fjob = arrayListOf("Fjob","teacher","health","services","at home","other")
        val reason = arrayListOf("Reason","home","reputation","course","other")
        val guardian = arrayListOf("Guardian","mother","father","other")
        val traveltime = arrayListOf("Traveltime","1","2","3","4")
        val studytime = arrayListOf("Studytime","1","2","3","4")
        val failures = arrayListOf("Failures","1","2","3","4")
        val schoolsup = arrayListOf("Schoolsup","YES","NO")
        val famsup = arrayListOf("Famsup","YES","NO")
        val paid = arrayListOf("Paid","YES","NO")
        val activities = arrayListOf("Activities","YES","NO")
        val higher = arrayListOf("Higher","YES","NO")
        val internet = arrayListOf("Internet","YES","NO")
        val romantic = arrayListOf("Romantic","YES","NO")
        val famrel = arrayListOf("Famrel","1","2","3","4","5")
        val freetime =  arrayListOf("Freetime","1","2","3","4","5")
        val goout =  arrayListOf("Goout","1","2","3","4","5")
        val Dalc =  arrayListOf("Dalc","1","2","3","4","5")
        val Walc =  arrayListOf("Walc","1","2","3","4","5")
        val health =  arrayListOf("Health","1","2","3","4","5")
        val absences = arrayListOf<String>()//93'e kadar
        absences.add("Absences")
        for (i in 1..93) {
            absences.add(i.toString())
        }

        val grade1 = arrayListOf<String>()//0 to 20
        val grade2 = arrayListOf<String>()//0 to 20
        val grade3 = arrayListOf<String>()//0 to 20
        grade1.add("Grade1")
        grade2.add("Grade2")
        grade3.add("Grade3")

        for (i in 0..20) {
            grade1.add(i.toString())
            grade2.add(i.toString())
            grade3.add(i.toString())
        }

        data.add(school)
        data.add(sex)
        data.add(age)
        data.add(address)
        data.add(famsize)
        data.add(Pstatus)
        data.add(Medu)
        data.add(Fedu)
        data.add(Mjob)
        data.add(Fjob)
        data.add(reason)
        data.add(guardian)
        data.add(traveltime)
        data.add(studytime)
        data.add(failures)
        data.add(schoolsup)
        data.add(famsup)
        data.add(paid)
        data.add(activities)
        data.add(higher)
        data.add(internet)
        data.add(romantic)
        data.add(famrel)
        data.add(freetime)
        data.add(goout)
        data.add(Dalc)
        data.add(Walc)
        data.add(health)
        data.add(absences)
        data.add(grade1)
        data.add(grade2)
        data.add(grade3)


        val adapter = CustomAdapter(data,this,)
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter


        submit.setOnClickListener()
        {
            Service()
        }
    }
    private fun Service()
    {

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        //val myPost = Post("GP","M",1,2, "other", 11,11,11,2,"other","T",1,4,"yes","R",17,0,4,"GT3","yes",5,2,"father",1,"yes","yes","yes","yes","course","no","no",2,2)
        val myPost = Post(SpinnerObjects.school,SpinnerObjects.sex,SpinnerObjects.Dalc.toInt(),SpinnerObjects.Fedu.toInt(), SpinnerObjects.Fjob, SpinnerObjects.grade1.toInt(),SpinnerObjects.grade2.toInt(),SpinnerObjects.grade3.toInt(),SpinnerObjects.Medu.toInt(),SpinnerObjects.Mjob,SpinnerObjects.Pstatus,SpinnerObjects.Walc.toInt(),SpinnerObjects.absences.toInt(),SpinnerObjects.activities,SpinnerObjects.address,SpinnerObjects.age.toInt(),SpinnerObjects.failures.toInt(),SpinnerObjects.famrel.toInt(),SpinnerObjects.famsize,SpinnerObjects.famsup,SpinnerObjects.freetime.toInt(),SpinnerObjects.goout.toInt(),SpinnerObjects.guardian,SpinnerObjects.health.toInt(),SpinnerObjects.higher,SpinnerObjects.internet,"yes",SpinnerObjects.paid,SpinnerObjects.reason,SpinnerObjects.romantic,SpinnerObjects.schoolsup,SpinnerObjects.studytime.toInt(),SpinnerObjects.traveltime.toInt())

        viewModel.pushPost(myPost)


        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                var Keepresult=response.body().toString().substring(13,response.body().toString().length-2)
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", Keepresult)
                startActivity(intent)
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);

                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.toString())
                Log.d("Main", response.headers().toString())


            }else {
                Log.d("Main", response.toString())
            }
        })
    }
}