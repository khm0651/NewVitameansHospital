package com.example.newvitameanshospital.ui.userinfo

import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.example.newvitameanshospital.databinding.FragmentUserInfoBinding
import com.example.newvitameanshospital.ui.VitaMainFragPart
import com.google.android.material.snackbar.Snackbar

class UserInfoFrag : VitaMainFragPart<FragmentUserInfoBinding>() {

    override fun onCreateView(view: View, lifecycleOwner: LifecycleOwner) {
        super.onCreateView(view, lifecycleOwner)
        print("hi")
    }

    override fun onViewCreated() {
        binding.btnManage.setOnClickListener {
            Snackbar.make(it, "hi", Snackbar.LENGTH_LONG).show()
        }
    }
}
