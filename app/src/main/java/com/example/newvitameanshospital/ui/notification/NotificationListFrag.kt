package com.example.newvitameanshospital.ui.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.newvitameanshospital.databinding.FragmentNotificationListBinding

class NotificationListFrag : Fragment() {

    lateinit var binding: FragmentNotificationListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationListBinding.inflate(inflater, container, false)
        return binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }.root
    }
}
