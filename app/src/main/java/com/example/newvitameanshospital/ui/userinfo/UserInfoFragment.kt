package com.example.newvitameanshospital.ui.userinfo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newvitameanshospital.databinding.FragmentUserInfoBinding
import com.example.newvitameanshospital.ui.education.EducationAct

class UserInfoFragment : Fragment() {

    lateinit var binding: FragmentUserInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEducation.setOnClickListener {
            startActivity(Intent(requireContext(), EducationAct::class.java))
        }
    }
}
