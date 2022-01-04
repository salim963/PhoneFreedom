package dtu.projekt.phonefreedom

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dtu.projekt.phonefreedom.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

import android.content.Intent
import android.widget.EditText
import androidx.navigation.findNavController


class MainActivity : AppCompatActivity() {

    //TODO Forbind API Til Messenger          (Ali J)
    //TODO Forbind API Til Telegram           /*ALi D*/
    //TODO Forbind API Til Snapchat
    //TODO Forbind API Til Whatsapp          /*salim*/
    //TODO Forbind API Til Instagram         /*Thomas*/
    //TODO Forbind API Til Besked            /*salim*/
    //TODO Forbind API Til Opkald
    //TODO Forbind API Til E-mail             ( Ali J)
    //TODO Settings fragment
    //TODO Settings -> Sprogindstillinger
    //TODO Settings -> Animationer ON / OFF
    //TODO Som bruger, ønsker jeg at kunne slå appen til med en On / Off funktion så appen er let at anvende.
    //TODO Ny urfunktion i henhold til PO's ønske på discord
    //TODO Billede / Logo med link i auto reply, som bruges til at videresende til enten App store / Play store.
    //TODO Slå alle applikationer til / fr  /*salim*/

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
     //   val navController = findNavController(R.id.settings)
        setContentView(view)
        addTime()
        addClickListeners()
        appButton()
        showMenu()
    }



    private fun addClickListeners(){
        binding.buttonSelectPredefinedMessage.setOnClickListener {
            val myIntent = Intent(this, PredefinedMessagesActivity::class.java)
            this.startActivityForResult(myIntent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode === 1) {
            if (resultCode === RESULT_OK) {
                val predefinedMessage: String? = data?.getStringExtra ("Extra_SelectedPredefinedMessage")
                var predefinedMessageEditText = findViewById<EditText>(R.id.editTextAutoText)
                predefinedMessageEditText.setText(predefinedMessage)
            }
            if (resultCode === RESULT_CANCELED) {

            }
        }
    }

// HelloAlijan
    private fun addTime() {
        binding.addTime.setOnClickListener{
            val cal = Calendar.getInstance()
            val timeListen = TimePickerDialog.OnTimeSetListener{timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                binding.editTextFreeTo.setText(SimpleDateFormat("HH:mm").format(cal.time))
            }
            TimePickerDialog(this, timeListen, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
            val secondTime = TimePickerDialog.OnTimeSetListener{timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                binding.editTextFreeFrom.setText(SimpleDateFormat("HH:mm").format(cal.time))
            }
            TimePickerDialog(this, secondTime, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()

        }
    }

    private fun appButton() {
        binding.whatsappButton.setOnClickListener {
            binding.whatsappButton.isSelected = !binding.whatsappButton.isSelected
        }
        binding.CallButton.setOnClickListener {
            binding.CallButton.isSelected = !binding.CallButton.isSelected
        }
        binding.SnapchatButton.setOnClickListener {
            binding.SnapchatButton.isSelected = !binding.SnapchatButton.isSelected
        }
        binding.EmailButton.setOnClickListener {
            binding.EmailButton.isSelected = !binding.EmailButton.isSelected
        }
        binding.messengerButton.setOnClickListener {
            binding.messengerButton.isSelected = !binding.messengerButton.isSelected
        }
        binding.TelegramButton.setOnClickListener {
            binding.TelegramButton.isSelected = !binding.TelegramButton.isSelected
        }
        binding.InstagramButton.setOnClickListener {
            binding.InstagramButton.isSelected = !binding.InstagramButton.isSelected
        }
        binding.MessageButton.setOnClickListener {
            binding.MessageButton.isSelected = !binding.MessageButton.isSelected
        }


    }

    private fun showMenu() {
        binding.toSettings.setOnClickListener{
            val intent = Intent(this, LanguageActivity::class.java)
            this.startActivity(intent)
        }
    }


}
