package com.example.newvitameanshospital.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.newvitameanshospital.R
import com.example.newvitameanshospital.databinding.FragmentMainBinding
import com.example.newvitameanshospital.ui.myblood.BloodFrag
import com.example.newvitameanshospital.ui.userinfo.UserInfoFragment
import com.example.newvitameanshospital.ui.weight.WeightFragment

class MainFrag : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val userInfoFrag = UserInfoFragment()
        val weightFrag = WeightFragment()
        val bloodFrag = BloodFrag()
        val manager = childFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.user_info_frag, userInfoFrag, userInfoFrag.javaClass.name)
        transaction.replace(R.id.blood_pressure_sugar_frag, bloodFrag, bloodFrag.javaClass.name)
        transaction.replace(R.id.weight_frag, weightFrag, weightFrag.javaClass.name)
        transaction.commit()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            appbarLayout.outlineProvider = null
            svMain.setOnScrollChangeListener { _, _, scrollY, _, _ ->
                if (scrollY > 0) appbarLayout.outlineProvider = ViewOutlineProvider.BOUNDS
                else appbarLayout.outlineProvider = null
            }

            toolbar.setNavigationOnClickListener {
                mainDrawerLayout.open()
            }

            toolbar.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.ic_bell->{
                        findNavController().navigate(R.id.action_mainFrag_to_notificationListFrag)
                        true
                    }

                    R.id.ic_calendar->{
                        findNavController().navigate(R.id.action_mainFrag_to_calendarFrag)
                        true
                    }

                    else -> false
                }
            }
        }
    }
}
