package buu.informatics.s59160102.parking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var parking = listOf<Car>(Car() , Car() , Car())
    var selectSlot = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    fun setListener () {
        var slotClick = listOf<Button>(findViewById(R.id.freeOne_button) , findViewById(R.id.freeTwo_button) , findViewById(R.id.freeThree_button))
        for (i in slotClick) {
            i.setOnClickListener{
                fectInfo(i)
            }
        }
        findViewById<Button>(R.id.Add_Button).setOnClickListener{setInfo()}
        findViewById<Button>(R.id.Cancel_Button).setOnClickListener{deleteInfo()}
    }
    fun fectInfo(view: Button){

        selectSlot = view.id.toString()
        //Toast.makeText(this , selectSlot , Toast.LENGTH_SHORT).show()
        checkSlot()
        when(view.id){
            R.id.freeOne_button -> {
                findViewById<TextView>(R.id.Input_Name).requestFocus()
                findViewById<TextView>(R.id.Input_Name).text = parking.get(0).username
                findViewById<TextView>(R.id.Input_Band).text = parking.get(0).carBand
                findViewById<TextView>(R.id.Input_No).text = parking.get(0).carNo
            }
            R.id.freeTwo_button -> {
                findViewById<TextView>(R.id.Input_Name).requestFocus()
                findViewById<TextView>(R.id.Input_Name).text = parking.get(1).username
                findViewById<TextView>(R.id.Input_Band).text = parking.get(1).carBand
                findViewById<TextView>(R.id.Input_No).text = parking.get(1).carNo
            }
            R.id.freeThree_button -> {
                findViewById<TextView>(R.id.Input_Name).requestFocus()
                findViewById<TextView>(R.id.Input_Name).text = parking.get(2).username
                findViewById<TextView>(R.id.Input_Band).text = parking.get(2).carBand
                findViewById<TextView>(R.id.Input_No).text = parking.get(2).carNo
            }
        }
    }
    fun checkSlot() {
        for ( i in 0..parking.size-1){
            if(parking.get(i).username != ""){
                if(i == 0){
                    findViewById<Button>(R.id.freeOne_button).text = "Full"
                }else if(i == 1) {
                    findViewById<Button>(R.id.freeTwo_button).text = "Full"
                }else{
                    findViewById<Button>(R.id.freeThree_button).text = "Full"
                }
            }else{
                if(i == 0){
                    findViewById<Button>(R.id.freeOne_button).text = "Empty"
                }else if(i == 1) {
                    findViewById<Button>(R.id.freeTwo_button).text = "Empty"
                }else{
                    findViewById<Button>(R.id.freeThree_button).text = "Empty"
                }
            }
        }
    }

    fun setInfo () {
        if(selected()){
            if(checkInput()){
                when (selectSlot){
                    R.id.freeOne_button.toString() -> {
                        parking.get(0).username = findViewById<TextView>(R.id.Input_Name).text.toString()
                        parking.get(0).carBand = findViewById<TextView>(R.id.Input_Band).text.toString()
                        parking.get(0).carNo = findViewById<TextView>(R.id.Input_No).text.toString()
                    }
                    R.id.freeTwo_button.toString() -> {
                        parking.get(1).username = findViewById<TextView>(R.id.Input_Name).text.toString()
                        parking.get(1).carBand = findViewById<TextView>(R.id.Input_Band).text.toString()
                        parking.get(1).carNo = findViewById<TextView>(R.id.Input_No).text.toString()
                    }
                    R.id.freeThree_button.toString() -> {
                        parking.get(2).username = findViewById<TextView>(R.id.Input_Name).text.toString()
                        parking.get(2).carBand = findViewById<TextView>(R.id.Input_Band).text.toString()
                        parking.get(2).carNo = findViewById<TextView>(R.id.Input_No).text.toString()
                    }
                }
                clearTextInput()
                Toast.makeText(this , "Successes " , Toast.LENGTH_SHORT).show()
                checkSlot()
                selectSlot = ""
            }else{
                Toast.makeText(this , "Please fill all in put text. " , Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this , "Please select parking slot." , Toast.LENGTH_SHORT).show()
        }
    }

    fun selected() : Boolean {
        if(selectSlot == ""){
            return false
        }else{
            return true
        }
    }
    fun checkInput() : Boolean {
        var slotClick = listOf<TextView>(findViewById(R.id.Input_Name) , findViewById(R.id.Input_Band) , findViewById(R.id.Input_No))
        var flag = true
        for (i in slotClick){
            if(i.text.toString() == ""){
                flag = false
                break
            }
        }

        return flag
    }
    fun clearTextInput() {
        var input = listOf<TextView>(findViewById(R.id.Input_Name) , findViewById(R.id.Input_Band) , findViewById(R.id.Input_No))
        for (i in input){
            i.text = ""
        }
    }
    fun deleteInfo() {
        when(selectSlot){

            R.id.freeOne_button.toString() ->{
                parking[0].username = ""
                parking[0].carBand = ""
                parking[0].carNo = ""
            }
            R.id.freeTwo_button.toString() ->{
                parking[1].username = ""
                parking[1].carBand = ""
                parking[1].carNo = ""
            }
            R.id.freeThree_button.toString() ->{
                parking[2].username = ""
                parking[2].carBand = ""
                parking[2].carNo = ""
            }

        }
        checkSlot()
        clearTextInput()
    }


}










