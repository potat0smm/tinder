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
import com.example.onboarding.databinding.FragmentLoginBinding


@Suppress("UNREACHABLE_CODE")
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater,container,false)

        binding.btnGoReg.setOnClickListener {
            //var navRegister = activity as RegLogin
            //navRegister.navigateFragment(RegisterFragment(),false)
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnGo.setOnClickListener {
            validateForm()
        }
        return binding.root
    }

    private fun validateForm() {
        val icon = AppCompatResources.getDrawable(requireContext(),R.drawable.baseline_warning_24)

        icon?.setBounds(0,0,icon.intrinsicWidth,icon.intrinsicHeight)
        when{
            TextUtils.isEmpty(binding.login.text.toString().trim())->{
                binding.login.setError("Please Enter Username",icon)
            }
            TextUtils.isEmpty(binding.password.text.toString().trim())->{
                binding.password.setError("Please Enter Password",icon)
            }

            binding.login.text.toString().isNotEmpty() && binding.password.text.toString().isNotEmpty() ->{
                if (binding.login.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))){
                    Toast.makeText(context,"Login Successful",Toast.LENGTH_SHORT).show()
                }
                else{
                    binding.login.setError("Pleas Enter Valid",icon)
                }
            }
        }
    }


}