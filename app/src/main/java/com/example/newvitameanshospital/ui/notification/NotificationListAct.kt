package com.example.newvitameanshospital.ui.notification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.newvitameanshospital.R
import com.example.newvitameanshospital.databinding.ActivityNotificationListBinding

class NotificationListAct : AppCompatActivity() {

    lateinit var binding: ActivityNotificationListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_list)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}
