package com.elders.kalfland.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.elders.kalfland.R
import com.elders.kalfland.recyclerview.TodoAdapter
import com.elders.kalfland.databinding.FragmentToDoListBinding
import com.elders.kalfland.dataClass.ToDo
import com.elders.kalfland.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoListFragment : Fragment(R.layout.fragment_to_do_list) {

    private var _binding: FragmentToDoListBinding? = null
    private val binding get() = _binding!!
    private lateinit var todoAdapter: TodoAdapter
    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToDoListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        binding.fabAddTask.setOnClickListener {
            view.findNavController().navigate(
                R.id.action_toDoListFragment_to_addToDoFragment
            )
        }
    }

    private fun setupRecyclerView() {

        todoAdapter = TodoAdapter()

        binding.rvTodoList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = todoAdapter
        }

        viewModel.allToDos.observe(requireActivity()) { listTodo ->
            updateUi(listTodo)
            todoAdapter.mTodo = listTodo
        }
    }

    private fun updateUi(list: List<ToDo>) {
        if (list.isNotEmpty()) {
            binding.rvTodoList.visibility = View.VISIBLE
            binding.cardView.visibility = View.GONE
        } else {
            binding.rvTodoList.visibility = View.GONE
            binding.cardView.visibility = View.VISIBLE
        }
    }


}