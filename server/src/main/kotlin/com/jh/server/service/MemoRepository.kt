package com.jh.server.service

import com.jh.server.domain.Memo
import org.springframework.data.jpa.repository.JpaRepository


interface MemoRepository : JpaRepository<Memo, Int> {

}