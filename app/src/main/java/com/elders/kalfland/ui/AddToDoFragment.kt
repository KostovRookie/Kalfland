package com.elders.kalfland.ui

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.elders.kalfland.R
import com.elders.kalfland.databinding.FragmentAddToDoBinding
import com.elders.kalfland.dataClass.ToDo
import com.elders.kalfland.viewmodel.ViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddToDoFragment : Fragment(R.layout.fragment_add_to_do) {

    private var _binding: FragmentAddToDoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddToDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddTask.setOnClickListener { mView ->
            saveNote(mView)
        }

        binding.btnCancel.setOnClickListener {
            binding.etTodoName.text.clear()
            view.findNavController().navigate(
                R.id.action_addToDoFragment_to_toDoListFragment
            )
        }
    }

    private fun saveNote(view: View) {
        val todoName = binding.etTodoName.text.toString()

        if (todoName.isNotEmpty()) {
            val todo = ToDo(0, todoName)

            viewModel.insertToDo(todo)

            Snackbar.make(view, "Успешно запазено",
                Snackbar.LENGTH_SHORT).show()

            view.findNavController().navigate(
                R.id.action_addToDoFragment_to_toDoListFragment
            )

        } else {
            val toast = Toast.makeText(activity,
                "Не може полето да е празно",
                Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }
}