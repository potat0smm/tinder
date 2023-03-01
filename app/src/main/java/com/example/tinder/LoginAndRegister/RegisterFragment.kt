package com.example.tinder.LoginAndRegister

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.fragment.findNavController
import com.example.onboarding.R
import com.example.onboarding.databinding.ActivityMainBinding
import com.example.onboarding.databinding.FragmentFirstScreenBinding
import com.example.onboarding.databinding.FragmentRegisterBinding
import org.w3c.dom.Text


@Suppress("UNREACHABLE_CODE")
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater,container,false)

        binding.goLogin.setOnClickListener {
            //var navRegister = activity as RegLogin
            //navRegister.navigateFragment(RegisterFragment(),false)
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.goRegStart.setOnClickListener {
            validateForm()
        }

        return binding.root
    }

    private fun validateForm(){
        val icon = AppCompatResources.getDrawable(requireContext(),R.drawable.baseline_warning_24)

        icon?.setBounds(0,0,icon.intrinsicWidth,icon.intrinsicHeight)
        when {
            TextUtils.isEmpty(binding.regLogin.text.toString().trim()) -> {
                binding.regLogin.setError("Please Enter Username", icon)
            }
            TextUtils.isEmpty(binding.regPassword.text.toString().trim()) -> {
                binding.regPassword.setError("Please Enter Password", icon)
            }
            TextUtils.isEmpty(binding.regLogin.text.toString().trim()) -> {
                binding.regLogin.setError("Please Enter Login")
            }
            binding.regLogin.text.toString().isNotEmpty() &&
                    binding.regLogin.text.toString().isNotEmpty() &&
                    binding.regPassword.text.toString().isNotEmpty() -> {
                if (binding.cnfPassword.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))
                ) {
                    if (binding.regPassword.text.toString().length >= 5) {
                        if (binding.regPassword.text.toString() == binding.cnfPassword.text.toString()) {
                            Toast.makeText(context, "Register Successful", Toast.LENGTH_SHORT).show()
                        }
                        else {
                            binding.cnfPassword.setError("Password didn't match", icon)
                        }
                }
                    else{
                        binding.regPassword.setError("Please Enter at least 5 character",icon)
                    }
            }else{

                }
        }
        }
    }

}