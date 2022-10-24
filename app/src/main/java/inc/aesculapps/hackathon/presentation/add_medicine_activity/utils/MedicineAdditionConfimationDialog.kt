package inc.aesculapps.hackathon.presentation.add_medicine_activity.utils

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.RadioGroup
import androidx.core.view.size
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.DialogFragmentNavigatorDestinationBuilder
import inc.aesculapps.hackathon.R
import inc.aesculapps.hackathon.databinding.DialogfragmentMedicineaddconfirmationBinding

class MedicineAdditionConfimationDialog: DialogFragment() {

    private lateinit var binding: DialogfragmentMedicineaddconfirmationBinding

    lateinit var  addBtnOnClickCallBack : ()->Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        binding = DialogfragmentMedicineaddconfirmationBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog!!.window!!.setLayout(MATCH_PARENT, MATCH_PARENT)

        binding.textInputLayoutFirstConsumptionTime.visibility = View.GONE
        binding.textInputLayoutSecondConsumptionTime.visibility = View.GONE
        binding.textInputLayoutThirdConsumptionTime.visibility = View.GONE


        binding.radioGroupConsumptionTime.setOnCheckedChangeListener(object: RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                when(p1){
                    binding.radioButtonConsumptionTimeOnce.id -> {
                        binding.textInputLayoutFirstConsumptionTime.visibility = View.VISIBLE
                        binding.textInputLayoutSecondConsumptionTime.visibility = View.GONE
                        binding.textInputLayoutThirdConsumptionTime.visibility = View.GONE
                    }
                    binding.radioButtonConsumptionTimeTwice.id -> {
                        binding.textInputLayoutFirstConsumptionTime.visibility = View.VISIBLE
                        binding.textInputLayoutSecondConsumptionTime.visibility = View.VISIBLE
                        binding.textInputLayoutThirdConsumptionTime.visibility = View.GONE
                    }
                    binding.radioButtonConsumptionTimeThrice.id -> {
                        binding.textInputLayoutFirstConsumptionTime.visibility = View.VISIBLE
                        binding.textInputLayoutSecondConsumptionTime.visibility = View.VISIBLE
                        binding.textInputLayoutThirdConsumptionTime.visibility = View.VISIBLE
                    }
                }
            }
        })

        binding.textInputEditTextFirstConsumptionTime.setText("")
        binding.textInputEditTextSecondConsumptionTime.setText("")
        binding.textInputEditTextThirdConsumptionTime.setText("")

        binding.addBtn.setOnClickListener {
            addBtnOnClickCallBack()
        }






    }

}