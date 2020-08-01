package com.example.dacaco.utils

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.text.Editable
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.dacaco.R
import com.example.dacaco.databinding.DialogCharNameBinding
import com.example.dacaco.models.Character
import org.greenrobot.eventbus.EventBus


class DialogCompanion {
    companion object {
        fun editName(context: Context, layoutInflater: LayoutInflater) {
            val dialog = Dialog(context)
            val d = DialogCharNameBinding.inflate(layoutInflater)
            dialog.setContentView(d.root)
            if (CharacterSingleton.character != null) d.nameInput.text =
                Editable.Factory.getInstance().newEditable(CharacterSingleton.character!!.name)
            d.okBtn.setOnClickListener {
                if (d.nameInput.text.toString().isNotEmpty()) {
                    CharacterSingleton.character = Character(d.nameInput.text.toString())
                    EventBus.getDefault().post(MessageType.EditName)
                    dialog.dismiss()
                } else {
                    d.nameInput.error = context.getString(R.string.error_input)
                }
            }
            d.cancelBtn.setOnClickListener { dialog.dismiss() }
            dialog.show()
        }

        fun areYouSure(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Are you sure?")
                .setPositiveButton(
                    context.getString(R.string.ok)
                ) { dialog, _ ->
                    EventBus.getDefault().post(MessageType.OK)
                    dialog.dismiss()
                }
                .setNegativeButton(
                    context.getString(R.string.cancel)
                ) { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }


}