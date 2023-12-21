package com.jh.server.controller

import com.jh.server.domain.Memo
import com.jh.server.domain.ResponseData
import com.jh.server.service.MemoRepository
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/memo")
class MemoController {

    @Autowired
    private lateinit var repo: MemoRepository

    @GetMapping("")
    fun list() : List<Memo> {
        return repo.findAll().toList()
//        return list.toList()
    }

    @PostMapping("")
    fun new() : ResponseEntity<ResponseData> {
        val newId = repo.findAll().toList().size
        val newMemo = Memo(id=newId, content = "", isDone = false)
        repo.save(newMemo)
        return ResponseEntity.ok(ResponseData(newId, true))
    }

    @PutMapping("/{id}")
    @CrossOrigin
    fun put(@PathVariable id: Int , @RequestBody memo: Memo) : ResponseEntity<ResponseData> {
        repo.save(memo)
        return ResponseEntity.ok(ResponseData(id, true))
    }
}
