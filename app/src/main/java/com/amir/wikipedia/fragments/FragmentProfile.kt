package com.amir.wikipedia.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.PackageManagerCompat
import androidx.fragment.app.Fragment
import com.amir.wikipedia.databinding.FragmentProfileBinding
import android.content.pm.PackageManager as PackageManager1

class FragmentProfile : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // if user click on email it will open my email in emailApps
        binding.email.setOnClickListener {
            val email = "amghira1@gmail.com"
            val subject = "Subject of the email"
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$email")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                putExtra(Intent.EXTRA_SUBJECT, subject)
            }
            if (intent.resolveActivity(it.context.packageManager) != null) {
                startActivity(Intent.createChooser(intent, "Choose an email client"))
            } else {
                Toast.makeText(it.context, "No email client found", Toast.LENGTH_SHORT).show()
            }
        }

        // if user click on textView it will open my link-din
        binding.linkdin.setOnClickListener {
            val url = "https://www.linkedin.com/in/your-linkedin-profile/"
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            if (intent.resolveActivity(it.context.packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(it.context, "No application can handle this request. Please install a web browser.", Toast.LENGTH_SHORT).show()
            }
        }

//        it set selectable for card view

//        val card = view.findViewById<MaterialCardView>(R.id.cardMain)
//        card.isChecked = true
//        card.setOnClickListener{
//            card.isChecked = !card.isChecked
//        }


    }
}