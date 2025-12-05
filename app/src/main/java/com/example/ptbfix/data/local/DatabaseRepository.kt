package com.example.ptbfix.data.local

import com.example.ptbfix.data.local.Note
import com.example.ptbfix.data.local.User
import com.example.ptbfix.data.local.Atlet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton
import dagger.hilt.android.scopes.ViewModelScoped

@Singleton
class DatabaseRepository @Inject constructor(
    private val userDao: UserDao,
    private val noteDao: NoteDao,
    private val atletDao: AtletDao
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
    
    // Atlet operations
    fun getAllAtlets(): Flow<List<Atlet>> = atletDao.getAllAtlets()
    
    suspend fun getAtletByNim(nim: String): Atlet? = atletDao.getAtletByNim(nim)
    
    fun getAtletsByProdi(prodi: String): Flow<List<Atlet>> = atletDao.getAtletsByProdi(prodi)
    
    suspend fun insertAtlet(atlet: Atlet) = atletDao.insertAtlet(atlet)
    
    suspend fun updateAtlet(atlet: Atlet) = atletDao.updateAtlet(atlet)
    
    suspend fun deleteAtlet(atlet: Atlet) = atletDao.deleteAtlet(atlet)
    
    suspend fun deleteAtletByNim(nim: String) = atletDao.deleteAtletByNim(nim)
    
    suspend fun insertDummyAtlets() {
        val dummyAtlets = listOf(
            Atlet("2021001", "Ahmad Rizki", "Teknik Informatika", 85, 90, 88),
            Atlet("2021002", "Siti Nurhaliza", "Sistem Informasi", 78, 82, 80),
            Atlet("2021003", "Budi Santoso", "Teknik Elektro", 92, 85, 90),
            Atlet("2021004", "Dewi Lestari", "Manajemen", 88, 86, 84),
            Atlet("2021005", "Eko Prasetyo", "Akuntansi", 80, 88, 82),
            Atlet("2021006", "Fitri Handayani", "Teknik Mesin", 86, 84, 87),
            Atlet("2021007", "Hendra Wijaya", "Teknik Sipil", 90, 89, 91),
            Atlet("2021008", "Indah Permata", "Psikologi", 83, 81, 85),
            Atlet("2021009", "Joko Widodo", "Hukum", 87, 83, 86),
            Atlet("2021010", "Kartika Sari", "Kedokteran", 91, 87, 89)
        )
        atletDao.insertAtlets(dummyAtlets)
    }
}
