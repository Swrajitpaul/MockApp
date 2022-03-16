package io.github.swrajitpaul.ui.projects

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.swrajitpaul.R
import io.github.swrajitpaul.data.Projects

class ProjectRecyclerAdapter(val context: Context,
                            val projects: List<Projects>, val itemListener: ProjectItemListener): RecyclerView.Adapter<ProjectRecyclerAdapter.ViewHolder>() {


    override fun getItemCount() = projects.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProjectRecyclerAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.project_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProjectRecyclerAdapter.ViewHolder, position: Int) {
        val project = projects[position]
        with(holder) {
            nameText?.let {
                it.text = project.projectName
            }
            holder.itemView.setOnClickListener {
                itemListener.onProjectItemClick(project)
            }
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameText = itemView.findViewById<TextView>(R.id.projectName)
    }

    interface ProjectItemListener {
        fun onProjectItemClick(projects: Projects)
    }
}