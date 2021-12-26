package com.chimber.debtislav.service

import com.chimber.debtislav.exception.GroupNotFoundException
import com.chimber.debtislav.exception.UserNotFoundException
import com.chimber.debtislav.model.Group
import com.chimber.debtislav.model.User
import com.chimber.debtislav.repository.GroupRepository
import com.chimber.debtislav.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class GroupService(
    private val groupRepository: GroupRepository,
    private val userRepository: UserRepository
) {
    private fun getUserOrThrow(username: String): User {
        return userRepository.findByUsername(username).orElseThrow {
            UserNotFoundException("No user with name $username exists")
        }
    }

    private fun getGroupOrThrow(groupId: Long): Group {
        return groupRepository.findById(groupId).orElseThrow {
            GroupNotFoundException("No group with id $groupId exists")
        }
    }

    fun addToGroup(username: String, groupId: Long) {
        val user = getUserOrThrow(username)
        val group = getGroupOrThrow(groupId)
        group.userList.add(user)
        groupRepository.save(group)
    }

    fun createGroup(username: String, groupName: String): Long {
        val user = getUserOrThrow(username)
        val group = Group(name = groupName)
        group.userList.add(user)
        groupRepository.save(group)
        return group.id
    }

    fun getAllUsers(groupId: Long): List<String> {
        val group = getGroupOrThrow(groupId)
        return group.userList.map { it.username }.toList()
    }
}