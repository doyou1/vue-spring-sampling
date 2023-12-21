package com.jh.server.domain

import jakarta.persistence.*

@Entity
data class Memo(@Id @GeneratedValue val id: Int = 0, @Column val content: String = "", @Column(name="isdone") val isDone: Boolean = false);
