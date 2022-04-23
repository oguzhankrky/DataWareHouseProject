import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.datawarehouseproject.R
import com.example.datawarehouseproject.SpinnerObjects

class CustomAdapter(private val mList: List<ArrayList<String>>,val context: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val values = arrayListOf<String>()//33'e kadar

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position], context)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : View.OnClickListener, RecyclerView.ViewHolder(itemView) {
        //private lateinit var item : Item
        val spinner: Spinner = itemView.findViewById(R.id.spinner)
        val hintTextView: TextView = itemView.findViewById(R.id.hint)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(arraylist: ArrayList<String>, context: Context) {
            val spinnerAdapter= object : ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, arraylist){

                override fun isEnabled(position: Int): Boolean {
                    // Disable the first item from Spinner
                    // First item will be used for hint
                    return position != 0
                }

                override fun getDropDownView(
                    position: Int,
                    convertView: View?,
                    parent: ViewGroup
                ): View {
                    val view: TextView = super.getDropDownView(position, convertView, parent) as TextView
                    //set the color of first item in the drop down list to gray
                    if(position == 0) {
                        view.setTextColor(Color.GRAY)
                    } else {
                        //here it is possible to define color for other items by
                        //view.setTextColor(Color.RED)
                    }
                    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {

                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            val value: String = parent?.getItemAtPosition(position).toString()
                            val spinner_name: String = parent?.getItemAtPosition(0).toString()
                            match(spinner_name,value)
                        }
                    }



                    return view
                }


            }
            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = spinnerAdapter
            hintTextView.text = spinner.getItemAtPosition(0).toString()
        }
        fun match(spinner_name: String ,value: String){
            if(spinner_name == "School"){
                SpinnerObjects.school=value
            }
            else if(spinner_name == "Sex"){
                SpinnerObjects.sex=value
            }
            else if(spinner_name == "Age"){
                SpinnerObjects.age=value.toInt()
            }
            else if(spinner_name == "Address"){
                SpinnerObjects.address=value
            }
            else if(spinner_name == "Famsize"){
                SpinnerObjects.famsize=value
            }
            else if(spinner_name == "Pstatus"){
                SpinnerObjects.Pstatus=value
            }
            else if(spinner_name == "Medu"){
                SpinnerObjects.Medu=value.toInt()
            }
            else if(spinner_name == "Fedu"){
                SpinnerObjects.Fedu=value.toInt()
            }
            else if(spinner_name == "Mjob"){
                SpinnerObjects.Mjob=value
            }
            else if(spinner_name == "Fjob"){
                SpinnerObjects.Fjob=value
            }
            else if(spinner_name == "Reason"){
                SpinnerObjects.reason=value
            }
            else if(spinner_name == "Guardian"){
                SpinnerObjects.guardian=value
            }
            else if(spinner_name == "Traveltime"){
                SpinnerObjects.traveltime=value.toInt()
            }
            else if(spinner_name == "Studytime"){
                SpinnerObjects.studytime=value.toInt()
            }
            else if(spinner_name == "Failures"){
                SpinnerObjects.failures=value.toInt()
            }
            else if(spinner_name == "Schoolsup"){
                SpinnerObjects.schoolsup=value
            }
            else if(spinner_name == "Famsup"){
                SpinnerObjects.famsup=value
            }
            else if(spinner_name == "Paid"){
                SpinnerObjects.paid=value
            }
            else if(spinner_name == "Activities"){
                SpinnerObjects.activities=value
            }
            else if(spinner_name == "Higher"){
                SpinnerObjects.higher=value
            }
            else if(spinner_name == "Internet"){
                SpinnerObjects.internet=value
            }
            else if(spinner_name == "Romantic"){
                SpinnerObjects.romantic=value
            }
            else if(spinner_name == "Famrel"){
                SpinnerObjects.famrel=value.toInt()
            }
            else if(spinner_name == "Freetime"){
                SpinnerObjects.freetime=value.toInt()
            }
            else if(spinner_name == "Goout"){
                SpinnerObjects.goout=value.toInt()
            }
            else if(spinner_name == "Dalc"){
                SpinnerObjects.Dalc=value.toInt()
            }
            else if(spinner_name == "Walc"){
                SpinnerObjects.Walc=value.toInt()
            }
            else if(spinner_name == "Health"){
                SpinnerObjects.health=value.toInt()
            }
            else if(spinner_name == "absences"){
                SpinnerObjects.absences=value.toInt()
            }
            else if(spinner_name == "grade1"){
                SpinnerObjects.grade1=value.toInt()
            }
            else if(spinner_name == "grade2"){
                SpinnerObjects.grade2=value.toInt()
            }
            else if(spinner_name == "grade3"){
                SpinnerObjects.grade3=value.toInt()
            }
        }
        override fun onClick(v: View?) {

            v?.let {
                val context = it.context


            }
        }

    }
}
