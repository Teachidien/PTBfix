package com.example.ptbfix.data.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseRepository @Inject constructor(
    private val userDao: UserDao,
    private val noteDao: NoteDao
) {
    
    // User operations
    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()
    
    suspend fun getUserById(id: Long): User? = userDao.getUserById(id)
    
    suspend fun getUserByEmail(email: String): User? = userDao.getUserByEmail(email)
    
    suspend fun insertUser(user: User): Long = userDao.insertUser(user)
    
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)
    
    suspend fun deleteUserById(id: Int) = userDao.deleteUserById(id)
    
    // Note operations
    fun getAllNotes(): Flow<List<Note>> = noteDao.getAllNotes()
    
    fun getNotesByUserId(userId: Long): Flow<List<Note>> = noteDao.getNotesByUserId(userId)
    
    suspend fun getNoteById(id: Long): Note? = noteDao.getNoteById(id)
    
    suspend fun insertNote(note: Note): Long = noteDao.insertNote(note)
    
    suspend fun updateNote(note: Note) = noteDao.updateNote(note)
    
    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
    
    suspend fun deleteNoteById(id: Int) = noteDao.deleteNoteById(id)
    
    suspend fun deleteNotesByUserId(userId: Long) = noteDao.deleteNotesByUserId(userId)
}
